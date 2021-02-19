package junia.lab.core.dao;

import junia.lab.core.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {
}
