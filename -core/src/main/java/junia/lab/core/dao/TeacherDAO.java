package junia.lab.core.dao;

import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {

    @Query("SELECT DISTINCT s FROM Student s WHERE s.email=:email")
    public Teacher getOneByEmail(@Param("email") String email);

}
