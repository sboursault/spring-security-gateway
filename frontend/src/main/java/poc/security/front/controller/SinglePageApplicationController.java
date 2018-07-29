package poc.security.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Without this controller, everything works fine with the angular router.
 * Problems come when you type a specific url in the browser (e.g. http://.../login), spring mvc must be aware that the view to use is the index.html
 *
 * The spring properties {@code `spring.mvc.view.prefix`}  and {@code `spring.mvc.view.suffix`} should be defined properly.
 */
@Controller
public class SinglePageApplicationController {

    @GetMapping({
            "", "/", "/home", "/login"
    })
    public String index() {
        return "index";
    }

}
