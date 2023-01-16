package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest: ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
//		Member m = new Member(1, "ondal98", "11111", "test@test.com");
		Member m = Member.builder().password("sssss").email("ondal98@naver.comm").username("ondal99").id(2).build();
		System.out.println(TAG+ "getter: " + m.getId());
		m.setId(5000);
		System.out.println(TAG+ "getter: " + m.getId());
		
		System.out.println(TAG+ "getter: " + m.getUsername());
		m.setUsername("ondal9000");
		System.out.println(TAG+ "getter: " + m.getUsername());
		return "lombok test 완료";
	}

	//인터넷 브라우져 요청은 Get 요청만 가능
	//http://localhost:8080/http/get	
//	@GetMapping("http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) {
//			
//			return "get 요청" + id + ", " + username;
//	}
	@GetMapping("http/get")
	public String getTest(Member m) {

		return "get 요청(Member)" + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}	
	
	
		@PostMapping("http/post")  //text/plain, application/json
		public String postTest(@RequestBody Member m) {   // MessageConverter (스프링부트)
			return "post 요청(Member)" + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
//			return "post 요청: " + text;
		}
		
		@PutMapping("http/put")
		public String putTest(@RequestBody Member m) {
			return "PUT 요청"+ m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
		}
		
		@DeleteMapping("http/delete")
		public String deleteTest() {
			return "delete 요청";
		}
}
