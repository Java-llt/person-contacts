package ad.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 图片绝对地址与虚拟地址映射
 */

@Configuration
public class URLConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/homepageSlideshow/**").addResourceLocations("file:/C:/mediaFile/homepageSlideshow/");
        registry.addResourceHandler("/listMiniPic/**").addResourceLocations("file:/C:/mediaFile/listMiniPic/");
        registry.addResourceHandler("/news/**").addResourceLocations("file:/C:/mediaFile/news/");
        registry.addResourceHandler("/classifyIcon/**").addResourceLocations("file:/C:/mediaFile/classifyIcon/");
        super.addResourceHandlers(registry);
    }
}
