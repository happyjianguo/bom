package jie.iaa.bom.utils;

import org.springframework.context.ApplicationContext;

public class BomUtils {
	/** 持有Spring应用上下文 */
	private static ApplicationContext context = null;

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
}
