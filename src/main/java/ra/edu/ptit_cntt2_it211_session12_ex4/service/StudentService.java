package ra.edu.ptit_cntt2_it211_session12_ex4.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ra.edu.ptit_cntt2_it211_session12_ex4.exception.StudentNotFoundException;
import ra.edu.ptit_cntt2_it211_session12_ex4.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private Long currentId = 1L;

    public StudentService() {
        students.add(new Student(currentId++, "SV001", "Nguyen Van A", "CNTT", 3.2));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    log.warn("StudentNotFoundException bị ném với id = {}", id);
                    return new StudentNotFoundException(id);
                });
    }

    public Student addStudent(Student student) {
        student.setId(currentId++);
        students.add(student);
        return student;
    }

    public Student updateStudent(Long id, Student studentUpdate) {
        Student student = getStudentById(id);

        student.setStudentCode(studentUpdate.getStudentCode());
        student.setFullName(studentUpdate.getFullName());
        student.setMajor(studentUpdate.getMajor());
        student.setGpa(studentUpdate.getGpa());

        return student;
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        students.remove(student);
    }
}
