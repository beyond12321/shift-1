package cn.mldn.employee.service.impl;

import org.springframework.stereotype.Service;

import cn.mldn.api.ITestService;

@Service("testServiceAPI")
public class TestServiceImpl implements ITestService {

	@Override
	public void test() {
		System.out.println("Hello World!");
	}

}
