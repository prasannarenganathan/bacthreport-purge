package com.cnasurety.extagencyint.batches.ivans.purge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.cnasurety.extagencyint.batches.ivans.*" })
public class IvansPurgeBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(IvansPurgeBatchApplication.class, args);
        System.exit(0);
    }

}
