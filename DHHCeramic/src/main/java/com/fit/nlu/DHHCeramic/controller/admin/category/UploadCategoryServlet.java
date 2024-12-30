package com.fit.nlu.DHHCeramic.controller.admin.category;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fit.nlu.DHHCeramic.dao.CategoryDao;
import com.fit.nlu.DHHCeramic.dao.impl.CategoryDaoImpl;
import com.fit.nlu.DHHCeramic.model.Category;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet(urlPatterns = {"/Admin/cate/uploadCategory"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50,      // 50MB
        maxRequestSize = 1024 * 1024 * 100   // 100MB
)
public class UploadCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao = new CategoryDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);

        String uploadDir = "D:/TaiLieuLNH/HK2Nam3/TTLTW/TestExcel";
        File uploadsDir = new File(uploadDir);
        if (!uploadsDir.exists()) {
            uploadsDir.mkdirs();
        }

        File file = new File(uploadsDir, fileName);
        if (file.exists()) {
            file = new File(uploadsDir, System.currentTimeMillis() + "_" + fileName);
        }

        try {
            filePart.write(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServletException("Cannot write uploaded file to disk!", e);
        }

        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Category cate = new Category();

                cate.setStatus((int) row.getCell(0).getNumericCellValue());
                cate.setName(getCellValueAsString(row.getCell(1)));
                cate.setStatus((int) row.getCell(2).getNumericCellValue());
                cate.setCreatedBy(getCellValueAsString(row.getCell(3)));

                Date createdDate = null;
                Cell createdDateCell = row.getCell(4);
                if (createdDateCell != null) {
                    if (createdDateCell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(createdDateCell)) {
                        createdDate = createdDateCell.getDateCellValue();
                    } else {
                        try {
                            createdDate = dateFormat.parse(getCellValueAsString(createdDateCell));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                cate.setCreatedDate(createdDate);

                categoryDao.insert(cate);
            }
        }

        response.sendRedirect(request.getContextPath() + "/Admin/cate/list");
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    return dateFormat.format(cell.getDateCellValue());
                }
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
