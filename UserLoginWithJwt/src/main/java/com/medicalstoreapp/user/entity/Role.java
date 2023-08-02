package com.medicalstoreapp.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Pavan Sai
 *
 *         Entity Class for Role details in Login Module
 */

@Entity
public class Role {
	
@Id
private String roleName;
private String roleDescription;
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public String getRoleDescription() {
	return roleDescription;
}
public void setRoleDescription(String roleDescription) {
	this.roleDescription = roleDescription;
}

}
