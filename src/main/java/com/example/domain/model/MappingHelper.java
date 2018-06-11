package com.example.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MappingHelper<K, V> {

    private K key;

    private V value;

    public static <K, V> Map<K, V> toMap(List<MappingHelper<K, V>> list) {
        if (list == null) {
            return Collections.emptyMap();
        }
        return list.parallelStream().collect(Collectors.toMap(MappingHelper::getKey, MappingHelper::getValue));
    }
}