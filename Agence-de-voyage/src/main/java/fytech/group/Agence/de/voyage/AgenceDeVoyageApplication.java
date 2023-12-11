package fytech.group.Agence.de.voyage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AgenceDeVoyageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceDeVoyageApplication.class, args);
	}

	//cors configuration
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry corsRegistry){
				corsRegistry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
						.allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type",
								"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
								"Access-Control-Request-Headers")
						.allowCredentials(true);
			}
		};
	}

}
