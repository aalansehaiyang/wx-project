//package com.weiguanjishu.demo.delayqueue.t2;
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ZSetOperations;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class CacheService {
//
//    @Resource
//    private RedisTemplate redisTemplate;
//
//    public void delKey(String key) {
//        redisTemplate.delete(key);
//    }
//
//    public boolean addData(String key, String value, double score) {
//        boolean result = redisTemplate.opsForZSet().add(key, value, score);
//        return result;
//    }
//
//    public List<String> scanData(String key, double max, long count) {
//        Set<ZSetOperations.TypedTuple<String>> redisSet = redisTemplate.opsForZSet().rangeByScoreWithScores(key, 0, max, 0, count);
//        return redisSet.stream().map(t -> t.getValue()).collect(Collectors.toList());
//    }
//
//    public long removeData(String key, String value) {
//        return redisTemplate.opsForZSet().remove(key, value);
//    }
//}