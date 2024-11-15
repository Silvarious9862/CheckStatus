package com.example.silvarious.CheckStatus.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<Key, Value> {

    private final Map<Key, Value> cache = new ConcurrentHashMap<>();

    public Value get(Key key) {
        return cache.get(key);
    }

    public void put(Key key, Value value) {
        cache.put(key, value);
    }

    public void clear() {
        cache.clear();
    }

    public boolean containsKey(Key key) {
        return cache.containsKey(key);
    }
}