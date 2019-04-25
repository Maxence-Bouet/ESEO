package eseo.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import eseo.dao.Ville;

/**
 * Servlet implementation class allVilles
 */
@WebServlet("/allVilles")
public class allVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allVilles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		URL url = new URL("http://localhost:8181/Ville");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		InputStream is = connection.getInputStream();
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    StringBuilder resp = new StringBuilder();
	    String line;
	    while ((line = br.readLine()) != null) {
	      resp.append(line);
	    }
	   
	    Gson g = new Gson();
	    Type founderListVille = new TypeToken<ArrayList<Ville>>(){}.getType();
		List<Ville> villes = g.fromJson(resp.toString(), founderListVille);
	    
		if(request.getParameter("redirection").equals("distance")) {
			request.setAttribute("villes", villes);
			RequestDispatcher dispat = request.getRequestDispatcher("index.jsp");
			dispat.forward(request, response);
		}
		else if(request.getParameter("redirection").equals("gerer")) {
			request.setAttribute("villes", villes);
			RequestDispatcher dispat = request.getRequestDispatcher("gererVilles.jsp");
			dispat.forward(request, response);
		}
		else if(request.getParameter("redirection").equals("unique")) {
			for(Ville ville : villes) {
				if (ville.getCode_commune_INSEE().equals(request.getParameter("code"))) {
					request.setAttribute("ville", ville);
				}
			}
			RequestDispatcher dispat = request.getRequestDispatcher("ville.jsp");
			dispat.forward(request, response);
		}
	}

}
