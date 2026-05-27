package ra.edu.ptit_cntt2_it211_session12_ex4.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String error;
    private Integer status;
}
