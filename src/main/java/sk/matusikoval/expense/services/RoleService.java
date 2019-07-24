package sk.matusikoval.expense.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.matusikoval.expense.entities.Role;
import sk.matusikoval.expense.exceptions.AuthorityAlreadyExistsException;
import sk.matusikoval.expense.exceptions.RoleNotFoundException;
import sk.matusikoval.expense.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRoleById(Long roleId) throws RoleNotFoundException {
		if(!roleRepository.existsById(roleId))
			throw new RoleNotFoundException("Authority with ID = " + roleId + " not found.");
		return roleRepository.findById(roleId).get();
	}	

	public List<Role> getAllRoles() {
		List<Role> list = new ArrayList<>();
		roleRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public void addRole(Role role) throws AuthorityAlreadyExistsException {
	        List<Role> list = roleRepository.findByAuthority(role.getAuthority()); 	
                if (list.size() > 0) {
    	           throw new AuthorityAlreadyExistsException("Authority: " + role.getAuthority() + " already exists.");
                } else {
                	roleRepository.save(role);
       }
	}

	public void updateRole(Long roleId, Role role) throws RoleNotFoundException {
		Role r = roleRepository.findById(roleId).orElseThrow(() ->
			new RoleNotFoundException("Update role with ID = " + roleId + " failed. || Role not found."));
		r.setId(roleId);
		r.setAuthority(role.getAuthority());
		roleRepository.save(r);
	}
	
	public void deleteRole(Long roleId) throws RoleNotFoundException {
		Role r = roleRepository.findById(roleId).orElseThrow(() ->
		new RoleNotFoundException("Delete role with ID = " + roleId + " failed. || Role not found."));
		roleRepository.delete(r);
	}
}
