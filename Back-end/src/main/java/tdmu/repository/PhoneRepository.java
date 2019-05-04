package tdmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdmu.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
