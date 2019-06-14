

package sap.crun.performance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sap.cloud.servicesdk.spring", "sap.crun.performance.api","sap.crun.performance.api.controller"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// from application.yaml  
//com.sap.icd.mt.mt.enabled: true

// from manyfest.yml
//TARGET_RUNTIME: tomee7
//JBP_CONFIG_TOMEE: '{ tomee: { version: 7.0.4 } }'
