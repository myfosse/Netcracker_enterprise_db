package by.netcracker.enterprisedb.payload.request;

import by.netcracker.enterprisedb.dao.entity.ERole;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

/** @author Andrey Egorov */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateRequest {

  @NotNull private Long id;

  @NotBlank
  @Size(min = 2, max = 100)
  @Pattern(
          regexp = "^[a-zA-Z ,.'-]+$",
          message =
                  "Name not valid. Use only latin alphabet, hyphen, space, comma, period, with length from 2 to 100 characters")
  private String name;

  @NotBlank
  @Size(min = 2, max = 100)
  @Pattern(
          regexp = "^[a-zA-Z ,.'-]+$",
          message =
                  "Name not valid. Use only latin alphabet, hyphen, space, comma, period, with length from 2 to 100 characters")
  private String surname;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private LocalDate birthdate;

  private int insuranceNumber;

  private int amountOfHolidays;

  @NotBlank
  @Size(max = 60)
  @Email(message = "Email not valid")
  private String email;

  @NotBlank
  @Size(min = 8, max = 60)
  @Pattern(
          regexp = "((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
          message = "Password not secure. Please try to use dots and special symbols")
  private String password;

  @NotBlank
  @Size(min = 8, max = 60)
  @Pattern(
          regexp = "((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
          message = "Password not secure. Please try to use dots and special symbols")
  private String passwordConfirmation;

  @NotBlank
  @NotNull
  private Set<ERole> roles;
}
