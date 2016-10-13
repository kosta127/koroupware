package kosta.elecauth.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.elecauth.model.Approval_list;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authDetail;
import kosta.elecauth.model.Elec_auth_referrer;
import kosta.elecauth.model.Elec_authDetail;

public interface Elec_authMapper {
	public List<Elec_auth> elec_authList(RowBounds rb);
	public int getTotalCount();
	public Elec_authDetail elec_authDetail(int elec_auth_no);
	public int insertElecAuth(Elec_auth ea);
	public int insertElecAuthReferrer(Elec_auth_referrer ref);
	public int insertApprovalList(Approval_list al);
}
