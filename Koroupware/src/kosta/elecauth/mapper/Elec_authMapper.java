package kosta.elecauth.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.elecauth.model.Elec_auth;

public interface Elec_authMapper {
	public List<Elec_auth> elec_authList(RowBounds rb);
	public int getTotalCount();
	public Elec_auth elec_authDetail(int elec_auth_no);
}
