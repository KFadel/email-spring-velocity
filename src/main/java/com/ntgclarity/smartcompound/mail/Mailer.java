package com.ntgclarity.smartcompound.mail;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.ntgclarity.smartcompound.mail.Mail;

/** 
 * adding by karim 
 **/
public class Mailer {

	private MailSender mailSender;

	private VelocityEngine velocityEngine;

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getMailFrom());
		message.setTo(mail.getMailTo());
		message.setSubject(mail.getMailSubject());
		// message.setText(mail.getMailContent());
		Template template = velocityEngine.getTemplate("./templates/"
				+ mail.getTemplateName());

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("firstName", "Karim");
		velocityContext.put("lastName", "Mostafa");
		velocityContext.put("location", "Alexandria");

		StringWriter stringWriter = new StringWriter();

		template.merge(velocityContext, stringWriter);

		message.setText(stringWriter.toString());

		mailSender.send(message);
	}
}
