package ra.edu.ptit_cntt2_it211_session12_ex4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.ptit_cntt2_it211_session12_ex4.model.dto.ApiDataResponse;
import ra.edu.ptit_cntt2_it211_session12_ex4.model.entity.Student;
import ra.edu.ptit_cntt2_it211_session12_ex4.service.StudentService;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<?>> getAllStudents() {
        log.info("Request đến controller: GET /api/students");

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách sinh viên thành công!",
                studentService.getAllStudents(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> getStudentById(@PathVariable Long id) {
        log.info("Request đến controller: GET /api/students/{}", id);

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy sinh viên theo id thành công!",
                studentService.getStudentById(id),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<?>> addStudent(@RequestBody Student student) {
        log.info("Request đến controller: POST /api/students");

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm sinh viên thành công!",
                studentService.addStudent(student),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        log.info("Request đến controller: PUT /api/students/{}", id);

        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật sinh viên thành công!",
                studentService.updateStudent(id, student),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        log.info("Request đến controller: DELETE /api/students/{}", id);

        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
