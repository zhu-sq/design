package nio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String test(){
         System.out.println(testService.getI());
         System.out.println(testService.getI());
         System.out.println(testService.getI());
         System.out.println(testService.getI());
         System.out.println(testService.getI());
         System.out.println(testService.getI());
         return "123";
    }
}
