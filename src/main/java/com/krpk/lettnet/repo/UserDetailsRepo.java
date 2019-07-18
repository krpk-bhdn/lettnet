package com.krpk.lettnet.repo;

import com.krpk.lettnet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
