package poc.security.api.drinks;

import org.springframework.stereotype.Repository;
import poc.security.api.drinks.resource.WhiskyResource;

import io.vavr.collection.List;

import static poc.security.api.drinks.resource.WhiskyResource.Builder.aNewWhisky;

@Repository
public class WhiskyRepository {

    private List<WhiskyResource> whiskies = List.of(
            aNewWhisky()
                    .id("001")
                    .brand("Cardhu")
                    .name("Cardhu Special Cask Reserve")
                    .category("Single Malt Scotch Whisky")
                    .price(68.0)
                    .taste("Fruity Honey Citrus Spicy Candy Toasted Nutty")
                    .description("Cardhu Distillery is located in Speyside and is the home of Johnnie Walker, the number one blended Scotch whisky in the world. The malt itself is typical of a Speyside malt.\n" +
                            "This Cardhu Special Cask Reserve is a highly approachable and uncomplicated whisky combining whisky from old and newer casks and producing a smooth and sweet mellow whisky.")
                    .build(),
            aNewWhisky()
                    .id("002")
                    .brand("The Glenlivet")
                    .name("The Glenlivet 12 year old")
                    .category("Single Malt Scotch Whisky")
                    .price(45.0)
                    .taste("Pineapple Caramel Apple Honey Fresh Fruit Almonds ")
                    .description("Known as 'the single malt that started it all' - The Glenlivet was the first licensed distillery in the parish of Glenlivet, established in 1824 and, in turn, defined the Speyside style of whisky which became the heartland of Scotch malt whisky production. The Glenlivet was the very first malt to be promoted in the US, as soon as Prohibition was lifted.\n" +
                            "The delicate and complex character of the 12 Year Old derives from the height and width of stills at The Glenlivet Distillery. This expression is matured in a mixture of cask types, including American and European Oak. Maturation in American oak imparts vanilla notes and gives the whisky its distinct smoothness. The mineral rich water from Josie's Well ensures the best possible results during mashing and fermenting to form the flavours that define this expression.")
                    .build(),
            aNewWhisky()
                    .id("003")
                    .brand("Lagavulin")
                    .name("Lagavulin 16 year old")
                    .category("Single Malt Scotch Whisky")
                    .price(65.0)
                    .taste("Dried Fruit Spicy Peaty Smoky Malty Biscuit Briny")
                    .description("An Islay Malt, this is from one of Scotland's 'essential' distilleries, on a cramped, chaotic, wildly romantic site. Demand heavily exceeds supply.\n" +
                            "The intense character comes from their own richly peaty water supply; the heavily peated barley; the unusually long fermentation - up to 75 hours; and the slowest distillation of any Islay malt.")
                    .build(),
            aNewWhisky()
                    .id("004")
                    .brand("Chivas Regal")
                    .name("Chivas Regal 12 year old")
                    .category("Single Malt Scotch Whisky")
                    .price(38.0)
                    .taste("Honey Hazelnut Butterscotch Heather Fresh Fruit Toasted")
                    .description("Chivas Regal was founded in Aberdeen in 1801 by two brothers, John and James Chivas. The Chivas Brothers had a luxury store in Aberdeen from where they retailed goods they had imported from across the world. In 1843, Queen Victoria, staying at Balmoral, requested Cognac from their store but due to huge shortages of grapes in France, there was none to be had. The brothers selected from their finest whiskies to blend a whisky that would be good enough for the Queen and Chivas Regal was born.\n" +
                            "Aged no less than 12 years, and with Speyside malt at its heart, Chivas Regal 12 year old is an unrivalled premium blended Scotch whisky.")
                    .build()
    );

    public List<WhiskyResource> getAll() {
        return whiskies;
    }
}
