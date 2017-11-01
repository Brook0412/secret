package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.model.bean.Commodity;
import com.model.dao.SpringSessionFactory;

/**
 * Servlet implementation class SetCommodity
 */
@WebServlet("/setCommodity")
public class SetCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCommodity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String commodityName = request.getParameter("commodityName");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
		String details = request.getParameter("details");
		
		SpringSessionFactory ssf = new SpringSessionFactory();
		Session session = ssf.getSession(getServletContext());

//		String sql = "select ID from COMMODITY where name = "+ commodityName;
//		List<?> list = session.createSQLQuery(sql).list();
//		if(list.get(0) == null){
//			
			Commodity commodity = new Commodity(commodityName, price, stock, details);
			session.save(commodity);
//			
//		}else{
//			int id = (int) list.get(0);
//			Commodity commodity = session.get(Commodity.class, id);
//			commodity.setPrice(price);
//			commodity.setStock(stock);
//			commodity.setDetails(details);
//			session.saveOrUpdate(commodity);
//		}
		
		
		ssf.closeSession(session);
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
