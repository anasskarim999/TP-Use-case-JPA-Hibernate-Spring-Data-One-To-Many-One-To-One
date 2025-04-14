package ma.enset.hospital.repositories;

import ma.enset.hospital.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient, Long> {
    Patient findByName(String name);
}
