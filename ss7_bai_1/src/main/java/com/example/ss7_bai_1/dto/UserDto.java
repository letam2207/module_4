package com.example.ss7_bai_1.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;


    @Pattern(regexp = "^[A-Za-z ]{5,45}$", message = "Tên phải  đúng định dạng.")
    @NotNull(message = "Không được  để trống trường này")
    private String firstname;

    @Pattern(regexp = "^[A-Za-z ]{5,45}$", message = "Họ phải  đúng định dạng.")
    @NotNull(message = "Không được  để trống trường này")
    private String lastname ;

    @NumberFormat
    @NotNull(message = "Không được  để trống trường này")
    private Integer phoneNumber ;

    @Min(value = 18,message = "Tuổi phải lớn hơn hoặc bằng 18")
    @NumberFormat
    @NotNull(message = "Không được  để trống trường này")
    private Integer age ;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",message = "Nhập đúng định dạng email VD:abc123@gmail.com")
    @NotNull(message = "Không được  để trống trường này")
    private String email ;

}
