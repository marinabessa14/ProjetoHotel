package Model.libertas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import Model.libertas.pojo.Hotel;

public class HotelDao {
	
	public void inserir(Hotel h) {
		Conexao con = new Conexao();	
		try {
		
			String sql = "INSERT INTO cad_hotel (nome, endereco, diaria, cidade, estado, telefone) VALUES (?,?,?,?,?,?)";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, h.getNome());
			prep.setString(2, h.getEndereco());
			prep.setDouble(3, h.getDiaria());
			prep.setString(4, h.getCidade());
			prep.setString(5, h.getEstado());
			prep.setString(6, h.getTelefone());
			prep.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public void alterar(Hotel h) {
		Conexao con = new Conexao();	
		try {
		
			String sql = "UPDATE cad_hotel "
					+ " SET nome = ?, "
					+ " endereco = ?, "
					+ " diaria = ?, "
					+ " cidade = ?, "
					+ " estado = ?,"
					+ " telefone = ? "
					+ " WHERE idhotel = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, h.getNome());
			prep.setString(2, h.getEndereco());
			prep.setDouble(3, h.getDiaria());
			prep.setString(4, h.getCidade());
			prep.setString(5, h.getEstado());
			prep.setString(6, h.getTelefone());
			prep.setInt(7, h.getIdhotel());
			prep.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public void excluir(Hotel h) {
		Conexao con = new Conexao();	
		try {
		
			String sql = "DELETE FROM cad_hotel "
					+ " WHERE idhotel = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, h.getIdhotel());
			prep.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public Hotel consultar(int idhotel) {	
		Conexao con = new Conexao();	
		Hotel h = new Hotel();
		try {
		
			String sql = "SELECT * FROM cad_hotel "
					+ " WHERE idhotel = "+idhotel;
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				h.setIdhotel(res.getInt("idhotel"));
				h.setNome(res.getString("nome"));
				h.setEndereco(res.getString("endereco"));
				h.setDiaria(res.getDouble("diaria"));
				h.setCidade(res.getString("cidade"));
				h.setEstado(res.getString("estado"));
				h.setTelefone(res.getString("telefone"));
			}
			res.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return h;
}
	
	
	public LinkedList<Hotel> listar() {
		Conexao con = new Conexao();	
		LinkedList<Hotel> lista = new LinkedList<Hotel>();
		try {
		
			String sql = "SELECT * FROM cad_hotel "
					+ " ORDER BY nome";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Hotel h = new Hotel();
				h.setIdhotel(res.getInt("idhotel"));
				h.setNome(res.getString("nome"));
				h.setEndereco(res.getString("endereco"));
				h.setDiaria(res.getDouble("diaria"));
				h.setCidade(res.getString("cidade"));
				h.setEstado(res.getString("estado"));
				h.setTelefone(res.getString("telefone"));
				lista.add(h);
			}
			res.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	
	
}
 
	

