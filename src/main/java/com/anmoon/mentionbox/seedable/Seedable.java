package com.anmoon.mentionbox.seedable;

public interface Seedable {
    SeedDataType SEED_DATA_TYPE = SeedDataType.INITIAL;

    void seed();

    void rollback();
}
