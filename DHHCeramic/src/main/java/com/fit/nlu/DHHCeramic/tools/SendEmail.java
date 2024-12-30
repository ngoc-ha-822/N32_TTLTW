package com.fit.nlu.DHHCeramic.tools;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

public class SendEmail {
    private final static String username = "dhhceramic@gmail.com";
    private final static String password = "lyqtayuqdrwmrkwv";
    public String getRandom() {
        //tạo code đăng ký
        Random rd = new Random();
        int code = rd.nextInt(999999);
        String randomCode = String.format("%06d", code);
        System.out.println("Random Code: " + randomCode); // In giá trị ra console
        return randomCode;
    }

    public static void sendMail(String to, String subject, String text) {
        // Khai bảo các thuộc tính cấu hình gửi mail
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");       // Host: smtp.gmail.com (Gmail)
        prop.put("mail.smtp.port", "587");                 // Port: 587 (TLS)
        prop.put("mail.smtp.auth", "true");               // Authentication: true
        prop.put("mail.smtp.starttls.enable", "true");    // Start TLS: true

        // Tạo ra một Authenticator để đăng nhập vào tài khoản gửi mail
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        // Tạo ra phiên làm việc của JavaMail (Khác với Session trong Servlet)
        Session session = Session.getInstance(prop, auth);
        // Gửi email
        try {
            Message message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/HTML; charset=UTF-8");
            message.addHeader("format", "flowed");
            message.addHeader("Content-Transfer-Encoding", "8bit");
            message.setFrom(new InternetAddress(username, "DHH Ceramic"));
            InternetAddress[] toAdd = {new InternetAddress(to)};
            message.setSubject(subject);
            message.setText(text);
            message.setSentDate(new Date());
            message.setRecipients(Message.RecipientType.TO, toAdd);
            Transport.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    }

}

