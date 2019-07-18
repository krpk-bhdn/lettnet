package com.krpk.lettnet.repo;

import com.krpk.lettnet.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
