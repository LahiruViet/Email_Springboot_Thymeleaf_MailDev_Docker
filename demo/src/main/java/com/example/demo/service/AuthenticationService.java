package com.example.demo.service;

import com.example.demo.email.EmailService;
import com.example.demo.email.EmailTemplateName;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final EmailService emailService;

  @Value("${application.mailing.frontend.activation-url}")
  private String activationUrl;

  public void register() throws MessagingException {
    sendValidationEmail();
  }

  private void sendValidationEmail() throws MessagingException {

    emailService.sendEmail(
            "to@test.com",
            "John Doe",
            EmailTemplateName.ACTIVATE_ACCOUNT,
            activationUrl,
            "279310",
            "Account activation"
    );
  }
}
