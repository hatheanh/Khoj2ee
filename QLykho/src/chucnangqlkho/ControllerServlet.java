package chucnangqlkho;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import chucnangqlkho.Kho;
import chucnangqlkho.KhoDAO;

	@WebServlet(urlPatterns= {"/list","/update/*","/insert","/update","/"})
	//@WebServlet(urlPatterns= {"/update/*"})
	public class ControllerServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private KhoDAO bd;
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			String  url = "jdbc:mysql://localhost:3306/quanlykho";
			String userName="root";
			String pass="";
			bd=new KhoDAO(url,userName,pass);
		}
	    public ControllerServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			

			String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":	
				insertKho(request,response);
				break;
			case "/new":
				newForm(request, response);
				break;
			case "/update":
				uppdateKho(request,response);
				break;
			case "/edit":
				editForm(request,response);
				break;
			case "/delete":
				deleteKho(request,response);
				break;
			default:
				listKho(request, response);
				
				break;
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("het");
		}
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Fromkho.jsp");
			dispatcher.forward(request, response);
		}
		private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{
			int id_book=Integer.parseInt(request.getParameter("id"));
			Kho kho=bd.getKho(id_book);
			request.setAttribute("a",kho);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Fromkho.jsp");
			dispatcher.forward(request, response);		
		}
		private void uppdateKho(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
			int id=Integer.parseInt(request.getParameter("id")) ;
			String tenkho=request.getParameter("tenkho");
			//String tenhang=request.getParameter("tenhang");
			String diadiem=request.getParameter("diadiem");
			Kho book = new Kho(id,tenkho, diadiem);
			bd.updateK(book);
			response.sendRedirect("list");
		}
		private void insertKho(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
			int id=Integer.parseInt(request.getParameter("id"));
			String tenkho=request.getParameter("tenkho");
			//String tenhang=request.getParameter("tenhang");
			String diadiem=request.getParameter("diadiem");
			Kho book = new Kho(id, tenkho, diadiem);
			bd.insertKho(book);
			response.sendRedirect("list");
		}
		private void deleteKho(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
			int id=Integer.parseInt(request.getParameter("id"));		
			Kho book=new Kho(id);
			bd.deleteKho(book);
			response.sendRedirect("list");
		}
		private void listKho(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
			List<Kho> listkho=bd.getAllKho();
			request.setAttribute("listKho",listkho);
		RequestDispatcher	dispatcher= request.getRequestDispatcher("ListKho.jsp");
		dispatcher.forward(request, response);
			for(Kho book : listkho) {
				book.print();
		}
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}

