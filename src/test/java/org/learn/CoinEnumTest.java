package org.learn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vinay on 24/3/18.
 */
public class CoinEnumTest {

    CoinEnum coin;

    @Before
    public void setup() {
       coin = CoinEnum.PENNY;
    }

    @Test
    public void testEnum() {
        Assert.assertEquals("PENNY",coin.name());
        Assert.assertEquals(1, coin.value());
    }
}
