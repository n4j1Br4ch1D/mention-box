package com.anmoon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class DatabaseSeeder implements CommandLineRunner {
    private final boolean enabled;
    private final String method;
    private final List<String> items;
    private final String packagePath;
    private final ApplicationContext applicationContext;
//    String defaultPackagePath = DatabaseSeeder.class.getPackage().getName();

    @Autowired
    public DatabaseSeeder(
            @Value("${seedable.enabled}") boolean enabled,
            @Value("${seedable.method}") String method,
            @Value("${seedable.items}") String items,
            @Value("${seedable.package}") String packagePath,
            ApplicationContext applicationContext) {
        this.enabled = enabled;
        this.method = method;
        this.items = Arrays.asList(items.split(","));
        this.packagePath = packagePath;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        if (enabled) {
            if ("new".equalsIgnoreCase(method)) {
                seedNewMethod();
            } else if ("add".equalsIgnoreCase(method)) {
                seedAddMethod();
            } else {
                System.out.println("Unsupported seeding method: " + method);
            }
        }
    }
    private void seedNewMethod() {
        System.out.println("Seeding with method 'new' and items: " + items);
        for (String className : items) {
            try {
                // Capitalize the first letter of the class name to match Spring's default naming conventions
                String capitalizedClassName = className.substring(0, 1).toUpperCase() + className.substring(1);

                // Obtain beans of type Seedable from the application context
                Map<String, Seedable> seedableBeans = applicationContext.getBeansOfType(Seedable.class);
                log.info("seedableBeans ==>{}", seedableBeans);
                // Iterate through the beans and find the one that matches the class name
                Seedable seedableBean = seedableBeans.values().stream()
                        .filter(bean -> bean.getClass().getSimpleName().equals(capitalizedClassName))
                        .findFirst()
                        .orElse(null);
                log.info("seedableBean ==>{}", seedableBean);


                // Assume a method for seeding in each class
                if (seedableBean != null) {
                    seedableBean.seed();
                    System.out.println("Successfully seeded: " + className);
                } else {
                    System.err.println("Error: Bean not found for class: " + className);
                }
            } catch (Exception e) {
                System.err.println("Error seeding class " + className + ": " + e.getMessage());
                e.printStackTrace(); // Print the full stack trace for detailed debugging
            }
        }
    }


    private void seedAddMethod() {
        // Similar logic as seedNewMethod for the "add" method
    }
}
