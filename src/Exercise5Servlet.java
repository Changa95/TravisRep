import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Exercise4Servlet")
public class Exercise5Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public final String INDEX = "index.html";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise5Servlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		if(request.getParameterMap().isEmpty())
			response.sendRedirect(INDEX);
		else
		{
			PrintWriter out = response.getWriter();
			Enumeration<String> params = request.getParameterNames();
			out.write("Your Data:\n\n");
			while(params.hasMoreElements())
			{
				String parameterName = params.nextElement();
				String parameterValue = request.getParameter(parameterName);
				out.write(parameterName + ": " + parameterValue + "\n");
			}
			out.close();
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}




