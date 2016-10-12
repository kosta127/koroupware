package kosta.login.mapper;


import java.util.List;

import kosta.login.model.Member;

public interface LoginMapper {

	public List<Member>	checkMember();

	public List<Member> FindId_ListMember();

	public List<Member> FindPassword_ListMember();
	

}
