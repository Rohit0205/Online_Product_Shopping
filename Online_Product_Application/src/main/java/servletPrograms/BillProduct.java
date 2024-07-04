package servletPrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Beans.ProductBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/billProduct")
public class BillProduct extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String code=req.getParameter("pcode");
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> it = al.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();
				if(pb.getCode().equals(code))
				{
					req.setAttribute("pb", pb);
					int reqqty=Integer.parseInt(req.getParameter("reqqty"));
					float totalAmount=pb.getPrice()*reqqty;
					req.setAttribute("reqqty",reqqty);
					req.setAttribute("totAmt",totalAmount);
					break;
				}
				
			}
			req.getRequestDispatcher("BillProduct.jsp").forward(req, res);
		}
	}

}
