package com.example.user.management.domain.repository.userrole;

import java.util.List;
import ANACONDA.Role;

public interface RoleRepository {
	List<Role> findOne(String userID);
	void createRole(Role Role);
	List<String> findSearchedUsers(String role);
	void delete(String userID);
}
