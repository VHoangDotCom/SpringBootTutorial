# Spring Send Mail( SendMail )
##1. Dependencies ( remember choose V2.6.11 )
- Java mail sender

##2. Manage Google -> Security -> Add App password

##3. Config file application.properties
   spring.mail.host=smtp.gmail.com
   spring.mail.port=587
   spring.mail.username=viethoang2001gun@gmail.com
   spring.mail.password=gzghqjgukmjjkwaf
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true

##4. Create Mail Content in EmailSenderService

    public void sendMailWithAttachment(String toEmail,
    String body,
    String subject,
    String attachment) throws MessagingException {
    MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("viethoang2001gun@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource =
                new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");
    }

##5. Call EmailSender method in void main

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
    service.sendMailWithAttachment("viethoang2001gun@gmail.com",
    "This is the Email Body...",
    "This is Email Subject",
    "D:\\Themes\\Anime\\1.jpg");
    }