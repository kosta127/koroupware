package kosta.dept.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.dept.dao.DeptDao;
import kosta.dept.model.Dept;
import kosta.dept.model.OrgChartEmpModel;
import kosta.dept.model.OrgChartModel;
import kosta.emp.dao.EmpDao;
import kosta.etc.ETC;

public class OrgChartPageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DeptDao dao = DeptDao.getInstance();
		
		List<OrgChartModel> orgChartModelList = new ArrayList<OrgChartModel>();
		List<Dept> deptList = dao.selectDeptAll();
		
		Iterator<Dept> iter = deptList.iterator();
		
		while(iter.hasNext()){
			Dept dept = iter.next();
			OrgChartModel model = new OrgChartModel();
			List<OrgChartEmpModel> orgChartEmpModelList = 
					dao.selectOrgChartEmpModelByDeptNo(dept.getDept_no());
			
			String telephone = dept.getDept_telephone();
			dept.setDept_telephone(ETC.toTelephoneFormat(telephone));
			
			model.setDept(dept);
			model.setOrgChartEmpList(orgChartEmpModelList);
			
			orgChartModelList.add(model);
		}
		
		request.setAttribute("orgChartModelList", orgChartModelList);
		
		forward.setPath("orgChart/orgChart.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
