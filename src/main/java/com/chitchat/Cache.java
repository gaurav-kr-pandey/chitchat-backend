package com.chitchat;

import java.util.*;

public class Cache<K,V> {
    private static final int CAPACITY = 10;
    private CacheStrategies cacheStrategies;
    private Queue<Pair> frequentlyUsed;
    private Map<K,V> cache;
    private int cap;
    public Cache(){
        frequentlyUsed = new LinkedList<>();
        cache = new HashMap<>();
        cacheStrategies = CacheStrategies.LRU;
    }

    public Cache(int capacity, CacheStrategies cacheStrategies){
        frequentlyUsed = new LinkedList<>();
        cache = new HashMap<>(capacity);
        this.cacheStrategies = cacheStrategies;
        Collection<V> values = cache.values();
        values.
        switch (cacheStrategies){
            case LFU:
                break;
            default:
        }
    }

    public void put(K key, V value){
        if(cap==CAPACITY) evict();
        cache.put(key,value);
        updateFrequency(new Pair(key,value));
        cap++;
    }

    public V get(K key){
        V value = cache.get(key);
        updateFrequency(new Pair(key,value));
        return value;
    }

    private void evict(){
        cap--;
        frequentlyUsed.remove();
    }

    private void updateFrequency(Pair p){
        frequentlyUsed.remove(p);
        frequentlyUsed.add(p);
    }

 }
