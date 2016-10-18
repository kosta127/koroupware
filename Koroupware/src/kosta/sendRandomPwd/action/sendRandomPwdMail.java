package kosta.sendRandomPwd.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;

import kosta.sendRandomPwd.model.SMTP;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import java.util.Properties;

public class sendRandomPwdMail implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("dkvk");
		ActionForward forward = new ActionForward();
		response.setCharacterEncoding("EUC-KR");
		HttpSession session1 = request.getSession();
		String randomChar = null;
		String Array[];
		Array = new String[8];

		for (int i = 0; i < 8; i++) {
			int randomValue = (int) (Math.random() * 35) + 0;
			System.out.println("랜덤 수: " + randomValue);
			for (int j = 0; j < 8; j++) {
				if (randomValue == 0) {
					randomChar = "0";
					Array[i] = randomChar;
				} else if (randomValue == 1) {
					randomChar = "1";
					Array[i] = randomChar;
				} else if (randomValue == 2) {
					randomChar = "2";
					Array[i] = randomChar;
				} else if (randomValue == 3) {
					randomChar = "3";
					Array[i] = randomChar;
				} else if (randomValue == 4) {
					randomChar = "4";
					Array[i] = randomChar;
				} else if (randomValue == 5) {
					randomChar = "5";
					Array[i] = randomChar;
				} else if (randomValue == 6) {
					randomChar = "6";
					Array[i] = randomChar;
				} else if (randomValue == 7) {
					randomChar = "7";
					Array[i] = randomChar;
				} else if (randomValue == 8) {
					randomChar = "8";
					Array[i] = randomChar;
				} else if (randomValue == 9) {
					randomChar = "9";
					Array[i] = randomChar;
				} else if (randomValue == 10) {
					randomChar = "A";
					Array[i] = randomChar;
				} else if (randomValue == 11) {
					randomChar = "B";
					Array[i] = randomChar;
				} else if (randomValue == 12) {
					randomChar = "C";
					Array[i] = randomChar;
				} else if (randomValue == 13) {
					randomChar = "E";
					Array[i] = randomChar;
				} else if (randomValue == 14) {
					randomChar = "F";
					Array[i] = randomChar;
				} else if (randomValue == 15) {
					randomChar = "G";
					Array[i] = randomChar;
				} else if (randomValue == 16) {
					randomChar = "H";
					Array[i] = randomChar;
				} else if (randomValue == 17) {
					randomChar = "I";
					Array[i] = randomChar;
				} else if (randomValue == 18) {
					randomChar = "J";
					Array[i] = randomChar;
				} else if (randomValue == 19) {
					randomChar = "K";
					Array[i] = randomChar;
				} else if (randomValue == 20) {
					randomChar = "L";
					Array[i] = randomChar;
				} else if (randomValue == 21) {
					randomChar = "M";
					Array[i] = randomChar;
				} else if (randomValue == 22) {
					randomChar = "N";
					Array[i] = randomChar;
				} else if (randomValue == 23) {
					randomChar = "O";
					Array[i] = randomChar;
				} else if (randomValue == 24) {
					randomChar = "P";
					Array[i] = randomChar;
				} else if (randomValue == 25) {
					randomChar = "Q";
					Array[i] = randomChar;
				} else if (randomValue == 26) {
					randomChar = "R";
					Array[i] = randomChar;
				} else if (randomValue == 27) {
					randomChar = "S";
					Array[i] = randomChar;
				} else if (randomValue == 28) {
					randomChar = "T";
					Array[i] = randomChar;
				} else if (randomValue == 29) {
					randomChar = "U";
					Array[i] = randomChar;
				} else if (randomValue == 30) {
					randomChar = "V";
					Array[i] = randomChar;
				} else if (randomValue == 31) {
					randomChar = "W";
					Array[i] = randomChar;
				} else if (randomValue == 32) {
					randomChar = "X";
					Array[i] = randomChar;
				} else if (randomValue == 33) {
					randomChar = "Y";
					Array[i] = randomChar;
				} else if (randomValue == 34) {
					randomChar = "Z";
					Array[i] = randomChar;
				} else if (randomValue == 35) {
					randomChar = "Z";
					Array[i] = randomChar;
				} else {
					randomChar = "Z";
					Array[i] = randomChar;
				}

			}
			System.out.println("랜덤 값" + randomChar);
		}

		String value = Array[0] + Array[1] + Array[2] + Array[3] + Array[4] + Array[5] + Array[6] + Array[7];
		System.out.println(value);

		String from = "sdc337dc@naver.com";
		String to = "sdc337dc@naver.com";//(String) session1.getAttribute("sendemail_to");
		String subject = "임시비밀번호 입니다";
		String content = value;
		request.setAttribute("pwd", value);
		// 입력값 받음
		System.out.println(from);
		System.out.println(to);
		System.out.println(subject);
		System.out.println(content);

		Properties p = new Properties(); // 정보를 담을 객체

		p.put("mail.smtp.host", "smtp.naver.com"); // 네이버 SMTP

		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들

		try{
		    Authenticator auth = new SMTP();
		    Session ses = Session.getInstance(p, auth);
		     
		    ses.setDebug(true);
		     
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    msg.setSubject(subject); // 제목
		     
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); // 보내는 사람
		     
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		     
		    msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩
		     
		    Transport.send(msg); // 전송
		} catch(Exception e){
		    e.printStackTrace();
		    // 오류 발생시 뒤로 돌아가도록
		    forward.setPath("login.jsp");
		    forward.setRedirect(false);
		    return forward;
		}
		forward.setPath("sendRandomPwd.do?pwd="+value);
		forward.setRedirect(false);
		return forward;
	}

}
