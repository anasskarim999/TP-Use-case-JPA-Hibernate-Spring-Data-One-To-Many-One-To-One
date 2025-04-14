package ma.enset.hospital.repositories;

import ma.enset.hospital.entites.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<RendezVous,String> {
}
