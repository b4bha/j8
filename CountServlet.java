import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CountServlet extends HttpServlet
{
	Integer count;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException
	{
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Cookie c=new Cookie("Count",count);
		res.addCookie(c);
		String heading="";
		String strCount=c.getValue();
		
		if(count==null)
		{
			count=new Integer(0);
			heading="Welcome...";
		}
		else
		{
			count = Integer.parseInt(strCount);
			heading="Welcome back";
			count=new Integer((count.intValue())+1);
		}
		c.setValue(count+" ");
		out.println(
		"<html><body><h1>" + heading + "</h1>"+" Number of previous accesses: "+count+"<br></body></html>");
	}
}