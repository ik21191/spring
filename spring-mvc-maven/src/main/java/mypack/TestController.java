package mypack;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController
{
    @Override
    protected ModelAndView handleRequestInternal
    (HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
        response.setContentType("text/html");
        System.out.println("9999999999999999999999");
        PrintWriter out=response.getWriter();
        out.println("This response is displayed without creating jsp or velocity file.");
        return null;
    }
    
}