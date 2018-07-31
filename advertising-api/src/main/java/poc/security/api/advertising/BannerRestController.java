package poc.security.api.advertising;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.security.api.advertising.resource.BannerResource;

/**
 * <p>A simple rest controller to expose banners.</p>
 */
@RestController
@RequestMapping("/v1/banners")
public class BannerRestController {

    @Autowired
    private BannerRepository bannerRepository;

    @GetMapping("/{id}")
    public BannerResource get(@PathVariable String id) {
        return bannerRepository.getById(id);
    }

}
