package ma.enset.hospital;

import ma.enset.hospital.entites.*;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezvousRepository;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

    @Bean
	CommandLineRunner start(IHospitalService hospitalService
			,PatientRepository	patientRepository,RendezvousRepository	rendezvousRepository,
							MedecinRepository	medecinRepository) {
     return args -> {
		 Stream.of("Mohamed","Hassan","Najat")
				 .forEach(name -> {
					 Patient patient = new Patient();
					 patient.setName(name);
					 patient.setDateNaissance(new Date());
					 patient.setMalade(false);
					 hospitalService.savePatient(patient);
				 });

		 Stream.of("aymane","hanane","yasmine")
				 .forEach(name->{
					 Medecin medecin = new Medecin();
					 medecin.setName(name);
					 medecin.setEmail(name+"@gmail.com");
					 medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
					 hospitalService.saveMedecin(medecin);

				 });
		 Patient patient=patientRepository.findById(1L).orElse(null);
		 Patient patient1=patientRepository.findByName( "Mohamed");

		 Medecin medecin=medecinRepository.findByName("yasmine");

		 RendezVous rendezVous =new RendezVous();
		 rendezVous.setDate(new Date());
		 rendezVous.setStatus(StatusRDV.PENDING);
		 rendezVous.setMedecin(medecin);
		 rendezVous.setPatient(patient);
		RendezVous saveDRDV= hospitalService.saveRDV(rendezVous);
        System.out.println(saveDRDV.getId());

        RendezVous rendezVous1=rendezvousRepository.findAll().get(0);
		Consultation consultation=new Consultation();
		consultation.setDateConsultation(new Date());
		consultation.setRendezVous(rendezVous1);
		consultation.setRapport("Rapport de la consultation....");
		hospitalService.saveConsultation(consultation);

	 };

	}
}
