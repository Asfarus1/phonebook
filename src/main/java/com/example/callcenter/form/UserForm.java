package com.example.callcenter.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;

import static com.example.callcenter.form.Orders.Order1;
import static com.example.callcenter.form.Orders.Order2;

@Getter
@Setter
public class UserForm {
    final static String emptyMsg = "поле не может быть пустым!";
    final static String invalidLenghtMsg2to100 = "поле должно содержать от 2 до 100 символов!";
    final static String invalidLenghtMsg2to150 = "поле должно содержать от 2 до 150 символов!";
    final static String invalidLenghtMsg2to20 = "поле должно содержать от 2 до 20 символов!";
    final static String dataNotInPastMsg = "дата рождения должна быть меньше текущей!";

    @NotBlank(groups = Order1.class, message = emptyMsg)
    @Length(min = 2, max = 100, groups = Order2.class, message = invalidLenghtMsg2to100)
    private String name;

    @NotBlank(groups = Order1.class, message = emptyMsg)
    @Length(min = 2, max = 100, groups = Order2.class, message = invalidLenghtMsg2to100)
    private String surname;

    @NotBlank(groups = Order1.class, message = emptyMsg)
    @Length(min = 2, max = 100, groups = Order2.class, message = invalidLenghtMsg2to100)
    private String fatherName;

    @NotNull(groups = Order1.class, message = emptyMsg)
    @Past(groups = Order2.class, message = dataNotInPastMsg)
    private Date birthDate;

    @NotBlank(groups = Order1.class, message = emptyMsg)
    @Length(min = 2, max = 20, groups = Order2.class, message = invalidLenghtMsg2to20)
    private String phone;

    @NotBlank(groups = Order1.class, message = emptyMsg)
    @Length(min = 2, max = 150, groups = Order2.class, message = invalidLenghtMsg2to150)
    private String city;

    @NotBlank(groups = Order1.class, message = emptyMsg)
    @Length(min = 2, max = 150, groups = Order2.class, message = invalidLenghtMsg2to150)
    private String street;

    private int page;
}
