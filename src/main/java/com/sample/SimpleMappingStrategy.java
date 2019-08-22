package com.sample;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 简单的映射计算策略
 * Created by yls on 2019-08-22
 */
public class SimpleMappingStrategy implements IMappingStrategy {

    /**
     *  计算
     * @param mappingMap 映射关系map
     * @param digits 需要求解映射字母的数字数组
     * @return 组合的结果集
     */
    public List<String> execute(Map<Integer, char[]> mappingMap, Integer[] digits) {
        List<String> result = new ArrayList<>();
        calc(mappingMap, digits, 0, "", result);
        return result;
    }

    /**
     * 递归计算数字组合
     * @param mappingMap 映射关系map
     * @param digits 需要求解映射字母的数字数组
     * @param index 需要计算数字的当前索引
     * @param comb 组合的临时字符串
     * @param result 组合的结果集
     */
    public void calc(Map<Integer, char[]> mappingMap, Integer [] digits, int index, String comb, List<String> result) {
        // 是否处理到电话号码的末尾
        if (digits.length == index) {
            result.add(comb);
            return;
        }
        // 当前数字
        int digit = digits[index];

        // 当前数字对应的字母
        char[] letters = mappingMap.get(digit);
        // 数字没有对应字母时跳过
        if (letters == null) {
            calc(mappingMap, digits, index + 1, comb, result);
        } else {
            for (int i = 0; i < letters.length; i++) {
                calc(mappingMap, digits, index + 1, comb + letters[i], result);
            }
        }
    }

}
