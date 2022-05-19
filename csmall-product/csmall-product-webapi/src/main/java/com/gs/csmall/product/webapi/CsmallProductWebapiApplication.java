package com.gs.csmall.product.webapi;

import com.gs.csmall.commons.config.CsmallCommonsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({CsmallCommonsConfiguration.class})
@SpringBootApplication
public class CsmallProductWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsmallProductWebapiApplication.class, args);
    }

}
