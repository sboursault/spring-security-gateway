package poc.security.api.advertising;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poc.security.api.advertising.resource.BannerResource;

/**
 * <p>A simple rest controller to expose banners.</p>
 */
@RestController
@RequestMapping("/v1/banners")
@CrossOrigin(
        origins="http://localhost:8080", // Should match with the `Origin` header value sent by the browser.
        maxAge=3600)
public class BannerRestController {

    @Autowired
    private BannerRepository bannerRepository;

    @GetMapping("/{id}")
    public BannerResource get(@PathVariable String id) {
        return bannerRepository.getById(id);
    }

}
