package eseo.servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import eseo.dao.Ville;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ville ville = new Ville();

		ville.setCode_commune_INSEE(request.getParameter("code"));
		ville.setNom_commune(request.getParameter("nom"));
		ville.setCode_postal(request.getParameter("postal"));
		ville.setLibelle_acheminement(request.getParameter("libelle"));
		ville.setLigne_5(request.getParameter("ligne"));
		ville.setLatitude(request.getParameter("latitude"));
		ville.setLongitude(request.getParameter("longitude"));

		Gson gson = new Gson();
		String json = gson.toJson(ville);
		System.out.println(json);

		try {
			URL url = new URL("http://localhost:8181/CreateVille");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");

			System.out.println("passed Client");

			OutputStream os = connection.getOutputStream();
			os.write(json.getBytes("utf-8"));
			os.flush();
			os.close();

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
				StringBuilder resp = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					resp.append(responseLine.trim());
				}
				System.out.println(resp.toString());
			}

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		RequestDispatcher dispat = request.getRequestDispatcher("Accueil.jsp");
		dispat.forward(request, response);
	}

}
