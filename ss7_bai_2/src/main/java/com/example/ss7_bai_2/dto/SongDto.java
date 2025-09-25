package com.example.ss7_bai_2.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    private Integer id;


    @NotBlank(message = "Không được phép để trống")
    @Size(max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Vui lòng nhập đúng định dạng.")
    private String songName;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 300, message = "Không vượt quá 300 ký tự")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Vui lòng nhập đúng định dạng .")
    private String artistName ;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[A-Za-z ,]+$", message = "Vui lòng nhập đúng định dạng (chỉ chữ cái, khoảng trắng và dấu phẩy).")
    private String musicGenre ;

}
