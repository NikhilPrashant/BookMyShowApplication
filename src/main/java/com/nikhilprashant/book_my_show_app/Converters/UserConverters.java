package com.nikhilprashant.book_my_show_app.Converters;

import com.nikhilprashant.book_my_show_app.Entities.UserEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.UserEntryDto;

public class UserConverters {
    public static UserEntity convertUserDtoToEntity(UserEntryDto userEntryDto) {
        UserEntity userEntity = UserEntity.builder()
                .name(userEntryDto.getName())
                .age(userEntryDto.getAge())
                .email(userEntryDto.getEmail())
                .mobileNo(userEntryDto.getMobileNo())
                .address(userEntryDto.getAddress())
                .build();
        return userEntity;
    }
}
