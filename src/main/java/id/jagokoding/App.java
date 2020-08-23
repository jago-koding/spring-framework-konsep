package id.jagokoding;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
	
	@Bean
    public HelloWorldService createHelloWorldService() {
        return new HelloWorldServiceImpl();
    }

    @Bean
    public HelloWorldServiceClient createClient() {
        return new HelloWorldServiceClient();
    }

    public static void main(String[] strings) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        HelloWorldServiceClient bean = context.getBean(HelloWorldServiceClient.class);
        bean.showMessage();

    }
}