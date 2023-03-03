package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
