package top.jackie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.jackie.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
