package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ntgclarity.smartcompound.common.constatnt.MessagesKeys;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.common.spring.applicationcontext.SpringApplicationContext;
import com.ntgclarity.smartcompound.mail.Mail;
import com.ntgclarity.smartcompound.mail.Mailer;
import com.ntgclarity.smartcompound.portal.base.BaseBean;
import com.ntgclarity.smartcompound.portal.utils.WebUtils;

@ManagedBean
@ViewScoped
public class LoginBean extends BaseBean implements Serializable {

	static final Logger logger = LogManager
			.getLogger(LoginBean.class.getName());

	@ManagedProperty(value = "#{customAuthenticationProvider}")
	private AuthenticationProvider authenticationProvider;

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

	public void login() throws SmartCompoundException {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userName, password);

		Authentication authentcation = authenticationProvider
				.authenticate(usernamePasswordAuthenticationToken);

		SecurityContextHolder.getContext().setAuthentication(authentcation);
		WebUtils.injectIntoSession("SPRING_SECURITY_CONTEXT",
				SecurityContextHolder.getContext());

		logger.info("throw exception ");

		// addInfoMessage(MessagesKeys.SMART_COMPOUND_LOGIN_INFO_MSG);
		// System.out.println("Authenticated");
		 throw new SmartCompoundException(MessagesKeys.SMART_COMPOUND_LOGIN_USER_NAME);
		// throw new
		// NullPointerException("throw***** new NullPointerException");
//		throw new AbortProcessingException("Done!!");

	}

	/** 
	 * adding by karim 
	 **/
	public void forgetPassword() {
		Mail mail = new Mail();
		mail.setMailFrom("karimmm.fadel@gmail.com");
		mail.setMailTo("kiko.fadel1991@gmail.com");
		mail.setMailSubject("Subject - Send Email using Spring  Velocity Template");
//		mail.setMailContent("Simple Example to send email using Spring");
		mail.setTemplateName("emailtemplate.vm");

		Mailer mailer = (Mailer) SpringApplicationContext
				.getApplicationContext().getBean("mailer");
		mailer.sendMail(mail);

		logger.info("Send Email success ");

		addInfoMessage(MessagesKeys.SMART_COMPOUND_LOGIN_INFO_MSG);
	}

	public AuthenticationProvider getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(
			AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
}