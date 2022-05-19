package cases;

import com.xiaojukeji.springboot.demo.beans.MyLifecycleBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author huayuanlin on 2022/5/16
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import(MyLifecycleBean.class)
public class MockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);
	}

}