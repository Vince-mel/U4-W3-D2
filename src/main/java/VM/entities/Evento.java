package VM.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    @Enumerated(EnumType.STRING)
    private TipoEvento TipoEvento;
    @Column(name="Numero_max_partecipanti")
    private long numeroMassimoPartecipanti;

    public Evento() {

    }
    public Evento(String titolo, LocalDate dataEvento, String descrizione, VM.entities.TipoEvento tipoEvento, long numeroMassimoPartecipanti) {
        this.titolo = titolo;
        DataEvento = dataEvento;
        this.descrizione = descrizione;
        TipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
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

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
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
