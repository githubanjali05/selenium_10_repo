package com.qspiders.laptop;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.HomePage;
@Listeners()
public class TC_DWS_100_Laptop extends BaseClass{
	
		@Test
		public void addToCart() {
			hp=new HomePage(driver);
			hp.getLaptop().click();
			
		}
		
	}


