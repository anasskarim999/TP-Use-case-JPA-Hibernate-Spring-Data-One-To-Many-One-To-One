package ma.enset.hospital.repositories;

import ma.enset.hospital.entites.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository  extends JpaRepository<Medecin, Long> {
    Medecin findByName(String name);
}
