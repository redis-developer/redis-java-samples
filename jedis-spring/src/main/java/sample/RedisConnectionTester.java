package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPooled;

@Component
public class RedisConnectionTester implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(RedisConnectionTester.class);

	private final JedisPooled jedis;

	public RedisConnectionTester(JedisPooled jedis) {
		this.jedis = jedis;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Pinging Redis");
		String response = jedis.ping();
		logger.info("Redis replied with {}", response);
	}

}
