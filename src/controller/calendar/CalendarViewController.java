package controller.calendar;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
import controller.Controller;
import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import util.CocoaDate;
import model.vo.day.Day;
import model.vo.member.Member;
*/

import controller.Controller;
import controller.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.dao.member.MemberDAO;
import model.vo.day.Day;
import model.vo.diary.Schedule;
import model.vo.member.Member;
import util.CocoaDate;

public class CalendarViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member vo = (Member)request.getSession().getAttribute("memberVO");
		String id = vo.getId();
		// Schedule writtenSchedule = (Schedule)request.getSession().getAttribute("writtenSchedule");
		
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		// CocoaDate currentDate = new CocoaDate(year,month,date);
		
		Map<Integer, Vector<Member>> result = new HashMap<Integer, Vector<Member>>(); 
		Vector<Member> values = null;
		
		Day day = DiaryDAO.getInstance().getDay(id, year, month, date);
		
		for(Schedule schedule : day.getSchedules()) {
			for(String sharingId : schedule.getGroupMemberID()) {
				Member sharingUser = MemberDAO.getInstance().findMemberById(sharingId);
				sharingUser.setPassword(null);
				if(result.containsKey(schedule.getNo())) {
					values = result.get(schedule.getNo());		
				} else {
					values = new Vector<Member>();
				}
				
				if(sharingUser != null) {
					values.add(sharingUser);
				} else {
					values.add(new Member(sharingId));
				}
				
				result.put(schedule.getNo(), values);
			}
		}
		
		System.out.println("[CalendarViewController] : PRINTING RESULTS..." + result);
		request.setAttribute("group_member",  result);
		
		// #00089 : Issue #10002 : Cal_view.jsp 완료 !
		request.setAttribute("dayInfo", day);
		System.out.println("CalendarViewController attribute : " + day);
		return new ModelAndView("cal_view.jsp");
	}

}
