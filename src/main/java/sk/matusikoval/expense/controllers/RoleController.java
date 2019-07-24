package sk.matusikoval.expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sk.matusikoval.expense.entities.Role;
import sk.matusikoval.expense.exceptions.AuthorityAlreadyExistsException;
import sk.matusikoval.expense.exceptions.RoleNotFoundException;
import sk.matusikoval.expense.services.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/{id}")
	public @ResponseBody Role getRoleById(@PathVariable("id") Long id) throws RoleNotFoundException {
		return roleService.getRoleById(id);
	}

	@GetMapping
	public @ResponseBody List<Role> getAllRoles() {
		List<Role> roles = roleService.getAllRoles();
		return roles;
	}

	@PostMapping
	public ResponseEntity<Role> addRole(@RequestBody Role role) throws AuthorityAlreadyExistsException {
		roleService.addRole(role);
		return ResponseEntity.ok(role);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteRole(@PathVariable("id") Long id) throws RoleNotFoundException {
		roleService.deleteRole(id);
		return ResponseEntity.ok(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable("id") Long id, @RequestBody Role role) throws RoleNotFoundException {
		roleService.updateRole(id, role);
		return ResponseEntity.ok(role);
	}
}
