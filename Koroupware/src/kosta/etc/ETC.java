package kosta.etc;

public class ETC {
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
}
