package com.iu.s3.account;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class AccountServiceTest extends MyAbstractTest {

	@Autowired
	private AccountService accountService;
	
	@Test
	public void setInsertTest() throws Exception {
		accountService.setInsert(null);
	}
}
