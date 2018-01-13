package com.github.vivian;

import com.github.vivian.domain.OrangeAuthority;
import com.github.vivian.repository.UserRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VivianApplicationTests {

	@Autowired
	UserRoleMapper userRoleMapper;

	@Test
	public void initialRoleMember() throws Exception {
		List<String> masterNameList = new ArrayList<>();
		masterNameList.add("二级部门经理");
		masterNameList.add("三级部门主管");
		masterNameList.add("四级部门主管");
		for (int i = 0; i < 3; i++) {
			List<Integer> masterIdList = new ArrayList<>();
			Integer roleId = userRoleMapper.getRoleIdByName(masterNameList.get(i));
			masterIdList = userRoleMapper.getCorrespondMasterIdByLevel(i + 2);
            /*对角色批量插入部门主管*/
            if(roleId!=null&& !CollectionUtils.isEmpty(masterIdList)) {
				userRoleMapper.addRoleUserBatch(roleId, masterIdList);
			}
		}
	}

	@Test
	public void initialOrangeAuthority(){
		List<OrangeAuthority> orangeAuthorityList = userRoleMapper.getAllOrangeUserAuthority();
		userRoleMapper.initialOrangeUserAuthority(orangeAuthorityList);

	}

	@Test
	public void restTemplate(){
		OrangeAuthority orangeAuthority = new OrangeAuthority();
		orangeAuthority.setSsoId(1);
		orangeAuthority.setGuardianId(2);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("localhost:8088/vivian/index",orangeAuthority,OrangeAuthority.class);
	}

}
