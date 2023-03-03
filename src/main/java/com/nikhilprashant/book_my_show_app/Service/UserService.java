package com.nikhilprashant.book_my_show_app.Service;

import com.nikhilprashant.book_my_show_app.Converters.UserConverters;
import com.nikhilprashant.book_my_show_app.Entities.UserEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.UserEntryDto;
import com.nikhilprashant.book_my_show_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserEntryDto userEntryDto) throws Exception {
        UserEntity userEntity = UserConverters.convertUserDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        return "User added successfully";
    }
}
