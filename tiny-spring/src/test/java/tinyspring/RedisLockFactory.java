package tinyspring;

import redis.clients.jedis.JedisPool;

public class RedisLockFactory {
    Object execute(LockInterface lockInterface){
        RedisLock redisLock = new RedisLock(new JedisPool(),"23");
        Object result;
        try {
            if(redisLock.lock()){
                return lockInterface.doSomeWork();

            }
        }finally {
            redisLock.unlock();
        }
        return null;
    }
}
