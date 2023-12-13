package VM;

import VM.dao.EventoDAO;
import VM.dao.LocationDAO;
import VM.dao.PartecipazioneDAO;
import VM.dao.PersonaDAO;
import VM.entities.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestioneEventi {

    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");


    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);
        PersonaDAO ps = new PersonaDAO(em);
        PartecipazioneDAO pt = new PartecipazioneDAO(em);
        LocationDAO lc = new LocationDAO(em);



//
//        Evento mostraartistica = new Evento("Bansky",LocalDate.of(2023,10,31), "Una mostra artistica delle foto dei murales di Bansky",TipoEvento.PUBBLICO,1000);
//
//        Evento eventodibeneficenza = new Evento("Raccolta fondi",LocalDate.of(2022,12,31),"Raccolta fondi per ricerca contro il cancro",TipoEvento.PRIVATO,500);
//

        Location location1 = new Location("San Siro", "Milano");

        Persona persona1 = new Persona("Luca", "Panciullo", "lucapa@emai.it", LocalDate.now(), Sesso.M,new ArrayList<>());
        Evento concerto = new Evento("AC/DC", LocalDate.of(2023,02,12),"Concerto Rock degli AC/DC",location1, TipoEvento.PUBBLICO,100000,new ArrayList<>());
        Partecipazione partecipazione1 = new Partecipazione(persona1,concerto,Stato.CONFERMATA);

        lc.save(location1);
        sd.save(concerto);
        ps.save(persona1);
        pt.save(partecipazione1);


////





    }
}
