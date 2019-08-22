package com.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yls on 2019-08-22
 */

public class MappingCalculatorCommonTest2 {

    private MappingCalculator calculator;

    @Before
    public void setUp() throws IOException {
        // 构建对象
        Map<Integer, char[]> mappingMap = new HashMap<>();
        mappingMap.put(2, "ABC".toCharArray());
        mappingMap.put(3, "DEF".toCharArray());
        mappingMap.put(4, "GHI".toCharArray());
        mappingMap.put(5, "JKL".toCharArray());
        mappingMap.put(6, "MNO".toCharArray());
        mappingMap.put(7, "PQRS".toCharArray());
        mappingMap.put(8, "TUV".toCharArray());
        mappingMap.put(9, "WXYZ".toCharArray());

        calculator = new MappingCalculator(mappingMap, new SimpleMappingStrategy());
    }

    @Test
    public void testCase1() {
        Integer[] digits = new Integer[] {2, 3};
        List<String> result = calculator.execute(digits);

        Assert.assertEquals(result.size(), 9);

        String [] assertResult = new String [] {"AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"};
        Assert.assertEquals(result, Arrays.asList(assertResult));
    }

    @Test
    public void testCase2() {
        Integer[] digits = new Integer[] {9};
        List<String> result = calculator.execute(digits);

        Assert.assertEquals(result.size(), 4);

        String [] assertResult = new String [] {"W", "X", "Y", "Z"};
        Assert.assertEquals(result, Arrays.asList(assertResult));
    }

}
