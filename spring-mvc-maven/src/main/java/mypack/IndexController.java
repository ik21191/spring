package mypack;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
public class IndexController extends ParameterizableViewController
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("###############    IndexController class ################333");
        ModelAndView v=new ModelAndView();
        v.addObject("name","This is test application");
        v.setViewName("index");
        return v;
    }
}
