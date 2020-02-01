package cn.abel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @author yyb
 * @time 2019/3/26
 */
@SpringBootApplication

public class Application {
    static {

    }
    public static void main(String[] args)throws Exception {
//        FileInputStream in = new FileInputStream(ResourceUtils.getFile("local/application.properties").getAbsolutePath());
//        Properties properties = new Properties();
//        properties.load(in);
//        in.close();
//
//        SpringApplication.run(Application.class, args);

//        SpringApplication application = new SpringApplication(Application.class);
//        Set<String> sourcesSet = new HashSet<String>();
//        sourcesSet.add("classpath:local/application.properties");
//        application.setSources(sourcesSet);
//        application.run(args);
        new SpringApplicationBuilder(Application.class).properties("spring.config.location=classpath:/local/application.properties").run();
    }

}
