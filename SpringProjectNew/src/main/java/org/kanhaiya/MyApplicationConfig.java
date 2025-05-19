package org.kanhaiya;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Student.class})
public class MyApplicationConfig {
}
