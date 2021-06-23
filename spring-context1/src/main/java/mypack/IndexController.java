package mypack;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import com.mypack.service.TestService;
public class IndexController extends ParameterizableViewController
{

	public IndexController() {
		
	}
	@Autowired
	private TestService testService;//It is not working
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	//service.test();
        System.out.println("###############    IndexController class ################333");
        ModelAndView v=new ModelAndView();
        v.addObject("name","This is test application");
        v.setViewName("index");
        return v;
    }
}
