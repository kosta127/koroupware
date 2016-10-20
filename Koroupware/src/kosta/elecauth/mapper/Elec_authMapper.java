package kosta.elecauth.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.doc.model.Doc;
import kosta.elecauth.model.Approval_list;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authDetail;
import kosta.elecauth.model.Elec_authDetailApproval;
import kosta.elecauth.model.Elec_authDetailReferrer;
import kosta.elecauth.model.Elec_authList;
import kosta.elecauth.model.Elec_auth_referrer;
import kosta.elecauth.model.EmpDetail;
import kosta.emp.model.Emp;
import kosta.elecauth.model.Elec_authDetail;

public interface Elec_authMapper {
	public List<Elec_authList> elec_authList(RowBounds rb, int emp_no);
	public int getTotalCount();
	public Elec_authDetail elec_authDetail(int elec_auth_no);
	public List<Elec_authDetailApproval> elec_authDetailApproval(int elec_auth_no);
	public List<Elec_authDetailReferrer> elec_authDetailReferrer(int elec_auth_no);
	public int insertElecAuth(Elec_auth ea);
	public int insertElecAuthReferrer(Elec_auth_referrer ref);
	public int insertApprovalList(Approval_list al);
	public List<EmpDetail> searchEmpDetail();
	public EmpDetail getEmpDetail(int emp_no);
	public List<Doc> getDocFormList();
	public int getNextElecAuthNo();
}
