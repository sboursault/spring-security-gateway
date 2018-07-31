package poc.security.api.drinks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poc.security.api.drinks.resource.*;

import java.util.List;

/**
 * <p>A simple rest controller to expose whiskies.</p>
 */
@RestController
@RequestMapping("/v1/whiskies")
public class WhiskyRestController {

    @Autowired
    private WhiskyRepository whiskyRepository;

    @GetMapping
    public List<WhiskyResource> getAll() {
        return whiskyRepository.getAll();
    }

}