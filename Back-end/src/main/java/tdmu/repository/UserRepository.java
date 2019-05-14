package tdmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tdmu.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT p FROM User p WHERE LOWER(p.username) = LOWER(:username)")
    public User findByUsername(@Param("username") String username);

    @Query("SELECT p FROM User p WHERE id = :id")
    public User findUserById(@Param("id") Long id);
}
