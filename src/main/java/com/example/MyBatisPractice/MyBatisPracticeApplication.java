package com.example.MyBatisPractice;

import com.example.MyBatisPractice.entity.Mansion;
import com.example.MyBatisPractice.repository.MansionRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
@MapperScan("com.example.MyBatisPractice.repository")
public class MyBatisPracticeApplication {
	@Autowired
	MansionRepository mansionRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MyBatisPracticeApplication.class, args);
		MyBatisPracticeApplication app = context.getBean(MyBatisPracticeApplication.class);
		app.execute();
	}

	private void execute() {
		List<Mansion> list = mansionRepository.selectAll();
		System.out.println(list);
		Mansion mansion = mansionRepository.selectById(1);
		System.out.println(mansion);
	}
}
