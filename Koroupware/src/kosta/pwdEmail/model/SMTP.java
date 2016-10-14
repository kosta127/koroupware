package kosta.pwdEmail.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTP  extends Authenticator{

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return super.getPasswordAuthentication();
	}
		
}
