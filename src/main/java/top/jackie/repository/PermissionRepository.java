package top.jackie.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import top.jackie.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    
    @Query(value = "select c.* from course c inner join relation r on c.id=r.course_id where r.student_id=?", nativeQuery = true)
    public Set<String> findByStudentId(Integer studentId);

}
