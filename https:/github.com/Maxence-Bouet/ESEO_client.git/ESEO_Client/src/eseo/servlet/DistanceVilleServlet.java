package eseo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eseo.dao.Ville;

/**
 * Servlet implementation class DistanceVilleServlet
 */
@WebServlet("/DistanceVilleServlet")
public class DistanceVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistanceVilleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ville1 = request.getParameter("ville1");
		String ville2 = request.getParameter("ville2");
		
		System.out.println(ville1);
		System.out.println(ville2);
		
		Double distance = this.distance(Double.parseDouble(ville1.split(",")[0]), Double.parseDouble(ville1.split(",")[1]), Double.parseDouble(ville2.split(",")[0]), Double.parseDouble(ville2.split(",")[1]), "K");
		
		request.setAttribute("ville1", ville1);
		request.setAttribute("ville2", ville2);
		request.setAttribute("distance", Math.round(distance) + " Km");
		RequestDispatcher dispat = request.getRequestDispatcher("allVilles");
		dispat.forward(request, response);
	}
	
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit == "K") {
				dist = dist * 1.609344;
			} else if (unit == "N") {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}


}
