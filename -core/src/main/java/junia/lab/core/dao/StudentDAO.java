package junia.lab.core.dao;

import junia.lab.core.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentDAO extends JpaRepository<Student,Long> {

    @Query("SELECT DISTINCT s FROM Student s WHERE s.mail=:mail")
    public Student getOneByEmail(@Param("mail") String mail);

}
