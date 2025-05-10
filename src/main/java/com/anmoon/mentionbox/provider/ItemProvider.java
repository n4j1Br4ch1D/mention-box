package com.anmoon.mentionbox.provider;


import com.anmoon.mentionbox.util.WeightedRandomSelector;
import net.datafaker.Faker;
import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class ItemProvider extends AbstractProvider<BaseProviders> {
    private static final WeightedRandomSelector selector = new WeightedRandomSelector(new Random());

    private static final String[] ITEM_NAMES = { "Movies", "Series", "Books", "Music" };
    private static final List<Map<String, Object>> WEIGHTED_ITEMS = List.of(
            Map.of("value", "Movies", "weight", 3.0),
            Map.of("value", "Series", "weight", 3.0),
            Map.of("value", "Books", "weight", 3.0),
            Map.of("value", "Music", "weight", 1.0)
    );

    public ItemProvider(BaseProviders faker) {
        super(faker);
    }

    public String nextItemName() {
        return ITEM_NAMES[faker.random().nextInt(ITEM_NAMES.length)];
    }

    public String weightedItemName() {
        return selector.select(WEIGHTED_ITEMS);
    }

    public String title(String type){
        Faker faker = new Faker();
        switch (type){
            case "Movies":
                return faker.book().title();
            case "Series":
                return faker.lorem().sentence(2,0);
            case "Books":
                return faker.book().title();
                case "Music":
                    return faker.lorem().sentence(2,0);
        }
        return faker.lorem().sentence(2,0);
    }

    public String description(String type){
        Faker faker = new Faker();
        switch (type){
                case "Movies":
                    return faker.movie().quote();
                case "Series":
                    return faker.lorem().sentence(4,5);
                    case "Books":
                        return faker.book().author() + " " + faker.book().genre() + " " + faker.book().publisher();
                        case "Music":
                            return faker.lorem().sentence(4,5);

        }
        return faker.lorem().sentence(4,5);
    }
}
