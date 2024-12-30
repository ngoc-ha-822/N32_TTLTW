package com.fit.nlu.DHHCeramic.controller.client;


import com.fit.nlu.DHHCeramic.model.Contact;
import com.fit.nlu.DHHCeramic.services.ContactService;
import com.fit.nlu.DHHCeramic.services.impl.ContactServiceImpl;
import com.fit.nlu.DHHCeramic.tools.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "SendContactController", value = "/sendContact")
public class SendContactController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        String alert = "";
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        Contact contact = new Contact(random.nextInt(1000), name, email, title, message);
        ContactService contactService = new ContactServiceImpl();
        contactService.insert(contact);
        alert = "Đã gửi liên hệ thành công!";
        SendEmail sm = new SendEmail();
        sm.sendMail("dhhceramic@gmail.com", "Customer contact", " Name: " + name + " Email: " + email + "Title: " + title);
        request.setAttribute("alert", alert);
        request.getRequestDispatcher("view/client/view/contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
