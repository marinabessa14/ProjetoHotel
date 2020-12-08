package Model.libertas;

import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.libertas.dao.HotelDao;
import Model.libertas.pojo.Hotel;

public class HotelExcluir implements Modelo {

	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HotelDao hdao = new HotelDao();
			
			Hotel h = new Hotel();
			h.setIdhotel(Integer.parseInt(request.getParameter("idhotel")));
			
			hdao.excluir(h);
			
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			writer.print(gson.toJson("ok"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}