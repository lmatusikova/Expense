package sk.matusikoval.expense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sk.matusikoval.expense.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findByAuthority(String authority);
}
