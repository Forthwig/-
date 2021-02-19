package junia.lab.core.dao;

import junia.lab.core.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student,Long> {
}
