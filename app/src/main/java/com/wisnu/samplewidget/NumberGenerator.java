package com.wisnu.samplewidget;

import java.util.Random;

/**
 * Created by wisnu on 17/02/2017.
 */

public class NumberGenerator {
    public static int Generate(int max) {
        Random random = new Random();
        int randomInt = random.nextInt(max);
        return randomInt;
    }
}
