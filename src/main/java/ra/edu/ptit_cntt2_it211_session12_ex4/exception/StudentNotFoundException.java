package ra.edu.ptit_cntt2_it211_session12_ex4.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Không tìm thấy sinh viên có id = " + id);
    }
}
