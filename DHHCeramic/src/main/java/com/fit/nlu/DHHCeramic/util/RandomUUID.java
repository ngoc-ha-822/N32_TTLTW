package com.fit.nlu.DHHCeramic.util;

import java.util.UUID;

public class RandomUUID {

    public static String getRandomID() {
        UUID uuid = UUID.randomUUID();
        String randomUUID = uuid.toString();
        return randomUUID.replace("-", "");
    }
}

