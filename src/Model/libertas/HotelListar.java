package Model.libertas;


import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.libertas.dao.HotelDao;
import Model.libertas.pojo.Hotel;

public class HotelListar implements Modelo {

	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HotelDao hdao = new HotelDao();
			LinkedList<Hotel> lista = hdao.listar();
			Gson gson = new Gson();
			
			
			PrintWriter writer = response.getWriter();
			writer.print(gson.toJson(lista));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
