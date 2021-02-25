package junia.lab.core.dao;

import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {

    @Query("SELECT DISTINCT t FROM Teacher t WHERE t.mail=:mail")
    public Teacher getOneByEmail(@Param("mail") String mail);

}
