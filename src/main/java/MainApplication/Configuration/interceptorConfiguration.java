package MainApplication.Configuration;

import MainApplication.Interceptor.NologinInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class interceptorConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public NologinInterceptor nologinInterceptor(){
        return new NologinInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(nologinInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/assets/**","/login","/");
    }
}
