package MainApplication.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceHandlerConfiguration implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/img/profiles/**").addResourceLocations("file:D:/IdeaProjects/CRM/src/main/resources/static/assets/img/profiles/");
        registry.addResourceHandler("/assets/img/Unternehmensprofiles/**").addResourceLocations("file:D:/IdeaProjects/CRM/src/main/resources/static/assets/img/Unternehmensprofiles/");
        registry.addResourceHandler("/assets/img/**").addResourceLocations("file:D:/IdeaProjects/CRM/src/main/resources/static/assets/img/");
    }
}
