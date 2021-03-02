package com.pay;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@MapperScan(basePackageClasses = Application.class)
@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
