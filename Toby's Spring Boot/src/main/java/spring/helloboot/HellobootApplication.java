package spring.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {
		// Spring Boot에서 TomcatServletContainer를 내장해서 지원하는 도우미 클래스
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("frontController", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					//프론트 컨트롤러 - 인증, 보안, 다국어처리, 공통 기능 등등
					// http -v POST ":8080/hello?name=spring" , POST 요청시 404에러
					if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
						// name parameter 받기
						String name = req.getParameter("name");

						res.setStatus(HttpStatus.OK.value()); // 응답코드
						res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE); // 콘텐츠타입 헤더
						res.getWriter().println("Hello " + name); // 바디
					} else if (req.getRequestURI().equals("/user")) {

					} else {
						res.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");

		});
		webServer.start(); // 톰캣 서버까지 띄워보기


	}

}
