package kosta.etc;
import java.io.*;

public class FileDownloadHelper {
	public static void copy(String filePath, OutputStream os) throws IOException{
		//파일 다운로드처리
		FileInputStream is = null;
		
		try {
			is = new FileInputStream(filePath);
			byte[] data = new byte[8096];
			int len = -1;
			
			while ((len = is.read(data)) != -1) {
				os.write(data, 0, len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		finally {
			try{
				if(ETC.isNotNull(is)) is.close();
				if(ETC.isNotNull(os)) os.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
