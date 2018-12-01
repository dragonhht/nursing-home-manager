package com.github.dragonhht.manager;

import com.github.dragonhht.manager.model.*;
import com.github.dragonhht.manager.params.FormStatus;
import com.github.dragonhht.manager.repository.*;
import com.github.dragonhht.manager.util.BeanUtil;
import com.github.dragonhht.manager.util.PasswordUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NursingHomeManagerApplicationTests {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private FamilyRepository familyRepository;
	@Autowired
	private BaseRoleRepository baseRoleRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
	private ApplyFormRepository applyFormRepository;
	@Autowired
	private PayDetailsRepository payDetailsRepository;
	@Autowired
	private BedRecordRepository bedRecordRepository;
	@Autowired
	private BedRepository bedRepository;

	@Test
	public void contextLoads() {
		Family family = new Family();
		family.setAddress("中国");
		family.setName("家属");
		family.setPhone("12345678901");
		PasswordUtil passwordUtil = PasswordUtil.getInstance();
		family.setPassword(passwordUtil.encryption("123"));
		Set<Role> roles = new HashSet<>();
		roles.add(new Role("USER"));
		roles.add(new Role("ADMIN"));
		family.setRoles(roles);
		familyRepository.save(family);
	}

	@Test
	public void getRole() {
		/*List<BaseRole> roles = baseRoleRepository.findAll();
		System.out.println(roles.get(0).getRole());*/
//        System.out.println(baseRoleRepository.findPasswordById(2L));
        baseRoleRepository.findRolesById(1)
                .forEach(System.out::println);
	}

	@Test
    public void initRole() {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("EMPLOYEE"));
    }

    @Test
	public void deBase() {
		String str = "eyJyb2xlcyI6WyJBRE1JTiIsIlVTRVIiXSwiaXNzIjoiMyIsImlhdCI6MTUzODQwNTk2NH0";
		System.out.println(new String(Base64Utils.decode(str.getBytes())));
	}

	@Test
	public void testForm() {
		ApplyForm form = new ApplyForm();
		form.setAge(80);
		form.setName("测试");
		form.setPhysical("健康");
		form.setStatus(FormStatus.DRAFT);
		Family family = new Family();
		family.setId(4);
		form.setFamily(family);
		applyFormRepository.save(form);
	}

	@Test
	public void beanTest() {
        System.out.println(PasswordUtil.getInstance().encryption("1234"));
	}

	@Test
	public void test2() {
		Person person = new Person();
		person.setAge(80);
		person.setName("ceshi");
		person.setPhysical("健康");
		personRepository.save(person);
		Bed bed = new Bed();
		bed.setDouble(false);
		bed.setPrice(300);
		bed.setUsed(false);
		bed.setId("302");
		bedRepository.save(bed);
		BedRecord record = new BedRecord();
		record.setBed(bed);
		record.setEndDate(new Date());
		record.setPerson(person);
		record.setReserve(true);
		record.setStartDate(new Date());
		record.setStatus(FormStatus.PENDING);
		bedRecordRepository.save(record);
		PayDetails details = new PayDetails();
		details.setPerson(person);
		details.setPrice(233);
		details.setStatus(false);
		details.setTime(new Date());
		details.setType("NURES");
		payDetailsRepository.save(details);
	}

	@Test
	public void addEmployee() {
		Employee employee = new Employee();
		employee.setAddress("中国");
		employee.setName("测试2");
		employee.setPassword("123");
		employeeRepository.save(employee);
	}
}
