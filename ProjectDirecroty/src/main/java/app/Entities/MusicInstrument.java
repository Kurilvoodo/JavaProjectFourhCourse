package app.Entities;
import javax.persistence.*;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "MusicInstruments")
public class MusicInstrument {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int idMusicInstrument;
    @Column(name = "instrumentName", length=20)
    public String name;
    @Column(name="soundBankReference", length=250)
    public String soundBankReference;


    @ManyToOne(targetEntity = Notes.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idNote")
    public Notes notes;

    @ManyToMany
    @JoinTable(name = "CompositionByInstruments", joinColumns =  @JoinColumn(name = "idMusicInstrument"),
                inverseJoinColumns =@JoinColumn(name = "idComposition"))
    private Set<Composition> compositions;

    public MusicInstrument(){}


    public MusicInstrument(String name, String soundBankReference){
        this.name = name;
        this.soundBankReference = soundBankReference;
    }
    public MusicInstrument(String name, String soundBankReference, Notes notes){
        this.name = name;
        this.soundBankReference = soundBankReference;
        this.notes = notes;
    }

    public Set<Composition> getCompositions(){return compositions;}
    public void setCompositions(Set<Composition> compositions){this.compositions = compositions;}

    public String getName() { return name;    }
    public void setName(String name){this.name = name;}

    public String getSoundBankReference(){return soundBankReference;}
    public void setSoundBankReference(String soundBankReference){this.soundBankReference = soundBankReference;}

    public Notes getNotes(){return notes;}
    public void setNotes(Notes notes){this.notes =notes;}

    public int getIdMusicInstrument() {return idMusicInstrument;   }
    public void setIdMusicInstrument(int id){this.idMusicInstrument = id;}
}
