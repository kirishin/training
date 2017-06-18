package com.example.umatsu.trainingCRUD;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:applicationContext.xml")
@MapperScan("com.example.umatsu.trainingCRUD.mapper")
@SpringBootApplication
public class TrainingCrudApplication {
	// public class TrainingCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrainingCrudApplication.class, args);
	}
	// @Autowired JdbcTemplate jdbc;
	//
	// // アプリ起動時に実行される。
	// @Override public void run(String... args) throws Exception {
	// jdbc.execute("create table task (id serial, name varchar(255))");
	// jdbc.update("insert into task (name) values (?)", "First Task.");
	// }
}
