package ie.gmit.sw.DictionaryLookupSystem;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.gmit.sw.DictionaryLookupSystem.DictionaryService;

/**
 * Servlet implementation class LookupServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servlet" })

public class Servlet extends HttpServlet {
	// Private Variables declared
	private static final long serialVersionUID = 1L;
	private int Id;
	private String result = "";
	private BlockingQueue<Queue> QueueList = new ArrayBlockingQueue<Queue>(100);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String datapassed = request.getParameter("text");
		Id = Id + 1;
		Queue queueID = new Queue(Id, datapassed);

		try {
			QueueList.put(queueID);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// System.out.println(Id);
		// String input = request.getParameter("text");
		try {
			System.out.println("getting to the try");
			DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/DS");
			result = ds.queryDictionary(datapassed);
		} catch (NotBoundException e) {
			System.out.println("going to the catch");
			e.printStackTrace();
		}
		request.setAttribute("datapassed", datapassed);
		request.setAttribute("result", result);
		javax.servlet.RequestDispatcher dp = request.getRequestDispatcher("/result.jsp");
		dp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
