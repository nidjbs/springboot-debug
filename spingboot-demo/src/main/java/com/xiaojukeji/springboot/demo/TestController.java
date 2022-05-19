package com.xiaojukeji.springboot.demo;

import org.springframework.web.bind.annotation.*;

/**
 * @author huayuanlin on 2022/5/17
 */
@RestController
public class TestController {

	@GetMapping("/v1/test")
	public String v1() {
		return "ok";
	}


	@PostMapping("/v2/test")
	public String v2(@RequestBody RequestDTO requestDTO) {
		System.out.println(requestDTO);
		return "ok";
	}

	public static class RequestDTO {
		public RequestDTO() {
		}

		public RequestDTO(String name, Integer id) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		private String name;

		private Integer id;
	}

}