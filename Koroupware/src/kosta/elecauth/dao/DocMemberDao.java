package kosta.elecauth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kosta.elecauth.model.DocMember;

public class DocMemberDao {
	private static DocMemberDao dao=new DocMemberDao();
	
	public static DocMemberDao getInstance(){
		return dao;
	}
	
	public Connection getConnection(){
		DataSource ds=null;
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DocMember> listDocMember(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DocMember> list=null;
		String sql="select*from doc";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<DocMember>();
			
			while(rs.next()){
				DocMember m=new DocMember();
				m.setDoc_title(rs.getString("title"));
				m.setDoc_explain(rs.getString("explain"));
				m.setDoc_content(rs.getString("content"));
				m.setDoc_regdate(rs.getString("regdate"));
				m.setDoc_con_period(rs.getString("con_period"));
				
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
