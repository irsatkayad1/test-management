package com.example.securudemo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.history.HistoryProject;
import com.example.securudemo.model.project.Project;
import com.example.securudemo.model.project.Requirement;
import com.example.securudemo.model.role.Permission;
import com.example.securudemo.model.role.RoleGroup;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.history.HistoryProjectRepository;
import com.example.securudemo.repository.project.ProjectRepository;
import com.example.securudemo.repository.project.RequirementRepository;
import com.example.securudemo.repository.role.PermissionRepository;
import com.example.securudemo.repository.role.RoleGroupRepository;
import com.example.securudemo.repository.role.UserRepository;

@Service
public class DbInit implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleGroupRepository roleGroupRepository;
	
	@Autowired
	PermissionRepository permissionRepository;	
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	HistoryProjectRepository historyProjectRepository;
		
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws ParseException {
		
		//userRepository.deleteAll();
		//roleGroupRepository.deleteAll();
		//permissionRepository.deleteAll();
		
		List<String> perms = Arrays.asList("CREATE-USER","READ-USER","UPDATE-USER","DELETE-USER",
											"CREATE-ROLEGROUP","READ-ROLEGROUP","UPDATE-ROLEGROUP","DELETE-ROLEGROUP",
											"CREATE-PERMISSION","READ-PERMISSION","UPDATE-PERMISSION","DELETE-PERMISSION",
											"CREATE-PROJECT","READ-PROJECT","UPDATE-PROJECT","DELETE-PROJECT",
											"CREATE-REQUIREMENT","READ-REQUIREMENT","UPDATE-REQUIREMENT","DELETE-REQUIREMENT",
											"CREATE-TESTCASE","READ-TESTCASE","UPDATE-TESTCASE","DELETE-TESTCASE",
											"CREATE-STEP","READ-STEP","UPDATE-STEP","DELETE-STEP",
											"CREATE-MILESTONE","READ-MILESTONE","UPDATE-MILESTONE","DELETE-MILESTONE",
											"CREATE-DEFECT","READ-DEFECT","UPDATE-DEFECT","DELETE-DEFECT");
	 

		List<String> userPerms = Arrays.asList("CREATE-USER","READ-USER","UPDATE-USER","DELETE-USER");

		List<String> roleGroupPerms = Arrays.asList("CREATE-ROLEGROUP","READ-ROLEGROUP","UPDATE-ROLEGROUP","DELETE-ROLEGROUP");
		
		List<String> permissionPerms = Arrays.asList("CREATE-PERMISSION","READ-PERMISSION","UPDATE-PERMISSION","DELETE-PERMISSION");
		
		List<String> projectPerms = Arrays.asList("CREATE-PROJECT","READ-PROJECT","UPDATE-PROJECT","DELETE-PROJECT");

		List<String> requirementPerms = Arrays.asList("CREATE-REQUIREMENT","READ-REQUIREMENT","UPDATE-REQUIREMENT","DELETE-REQUIREMENT");

		List<String> testCasePerms = Arrays.asList("CREATE-TESTCASE","READ-TESTCASE","UPDATE-TESTCASE","DELETE-TESTCASE");		

		List<String> stepPerms = Arrays.asList("CREATE-STEP","READ-STEP","UPDATE-STEP","DELETE-STEP");

		List<String> mileStonePerms = Arrays.asList("CREATE-MILESTONE","READ-MILESTONE","UPDATE-MILESTONE","DELETE-MILESTONE");
		
		List<String> defectPerms = Arrays.asList("CREATE-DEFECT","READ-DEFECT","UPDATE-DEFECT","DELETE-DEFECT");
			
		
		//database create edildikten sonra her açılışında tekrar üretilmesine gerek yok **line : 87-96**
//		User admin = new User("admin", passwordEncoder.encode("admin"));
//		userRepository.save(admin);
//		
//		RoleGroup rg = new RoleGroup("ADMIN", admin);
//		roleGroupRepository.save(rg);
//		
//		for (String perm : perms) {
//			Permission permission = new Permission(perm, rg);
//			permissionRepository.save(permission);
//		}
		
		
		//yeni proje oluşturur
//		Project pro = new Project("projectX", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), "waiting", admin);
//		projectRepository.save(pro);
//		System.out.println(projectRepository.findByProjectName("projectX"));
//		//oluşturulan projenin history verilerini kaydeder
//		HistoryProject hp = new HistoryProject(pro,new Date(System.currentTimeMillis()),admin,"create");
//		historyProjectRepository.save(hp);
//		System.out.println(hp);
//		//projede update gerçekleşir
//		pro.setStatus("onStage");
//		projectRepository.save(pro);
//		//update'ten sonra tekrar history verileri kaydedilir
//		HistoryProject hp2 = new HistoryProject(pro,new Date(System.currentTimeMillis()),pro.getCreatedBy(),"update");
//		historyProjectRepository.save(hp2);
//		System.out.println(hp2);
		
		
		
//		userRepository.deleteAll();
//		roleGroupRepository.deleteAll();
//		permissionRepository.deleteAll();
//		projectRepository.deleteAll();
//		requirementRepository.deleteAll();
//		//Create 1st Role and User
//		User salih = new User("salih",passwordEncoder.encode("salih"));
//		User irsat = new User("irsat",passwordEncoder.encode("irsat"));
//		User enes = new User("enes",passwordEncoder.encode("enes"));
//		User furkan = new User("furkan",passwordEncoder.encode("furkan"));
//		
//		RoleGroup admin = new RoleGroup("ADMIN",salih);
//		RoleGroup tester = new RoleGroup("TESTER",irsat);
//		RoleGroup developer = new RoleGroup("DEVELOPER",enes);
//		RoleGroup user = new RoleGroup("USER",furkan);
//		RoleGroup admin2 = new RoleGroup("ADMIN",irsat);
//		
//		Permission createRoleGroup = new Permission("CREATE-ROLEGROUP",admin);
//		Permission readRoleGroup = new Permission("READ-ROLEGROUP",admin);
//		Permission createProject = new Permission("CREATEPROJECT",admin);
//		Permission createProject1 = new Permission("CREATEPROJECT",admin2);
//		Permission readProject = new Permission("READPROJECT",user);
//		Permission readProject1 = new Permission("READPROJECT",admin);
//		Permission readProject2 = new Permission("READPROJECT",admin2);
//		Permission readProject3 = new Permission("READPROJECT",tester);
//		Permission readProject4 = new Permission("READPROJECT",developer);
//		
//		userRepository.saveAll(Arrays.asList(salih,irsat,enes,furkan));
//		roleGroupRepository.saveAll(Arrays.asList(admin,tester,developer,user,admin2));
//		permissionRepository.saveAll(Arrays.asList(createProject,createProject1,
//				readProject,readProject1,readProject2,readProject3,readProject4,
//				createRoleGroup,readRoleGroup));
//		
//		//Create Role with RoleName and Permission		
//		
//		
//		//--------------------proje oluştur-------------------------//
//		
//		Date exStart = new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-01");
//		Date exEnd = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-31");
//		
//		Project pro1 = new Project("ProjectX", exStart, exEnd, "waiting", userRepository.findByUserName("salih"));
//		Project pro2 = new Project("Projecty", exStart, exEnd, "flush", userRepository.findByUserName("irsat"));
//		pro1.setDescription("project x description");
//		pro2.setDescription("flushed");
//		projectRepository.saveAll(Arrays.asList(pro1,pro2));
//		
//		//------------------requirement oluştur------------------//
//		
//		Requirement req1 = new Requirement("req1");
//		req1.setProject(pro1);
//		requirementRepository.save(req1);	
		
	}
}
