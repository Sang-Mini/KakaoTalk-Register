//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import model.SignUpDAO;
//import model.dto.MemberDTO;
//
//@WebServlet("/controller")
//public class Controller extends HttpServlet {
//
//	public static SignUpDAO service = SignUpDAO.getInstance();
//
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//
//		String command = request.getParameter("command");
//
//		try {
//			if (command != null && command.length() != 0) {
//				String id = request.getParameter("id");
//				String pw = request.getParameter("pw");
//				String re_pw = request.getParameter("re_pw");
//				String member_name = request.getParameter("member_name");
//
//				if (pw.equals(re_pw)) {
//					if (command.equals("sign_up")) {// 회원가입
//						sign_up(request, response);
//					} else if (command.equals("passwordUpdate")) {// name으로 찾은 데이터의 pw 변경
//						passwordUpdate(request, response);
//					} else if (command.equals("findAll")) {
//						getAllMembers(request, response);
//					} else if (command.equals("findOne")) {
//						getMemberById(request, response);
//					}
//				} else {
//					out.println("비밀번호가 일치하지 않습니다.");
//				}
//			} else {
//				out.println("입력된 데이터값이 없습니다.");
//			}
//		} catch (Exception s) {
//			request.setAttribute("errorMsg", s.getMessage());
//			request.getRequestDispatcher("showError.jsp").forward(request, response);
//			s.printStackTrace();
//		}
//	}
//
//	private void passwordUpdate(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	protected void sign_up(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String member_name = request.getParameter("member_name");
//
//		try {
//			boolean add = service.addMember(id, pw, member_name);
//
//			if (add) {
//				request.setAttribute("addMemberMsg", "저장 완료");
//				request.getRequestDispatcher("success.jsp").forward(request, response);
//			}
//		} catch (Exception s) {
//			request.setAttribute("errorMsg", s.getMessage());
//			request.getRequestDispatcher("showError.jsp").forward(request, response);
//			s.printStackTrace();
//		}
//
//	}
//
//	protected void getAllMembers(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//	
//		try{
//			List<MemberDTO> list = service.getAllMembers();
//			
//			request.setAttribute("findAllMembers", list);
//			request.getRequestDispatcher("success.jsp").forward(request, response);
//		}catch(Exception s) {
//			request.setAttribute("errorMsg", s.getMessage());
//			request.getRequestDispatcher("showError.jsp").forward(request, response);
//			s.printStackTrace();
//		}
//	
//	}
//	
//	protected void getMemberById(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String id = request.getParameter("id");
//
//		try {
//			MemberDTO memberDTO = service.getMember(id);
//
//			request.setAttribute("findActivistById", memberDTO);
//			request.getRequestDispatcher("success.jsp").forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("message", "검색 도중 문제 발생");
//			request.getRequestDispatcher("showError.jsp").forward(request, response);
//		}
//	}
//
//}