package sk.matusikoval.expense.repositories;


import org.springframework.data.repository.CrudRepository;

import sk.matusikoval.expense.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
