package VM;

import VM.dao.EventoDAO;
import VM.entities.Evento;
import VM.entities.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GestioneEventi {

    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");


    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);

        Evento concerto = new Evento("AC/DC", LocalDate.of(2023,02,12),"Concerto Rock degli AC/DC", TipoEvento.PUBBLICO,100000);

        Evento mostraartistica = new Evento("Bansky",LocalDate.of(2023,10,31), "Una mostra artistica delle foto dei murales di Bansky",TipoEvento.PUBBLICO,1000);

        Evento eventodibeneficenza = new Evento("Raccolta fondi",LocalDate.of(2022,12,31),"Raccolta fondi per ricerca contro il cancro",TipoEvento.PRIVATO,500);

//        sd.save(concerto);
//        sd.save(mostraartistica);
//        sd.save(eventodibeneficenza);

        long id = 3;
        Evento concertoDB= sd.getById(id);
        if (concertoDB != null) {
            System.out.println(concertoDB);
        }else {
            System.out.println(" l'evento con id: " + id + " non presente nel database");
        }

        long id2 = 1;
        Evento concertoDB2= sd.getById(id2);
        if (concertoDB2 != null) {
            System.out.println(concertoDB2);
        }else {
            System.out.println(" l'evento con id: " + id2 + " non presente nel database");
        }

        sd.delete(5);


    }
}
