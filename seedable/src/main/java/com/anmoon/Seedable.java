package com.anmoon;

public interface Seedable {
    SeedDataType SEED_DATA_TYPE = SeedDataType.INITIAL;

    void seed();

    void rollback();
}
