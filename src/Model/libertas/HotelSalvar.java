package Model.libertas;


import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.libertas.dao.HotelDao;
import Model.libertas.pojo.Hotel;

public class HotelSalvar implements Modelo {

	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HotelDao hdao = new HotelDao();
			
			
			Hotel h = new Hotel();
			h.setIdhotel(Integer.parseInt(request.getParameter("idhotel")));
			h.setNome(request.getParameter("nome"));
			h.setEndereco(request.getParameter("endereco"));
			h.setDiaria(Double.parseDouble(request.getParameter("diaria")));
			h.setCidade(request.getParameter("cidade"));
			h.setEstado(request.getParameter("estado"));
			h.setTelefone(request.getParameter("telefone"));
			if (h.getIdhotel()==0) {
				hdao.inserir(h);
			} else {
				hdao.alterar(h);
			}
			
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			writer.print(gson.toJson("ok"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}