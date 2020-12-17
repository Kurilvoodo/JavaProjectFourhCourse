package app.Entities;
import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNote;

    @Column(name = "key")
    private String key;

    @Column(name = "description")
    private String description;

    @Column(name = "temp")
    private int temp;

    @OneToMany(mappedBy = "notes")
    private Set<MusicInstrument> musicInstruments;

    public Notes(){}
    public Notes(String key, String description, int temp){
        this.key = key;
        this.description = description;
        this.temp = temp;
    }
    public int getIdNote(){return idNote;}

    public void setIdNote(int idNote){this.idNote = idNote;}

    public String getKey(){return key;}

    public void setKey(String key){this.key = key;}

    public int getTemp(){return temp;}

    public void setTemp(int temp){this.temp = temp;}

    public Set<MusicInstrument> getMusicInstruments(){return musicInstruments;}

    public void setMusicInstruments(Set<MusicInstrument> musicInstruments){this.musicInstruments = musicInstruments;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description =description;}

}
