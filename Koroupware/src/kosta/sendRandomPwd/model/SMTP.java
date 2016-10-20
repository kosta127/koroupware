package kosta.sendRandomPwd.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
 
public class SMTP extends Authenticator{
 
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("sdc337dc@naver.com","tnwla7845!@#");
    }
}
