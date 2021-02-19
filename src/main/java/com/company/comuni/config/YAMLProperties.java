package com.company.comuni.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-properties-2
 * 
 * @author aminnucci
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "excel")
@PropertySource(value = "classpath:configExcel.yml", factory = YamlPropertySourceFactory.class)
public class YAMLProperties {
	
	private String fileName;
		
	private String sheetName;
	
	private Map<String, Integer> columnsMapping;
	
	private String[] list;

}
