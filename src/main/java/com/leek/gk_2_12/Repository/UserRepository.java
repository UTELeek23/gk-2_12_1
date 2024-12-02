package com.leek.gk_2_12.Repository;

import com.leek.gk_2_12.Entity.Category;
import com.leek.gk_2_12.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.categories FROM User u WHERE u.id = :userId")
    List<Category> findCategoriesByUserId(@Param("userId") Long userId);
}
