package com.sample;

import java.util.List;
import java.util.Map;

/**
 * 映射计算
 * Created by yls on 2019-08-22
 */
public interface IMappingStrategy {

    /**
     * 运算映射结果
     * @param mappingMap 映射关系map
     * @param digits 需要求解映射字母的数字数组
     * @return 映射的字母结果集
     */
    List<String> execute(Map<Integer, char[]> mappingMap, Integer[] digits);

}
