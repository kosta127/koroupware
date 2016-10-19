package kosta.dept.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.dept.dao.DeptDao;
import kosta.dept.model.Dept;
import kosta.emp.dao.EmpDao;

public class OrgChartPageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DeptDao dao = DeptDao.getInstance();
		
		List<Dept> deptList = dao.selectDeptAll();
		request.setAttribute("deptList", deptList);
		
		forward.setPath("orgChart.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
