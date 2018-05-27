package battleshipsJava.mvc;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by a on 5/27/2018.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/hi")
    public String welcome (){
        return "about/about";
    }
}
