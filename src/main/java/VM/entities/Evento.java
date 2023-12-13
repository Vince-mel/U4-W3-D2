package VM.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="Titolo")
    private String titolo;
    @Column(name="Data_Evento")
    private LocalDate DataEvento;
    @Column(name = "Descrizione")
    private String descrizione;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private  Location location;

    @Enumerated(EnumType.STRING)
    private TipoEvento TipoEvento;
    @Column(name="Numero_max_partecipanti")
    private long numeroMassimoPartecipanti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<Partecipazione> partecipazioni;


    public Evento(String titolo, LocalDate dataEvento, String descrizione, Location location, VM.entities.TipoEvento tipoEvento, long numeroMassimoPartecipanti, List<Partecipazione> partecipazioni) {
        this.titolo = titolo;
        DataEvento = dataEvento;
        this.descrizione = descrizione;
        this.location = location;
        TipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.partecipazioni = partecipazioni;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return DataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        DataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public VM.entities.TipoEvento getTipoEvento() {
        return TipoEvento;
    }

    public void setTipoEvento(VM.entities.TipoEvento tipoEvento) {
        TipoEvento = tipoEvento;
    }

    public long getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", DataEvento=" + DataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", TipoEvento=" + TipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
