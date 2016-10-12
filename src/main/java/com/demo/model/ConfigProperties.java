package com.demo.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

public class ConfigProperties {
	@Value("${min.salary}")
	private BigDecimal minSalary;
	@Value("${max.salary}")
	private BigDecimal maxSalary;
	
	public BigDecimal getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}
	public BigDecimal getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}
}
