package com.xiaojukeji.springboot.demo.beans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author huayuanlin on 2022/5/17
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyCommandLineRunner#run" + Arrays.toString(args));
	}
}