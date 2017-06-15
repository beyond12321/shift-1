package cn.mldn.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.api.IEmpService;
import cn.mldn.api.ITestService;
import cn.mldn.vo.Emp;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/dubbo-consumer.xml")
public class IEmpServiceTest {
	@Resource
	private IEmpService empService;
	
	@Test
	public void testAddpre() {
		System.err.println(empService);
		System.err.println(empService.addpre());   
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		System.err.println(empService.get(1l));
		try {
			Thread.sleep(10000); 
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
	}
	
	@Test
	public void testAdd() {
		Emp vo = new Emp();
		vo.setName("hello");
		vo.setTeamId(1l);
		TestCase.assertTrue(empService.add(vo, false)); 
	}
	
	@Test
	public void testList() {
		System.err.println(empService.list("name", "z", 1L, 5));  
	}
	
	@Test
	public void testDelete() {
		System.out.println(empService.delete(3123456767893l));
	} 
}
