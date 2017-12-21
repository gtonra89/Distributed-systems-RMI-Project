package ClientSide;

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

/**
 * Servlet implementation class LookupServlet
 */
@WebServlet(asyncSupported = true,urlPatterns = {"/LookupServlet"})
public class LookupServlet extends HttpServlet {
	//Private Variables declared 
	private static final long serialVersionUID = 1L;
    private int Id;
    private String result = "";
    private BlockingQueue<jobID> QueueList = new ArrayBlockingQueue<jobID>(100);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * taking in data passed to string variable  
		 * converting it to uppercase 
		 * as per the CSV style passing it to a Job
		 */
		response.setContentType("text/html");
		String datapassed = request.getParameter("text");
		Id = Id +1;
		jobID JID = new jobID(Id, datapassed); 
		
		try {
			QueueList.put(JID);
			System.out.println("calling queue");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Id);
		String input = request.getParameter("text");
		try {
			DictionaryService DS = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			result = DS.queryDictionary(input);
		} catch (NotBoundException e) {
			e.printStackTrace();
			System.out.println("falling in here");
		}
		request.setAttribute("datapassed", input);
		request.setAttribute("result", result);
		
		javax.servlet.RequestDispatcher dispatch = request.getRequestDispatcher("/Result.jsp");
		
		dispatch.forward(request, response);
		System.out.println("getting here");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
