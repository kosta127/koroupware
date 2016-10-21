package kosta.etc;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

public class ETC {
	private static Map<String, String> loginNotNeedPageMap;
	
	static {
		loginNotNeedPageMap = new HashMap<String, String>();
		
		loginNotNeedPageMap.put("loginGo.do", "Y");
		loginNotNeedPageMap.put("LoginProcessAction.do", "Y");	
		loginNotNeedPageMap.put("FindIdProcess.do", "Y");	
		loginNotNeedPageMap.put("fail.do", "Y");	
		loginNotNeedPageMap.put("FindIdProcess.do", "Y");	
		loginNotNeedPageMap.put("FindPasswordProcess.do", "Y");	
		loginNotNeedPageMap.put("MakeAction.do", "Y");	
		loginNotNeedPageMap.put("SignUpAction.do", "Y");	
		loginNotNeedPageMap.put("SignUpdate.do", "Y");	
		loginNotNeedPageMap.put("sendRandomPwdMail.do", "Y");	
		loginNotNeedPageMap.put("sendRandomPwd.do", "Y");	
		loginNotNeedPageMap.put("SearchAction.do", "Y");
		loginNotNeedPageMap.put("find.do", "Y");
		loginNotNeedPageMap.put("FindAction.do", "Y");
	}
	
	public static boolean isNotNull(Object object){
		//null값이 아닌지 확인
		if(object == null){
			return false;
		}
		
		return true;
	}
	
	public static boolean isCommit(int result){
		if(result > 0){
			return true;
		}
		
		return false;
	}
	
	public static void commit(SqlSession session, int result){
		if(ETC.isCommit(result)){
			session.commit();
		}else{
			session.rollback();
		}
	}
	
	public static String toTelephoneFormat(String telephone){
		//전화번호 양식으로 포맷
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		
		if(Pattern.matches(regEx, telephone)){
			if(telephone.length() == 10 && telephone.startsWith("02")){
				telephone = telephone.replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-$2-$3");
			}else{
				telephone = telephone.replaceAll(regEx, "$1-$2-$3");
			}
		}
		
		return telephone;
	}
	
	public static boolean isLoginNeedCeck(String key){
		//로그인이 필요한 페이지인지 체크
		if(isNotNull(loginNotNeedPageMap.get(key))){
			return false;	//로그인이 필요 없음
		}
		
		return true;	//로그인이 필요함
	}
}
