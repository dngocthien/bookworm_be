package com.nash.bookworm.repo;

import com.nash.bookworm.entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Userr, Long> {
}
