package battleshipsJava.mvc;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/hi")
    public String welcome() {
        return "about/about";
    }
}
