package MainApplication.Configuration;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Arbeitnehmer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class BeanConfiguration {

    @Bean
    public Arbeitnehmer arbeitnehmer(){
        return new Arbeitnehmer();
    }

    @Bean
    public Abteilung abteilung(){
        return new Abteilung();
    }
}
