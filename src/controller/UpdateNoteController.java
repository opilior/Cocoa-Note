package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import dao.diary.DiaryDAO;
import util.CocoaDate;
import vo.diary.Note;


public class UpdateNoteController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Note note = DiaryDAO.getInstance().updateNote(Integer.parseInt(request.getParameter("diaryNo")), 
														request.getParameter("title"), 
														request.getParameter("content"));
		
		// #10006 NoteView 플로우 관련 #12
		return new ModelAndView("DispatcherServlet?command=noteView&diaryNo="+note.getNo());
	}

}
