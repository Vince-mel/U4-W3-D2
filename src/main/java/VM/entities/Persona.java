package VM.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Persona {

    @Id
    @GeneratedValue
    private long ID;
    @Column(name = "nome")
    private String nome;

    @Column(name="cognome")
    private String cognome;

    @Column(name="email")
    private String email;

    @Column(name = "Data_di_Nascita")
    private LocalDate data_di_nascita;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy= "persona")
    @OrderBy("dataEvento ASC")
    private List<Partecipazione> listaPartecipazione;

    public Persona(String nome, String cognome, String email, LocalDate data_di_nascita, Sesso sesso, List<Partecipazione> listaPartecipazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;
        this.listaPartecipazione = listaPartecipazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazione() {
        return listaPartecipazione;
    }

    public void setListaPartecipazione(List<Partecipazione> listaPartecipazione) {
        this.listaPartecipazione = listaPartecipazione;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", sesso=" + sesso +
                ", listaPartecipazione=" + listaPartecipazione +
                '}';
    }
}
