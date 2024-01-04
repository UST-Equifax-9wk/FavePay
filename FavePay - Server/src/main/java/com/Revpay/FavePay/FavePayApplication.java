package com.Revpay.FavePay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FavePayApplication {

	public static void main(String[] args) {
		ApplicationContext iocContainer = SpringApplication.run(FavePayApplication.class, args);
		
	}

}
