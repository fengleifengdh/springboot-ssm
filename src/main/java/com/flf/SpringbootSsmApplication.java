package com.flf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.flf.dao")////必须加这个，不加报错，如果不加，也可以在每个mapper上添加@Mapper注释，并且这里还要多填一个注释，那个我忘了，我一直用这个注解
@EnableTransactionManagement//这个注解开启事物
@SpringBootApplication
public class SpringbootSsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSsmApplication.class, args);
		System.out.println("--");
	}
}
