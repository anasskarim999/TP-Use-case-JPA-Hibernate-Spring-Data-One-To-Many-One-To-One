package ma.enset.hospital.service;

import ma.enset.hospital.entites.Consultation;
import ma.enset.hospital.entites.Medecin;
import ma.enset.hospital.entites.Patient;
import ma.enset.hospital.entites.RendezVous;


public interface IHospitalService
{
    Patient savePatient(Patient patient) ;
    Medecin saveMedecin(Medecin medecin) ;
    RendezVous saveRDV(RendezVous rendezVous ) ;
    Consultation saveConsultation(Consultation consultation) ;

}
