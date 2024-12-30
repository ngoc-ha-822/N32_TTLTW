package com.fit.nlu.DHHCeramic.controller.admin.contact;

import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Contact;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.ContactService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ContactServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Admin/contact/list"})
public class ContactListController extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contact> contactList = contactService.getAll();
        request.setAttribute("contactList",contactList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/table-data-contact.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

