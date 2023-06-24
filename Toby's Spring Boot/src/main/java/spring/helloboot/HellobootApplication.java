package spring.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {
		// Spring Boot에서 TomcatServletContainer를 내장해서 지원하는 도우미 클래스
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					// name parameter 받기
					String name = req.getParameter("name");

					res.setStatus(HttpStatus.OK.value()); // res.setStatus(200); 응답코드
//					res.setHeader("Content-Type", "text/plain") // 스프링에서 제공해주는 ENUM 사용
					res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE); // 콘텐츠타입 헤더
					res.getWriter().println("Hello " + name); // 바디
				}
			}).addMapping("/hello");

		});
		webServer.start(); // 톰캣 서버까지 띄워보기



	}

}
