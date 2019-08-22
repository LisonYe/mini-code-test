package com.sample;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 数字映射字母计算器
 * Created by yls on 2019-08-22
 */
public class MappingCalculator {

    private IMappingStrategy strategy;

    private Map<Integer, char[]> mappingMap;

    /**
     * 使用属性文件构造
     * @param mappingInputStream 属性文件的输入流
     * @param strategy 计算策略实例
     * @throws IOException
     */
    public MappingCalculator(InputStream mappingInputStream, IMappingStrategy strategy) throws IOException {
        Map<Integer, char[]> mappingMap = new HashMap<>();
        Properties prop = new Properties();
        prop.load(mappingInputStream);
        for (Map.Entry entry : prop.entrySet()) {
            if (entry.getValue() != null && entry.getValue().toString().trim().length() > 0) {
                mappingMap.put(Integer.parseInt(entry.getKey().toString()), entry.getValue().toString().toCharArray());
            }
        }
        this.mappingMap = mappingMap;
        this.strategy = strategy;
    }

    /**
     *
     * @param mappingMap 映射关系map
     * @param strategy 计算策略实例
     */
    public MappingCalculator(Map<Integer, char[]> mappingMap, IMappingStrategy strategy) {
        this.mappingMap = mappingMap;
        this.strategy = strategy;
    }

    /**
     * 计算数字
     * @param digits 需要求解映射字母的数字数组
     * @return 组合的结果集
     */
    public List<String> execute(Integer[] digits) {
        return strategy.execute(this.mappingMap, digits);
    }

}
