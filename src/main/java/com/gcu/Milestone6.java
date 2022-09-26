package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.gcu" })
@SpringBootApplication
public class Milestone6 
{
	/**
	 * The proper main of the application, it simple just looks at the SpringApp to see what to do and then does it.
	 * @param args
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(Milestone6.class, args);
	}

}
