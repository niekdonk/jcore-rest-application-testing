package nl.jcore.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class TestingWithTestContainers {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(MySQLContainer.NAME).withReuse(true).withUsername("root").withPassword("root");

    @Test
    void shouldStartupMysql() {
        Assertions.assertTrue(mySQLContainer.isRunning());
        var test = mySQLContainer.getContainerInfo();
        System.out.println(mySQLContainer.getDatabaseName());
        System.out.println(mySQLContainer.getBoundPortNumbers());

    }
}
