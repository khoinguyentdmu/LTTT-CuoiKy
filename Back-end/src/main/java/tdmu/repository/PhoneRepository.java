package tdmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tdmu.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query("SELECT p FROM Phone p WHERE id = :id")
    public Phone findPhoneById(@Param("id") Long id);
}
