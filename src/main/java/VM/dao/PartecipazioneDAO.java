package VM.dao;

import VM.entities.Evento;
import VM.entities.Partecipazione;
import VM.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO{

    public final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(partecipazione);

        transaction.commit();;


        System.out.println("LA partecipazione di  " + partecipazione.getPersona() + " è stata aggiunta nel database");



    }
    public Partecipazione getById(long id) {

        return em.find(Partecipazione.class, id);
    }

    public void delete(long id) {

        Partecipazione found = this.getById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();;


            System.out.println("la partecipazione di " + found.getPersona() + " è stata eliminata dal database");

        } else {
            System.out.println("La partecipazione con id " + id + " non è stata trovata nel database");
        }

    }

}
