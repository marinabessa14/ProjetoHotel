package Model.libertas;

import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.libertas.dao.HotelDao;
import Model.libertas.pojo.Hotel;

public class HotelConsultar implements Modelo {

	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HotelDao hdao = new HotelDao();
			
			int idhotel = Integer.parseInt(request.getParameter("idhotel"));
			
			Hotel h = hdao.consultar(idhotel);
			Gson gson = new Gson();
			
		
			PrintWriter writer = response.getWriter();
			writer.print(gson.toJson(h));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
