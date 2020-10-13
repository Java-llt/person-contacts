package ad;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.annotation.MapperScan;


/** 
 * 注解@SpringBootApplication指定项目为springboot，由此类当作程序入口,自动装配 web 依赖的环境; 
 */  
@SpringBootApplication
@MapperScan(basePackages = "ad.mapper")//扫描 mybatis mapper 包路径
@ComponentScan(basePackages = {"ad"})
@Configuration
public class Application extends SpringBootServletInitializer{
	
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(this.getClass());
		return super.configure(builder);
	}

	// 在main方法中启动一个应用，即：这个应用的入口 
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	
	  /**
     * 文件上传配置
     * 
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("10240KB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }
	
	
}
