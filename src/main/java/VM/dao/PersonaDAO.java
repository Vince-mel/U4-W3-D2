package VM.dao;


import VM.entities.Evento;
import VM.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {

    public final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(persona);

        transaction.commit();;


        System.out.println("persona " + persona.getNome() + " aggiunta nel database");



    }
    public Persona getById(long id) {

        return em.find(Persona.class, id);
    }

    public void delete(long id) {

        Persona found = this.getById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();;


            System.out.println("la persona " + found.getNome() + " è stata eliminata dal database");

        } else {
            System.out.println("La persona con id " + id + " non è stata trovata nel database");
        }

    }
}
