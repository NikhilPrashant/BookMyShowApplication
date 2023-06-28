package com.nikhilprashant.book_my_show_app.EntryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntryDto {

    private String name;
    private int age;
    private String email;
    private String mobileNo;
    private String address;
}
