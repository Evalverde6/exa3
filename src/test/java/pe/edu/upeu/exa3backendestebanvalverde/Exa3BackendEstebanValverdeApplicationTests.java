package pe.edu.upeu.exa3backendestebanvalverde;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Exa3BackendEstebanValverdeApplicationTests {
@Autowired BCryptPasswordEncoder bcry;
	@Test
	void contextLoads() {
		System.out.println(bcry.encode("123"));
	}

}
