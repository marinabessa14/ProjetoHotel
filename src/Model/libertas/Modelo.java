package Model.libertas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Modelo {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
