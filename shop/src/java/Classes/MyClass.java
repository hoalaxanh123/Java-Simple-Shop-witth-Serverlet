package Classes;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class MyClass {

    public static int TinSoTrang(int soLuong, int soSPTrenTrang) {
        if (soLuong < soSPTrenTrang) {
            return 1;
        }
        int kq = soLuong / soSPTrenTrang;
        if (soLuong % soSPTrenTrang > 0) {
            kq = kq + 1;
        }
        return kq;
    }

    public static void main(String[] args) {
        sendMail("herodotkich@gmail.com", "Bạn có đơn hàng", "Test send mail");
    }

    public static boolean sendMail(String strTo, String Subject, String strMsg) {
        boolean result = false;
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        javax.mail.Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("trashmailtest804@gmail.com", "huynhvade");
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress("trashmailtest804@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(strTo));
            message.setSubject(Subject, "UTF-8");
            message.setText(strMsg, "UTF-8");
            Transport.send(message);
            result = true;
        } catch (MessagingException ex) {
            result = false;
        } finally {
            return result;
        }
    }
}
