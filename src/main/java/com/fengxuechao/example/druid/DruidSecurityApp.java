package com.fengxuechao.example.druid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author fengxuechao
 * @date 2020/10/15
 */
@Slf4j
@SpringBootApplication
public class DruidSecurityApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DruidSecurityApp.class);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        List<Users> users = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(Users.class));
        log.info("输出结果: {}", users);
    }
}
