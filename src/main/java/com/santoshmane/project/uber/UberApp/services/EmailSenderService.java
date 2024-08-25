package com.santoshmane.project.uber.UberApp.services;

public interface EmailSenderService {

    void sendEmail(String toEmail, String subject, String body);

    void sendEmail(String toEmail[], String subject, String body);

}
