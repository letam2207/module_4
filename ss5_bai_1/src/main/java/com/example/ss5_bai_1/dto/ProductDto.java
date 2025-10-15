package com.example.ss5_bai_1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object cho Product
 * Dùng để nhận và validate dữ liệu từ form hoặc API.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Integer id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 0, message = "Giá sản phẩm phải lớn hơn hoặc bằng 0")
    private Double price;

    private String describe;

    @NotBlank(message = "Hãng sản xuất không được để trống")
    private String manufacturer;

}

//public class ProductDto {
//    private Integer id;
//
//    @NotBlank(message = "Tên sản phẩm không được để trống")
//    private String name;
//
//    @NotNull(message = "Giá không được để trống")
//    @Min(value = 0, message = "Giá phải >= 0")
//    private Double price;
//
//    @Size(max = 200, message = "Mô tả không quá 200 ký tự")
//    private String description;
//
//    @NotBlank(message = "Hãng sản xuất không được để trống")
//    private String manufacturer;
//}

//public class UserDto {
//    private Integer id;
//
//    @NotBlank(message = "Tên đăng nhập không được để trống")
//    @Size(min = 5, max = 20, message = "Tên đăng nhập từ 5–20 ký tự")
//    private String username;
//
//    @NotBlank(message = "Mật khẩu không được để trống")
//    @Size(min = 6, message = "Mật khẩu tối thiểu 6 ký tự")
//    private String password;
//
//    @Email(message = "Email không hợp lệ")
//    @NotBlank(message = "Email không được để trống")
//    private String email;
//
//    @Pattern(regexp = "0\\d{9}", message = "Số điện thoại gồm 10 chữ số và bắt đầu bằng 0")
//    private String phone;
//}
//
//public class CustomerDto {
//    private Integer id;
//
//    @NotBlank(message = "Họ tên không được để trống")
//    private String fullName;
//
//    @NotBlank(message = "Địa chỉ không được để trống")
//    private String address;
//
//    @Pattern(regexp = "0\\d{9}", message = "Số điện thoại phải gồm 10 chữ số và bắt đầu bằng 0")
//    private String phoneNumber;
//
//    @Email(message = "Email không hợp lệ")
//    private String email;
//}

//import org.springframework.format.annotation.DateTimeFormat;
//import java.time.LocalDate;
//
//public class EmployeeDto {
//    private Integer id;
//
//    @NotBlank(message = "Tên nhân viên không được để trống")
//    private String name;
//
//    @NotNull(message = "Ngày sinh không được để trống")
//    @Past(message = "Ngày sinh phải là trong quá khứ")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate birthday;
//
//    @NotBlank(message = "Vị trí không được để trống")
//    private String position;
//
//    @NotNull(message = "Lương không được để trống")
//    @Min(value = 1000000, message = "Lương tối thiểu là 1,000,000 VNĐ")
//    private Double salary;
//}

//public class OrderDto {
//    private Integer id;
//
//    @NotBlank(message = "Mã đơn hàng không được để trống")
//    private String code;
//
//    @NotNull(message = "Ngày đặt hàng không được để trống")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate orderDate;
//
//    @NotNull(message = "Tổng tiền không được để trống")
//    @Min(value = 0, message = "Tổng tiền phải lớn hơn hoặc bằng 0")
//    private Double totalAmount;
//
//    @NotNull(message = "Khách hàng không được để trống")
//    private Integer customerId;  // hoặc là CustomerDto customer;
//}

