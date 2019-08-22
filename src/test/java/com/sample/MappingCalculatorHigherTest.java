package com.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yls on 2019-08-22
 */

public class MappingCalculatorHigherTest {

    private MappingCalculator calculator;

    @Before
    public void setUp() {
        // 构建对象
        try {
            calculator = new MappingCalculator(MappingCalculator.class.getResourceAsStream("/mapping-higher.properties"), new SimpleMappingStrategy());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(calculator);
    }

    @Test
    public void testCase1() {
        Integer[] digits = new Integer[] {2, 3};
        List<String> result = calculator.execute(digits);

        Assert.assertEquals(result.size(), 2);

        String [] assertResult = new String [] {"AB", "YB"};
        Assert.assertEquals(result, Arrays.asList(assertResult));
    }

    @Test
    public void testCase2() {
        Integer[] digits = new Integer[] {9};
        List<String> result = calculator.execute(digits);

        Assert.assertEquals(result.size(), 1);

        String [] assertResult = new String [] {"H"};
        Assert.assertEquals(result, Arrays.asList(assertResult));
    }

}
