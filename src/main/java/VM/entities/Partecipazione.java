package VM.entities;

import javax.persistence.*;

@Entity
public class Partecipazione {

    @Id
    @GeneratedValue
    private long ID;
    @ManyToOne
    @JoinColumn(name="persona_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
