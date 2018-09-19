//package com.github.dragonhht.manager;
//
//import com.github.dragonhht.manager.model.Family;
//import com.github.dragonhht.manager.model.Person;
//import com.github.dragonhht.manager.repository.FamilyRepository;
//import com.github.dragonhht.manager.repository.PersonRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class NursingHomeManagerApplicationTests {
//
//	@Autowired
//	private PersonRepository personRepository;
//	@Autowired
//	private FamilyRepository familyRepository;
//
//	@Test
//	public void contextLoads() {
//		Person person = new Person();
//		person.setAge(80);
//		person.setName("haha");
//		person.setSex("男");
//		Family family = new Family();
//		family.setAddress("中国");
//		family.setName("家属");
//		family.setPhone("12345678901");
//		person.setFamily(family);
//		familyRepository.save(family);
//		personRepository.save(person);
//	}
//
//}
