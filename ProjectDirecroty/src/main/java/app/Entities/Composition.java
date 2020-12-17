package app.Entities;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="Composition")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComposition;
    @Column(name = "compositionName", length = 250)
    private String compositionName;
    @Column(name = "authorName",length = 50)
    private  String authorName;

    @ManyToMany
    @JoinTable(name="CompositionByInstruments", joinColumns = @JoinColumn(name = "idComposition"),
     inverseJoinColumns = @JoinColumn(name = "idMusicInstrument"))
    private  Set <MusicInstrument> musicInstruments;

    @Column(name = "duration")
    private double duration;

    public Composition(){}
    public Composition(String compositionName, String authorName, double duration)
    {
    this.compositionName = compositionName;
    this.authorName = authorName;
    this.duration = duration;
    }

    public int getIdComposition(){ return idComposition; }

    public void setIdComposition(int idComposition){ this.idComposition = idComposition;}

    public String getCompositionName(){return compositionName;}

    public void setCompositionName(String compositionName){this.compositionName = compositionName;}

    public String getAuthorName(){return authorName;}

    public void setAuthorName(String authorName){ this.authorName = authorName;}

    public Set<MusicInstrument> getMusicInstruments(){return musicInstruments;}

    public void setMusicInstruments(Set<MusicInstrument> musicInstruments){ this.musicInstruments = musicInstruments;}

    public double getDuration(){return duration;}

    public void setDuration(double duration){this.duration = duration;}

}
