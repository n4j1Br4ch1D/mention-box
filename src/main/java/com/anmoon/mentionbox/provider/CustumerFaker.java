package com.anmoon.mentionbox.provider;

import net.datafaker.Faker;

public class CustumerFaker extends Faker {

    public ItemProvider itemProvider() {
        return getProvider(ItemProvider.class, ItemProvider::new, this);
    }
}
