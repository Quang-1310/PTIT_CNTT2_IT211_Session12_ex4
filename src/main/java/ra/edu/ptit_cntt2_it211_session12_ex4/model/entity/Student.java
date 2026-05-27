package ra.edu.ptit_cntt2_it211_session12_ex4.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Student {
    private Long id;
    private String studentCode;
    private String fullName;
    private String major;
    private Double gpa;
}