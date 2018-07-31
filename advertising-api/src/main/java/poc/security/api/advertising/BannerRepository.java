package poc.security.api.advertising;

import io.vavr.collection.List;
import org.springframework.stereotype.Repository;
import poc.security.api.advertising.resource.BannerResource;


import java.util.Objects;

import static poc.security.api.advertising.resource.BannerResource.BannerResourceBuilder.aBannerResource;

@Repository
public class BannerRepository {

    private static BannerResource EMPTY_BANNER = aBannerResource()
            .id("000")
            .html("")
            .build();

    private List<BannerResource> whiskies = List.of(
            EMPTY_BANNER,
            aBannerResource()
                    .id("001")
                    .html("Discover exceptional drinks on great-drinks.com !")
                    .build()
    );

    public List<BannerResource> getAll() {
        return whiskies;
    }

    public BannerResource getById(String id) {
        return whiskies
                .find(it -> Objects.equals(it.getId(), id))
                .getOrElse(EMPTY_BANNER);
    }
}
