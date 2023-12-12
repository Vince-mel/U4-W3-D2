package VM.dao;

import VM.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class EventoDAO {

        private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(evento);

        transaction.commit();;


        System.out.println("evento " + evento.getTitolo() + " aggiunto nel database");



    }
    public Evento getById(long id) {

        return em.find(Evento.class, id);
    }

    public void delete(long id) {

        Evento found = this.getById(id);
            if (found != null) {
                EntityTransaction transaction = em.getTransaction();

                transaction.begin();

                em.remove(found);

                transaction.commit();;


                System.out.println("l'evento " + found.getTitolo() + " è stato eliminato dal database");

            } else {
                System.out.println("L'evento con id " + id + " non è stato trovato nel database");
            }

    }
}
