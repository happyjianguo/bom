package jie.iaa.bom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import jie.iaa.bom.utils.BomUtils;

@SpringBootApplication
public class BomApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BomApplication.class, args);
		// 持有Spring应用上下文
		BomUtils.setContext(context);
	}
}
