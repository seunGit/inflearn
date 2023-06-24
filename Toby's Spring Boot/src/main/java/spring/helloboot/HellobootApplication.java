package spring.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {
		// Spring Boot에서 TomcatServletContainer를 내장해서 지원하는 도우미 클래스
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					res.setStatus(200); // 응답코드
					res.setHeader("Content-Type", "text/plain"); // 콘텐츠타입 헤더
					res.getWriter().println("Hello Servlet"); // 바디
				}
			}).addMapping("/hello");

		});
		webServer.start(); // 톰캣 서버까지 띄워보기



	}

}
