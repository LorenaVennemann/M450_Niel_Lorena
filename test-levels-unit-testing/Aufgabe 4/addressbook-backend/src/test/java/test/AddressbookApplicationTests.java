package test;

import ch.tbz.m450.AddressbookApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AddressbookApplication.class)
public class AddressbookApplicationTests {

  @Test
  void contextLoads() {
  }
}
