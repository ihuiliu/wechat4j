package cn.jincheng;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayBackServlet
 */
public class PayBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------------back");
		ServletInputStream in=request.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(in);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(System.out);
		char[] b=new char[1024];
		int len=0;
		while((len=inputStreamReader.read(b))!=-1){
			outputStreamWriter.write(b, 0, len);
		}
		inputStreamReader.close();
		outputStreamWriter.close();
		
		
	}

}
