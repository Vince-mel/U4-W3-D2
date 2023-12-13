package VM.dao;

import VM.entities.Evento;
import VM.entities.Location;
import VM.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {

    public final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(location);

        transaction.commit();;


        System.out.println("La Location " + location.getNome() + " è stata aggiunta nel database");



    }
    public Location getById(long id) {

        return em.find(Location.class, id);
    }

    public void delete(long id) {

        Location found = this.getById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();;


            System.out.println("la Location " + found.getNome() + " è stata eliminata dal database");

        } else {
            System.out.println("La Location con id " + id + " non è stata trovata nel database");
        }

    }
}
