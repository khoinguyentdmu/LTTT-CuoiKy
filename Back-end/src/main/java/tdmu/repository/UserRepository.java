package tdmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdmu.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
