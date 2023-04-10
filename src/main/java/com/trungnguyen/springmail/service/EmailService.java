
package com.trungnguyen.springmail.service;

import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    private final TemplateEngine htmlTemplateEngine;

    /* 
     * Send HTML mail (simple) 
     */
    public void sendSimpleMail(String subject, String recipientEmail,
                               String template, Map<String, Object> templateModel)
            throws MessagingException {

        // Prepare the evaluation context
        final Context ctx = new Context();
        ctx.setVariables(templateModel);

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject(subject);
        message.setTo(recipientEmail);

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(template, ctx);
        message.setText(htmlContent, true);

        // Send email
        this.mailSender.send(mimeMessage);
    }


    /* 
     * Send HTML mail with attachment. 
     */
    public void sendMailWithAttachment(String subject, String recipientEmail, String template,
                                       Map<String, Object> templateModel, String attachmentFileName,
                                       byte[] attachmentBytes, String attachmentContentType)
        throws MessagingException {

        // Prepare the evaluation context
        final Context ctx = new Context();
        ctx.setVariables(templateModel);

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message
            = new MimeMessageHelper(mimeMessage, true /* multipart */, "UTF-8");
        message.setSubject(subject);
        message.setTo(recipientEmail);

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(template, ctx);
        message.setText(htmlContent, true /* isHtml */);

        // Add the attachment
        final InputStreamSource attachmentSource = new ByteArrayResource(attachmentBytes);
        message.addAttachment(
            attachmentFileName, attachmentSource, attachmentContentType);

        // Send mail
        this.mailSender.send(mimeMessage);
    }
}
