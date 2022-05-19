package cases;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author huayuanlin on 2022/5/17
 */
@Component
public class MockMqConsumer implements ApplicationContextAware {

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostConstruct
	public void initConsumer() {
		System.out.println("初始化mock consumer成功!");
		Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(this::consumer, 0, 3000, TimeUnit.MILLISECONDS);
	}

	ApplicationContext applicationContext;


	public void consumer() {
		// just test
		System.out.println("consumer publishEvent");
		try {
			// push的逻辑中会拿@EventListener的bean进行反射调用，所以此处会调用getBean的操作
			publisher.publishEvent(new MyEvent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static class MyEvent {
		private final Integer integer = new Random(99999).nextInt();

		@Override
		public String toString() {
			return "MyEvent{" +
					"integer=" + integer +
					'}';
		}
	}

	@EventListener
	public void onEvent(MyEvent myEvent) {
		System.out.println("onEvent" + myEvent);
	}

}