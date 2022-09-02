package BasePackage.spring_introductions;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:myApplication.properties")
//@ComponentScan("BasePackage")
public class SpringConfig {

    @Bean
    @Scope("prototype")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }

}
