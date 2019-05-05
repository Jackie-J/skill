package top.jackie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.jackie.entity.RolePermission;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

}
