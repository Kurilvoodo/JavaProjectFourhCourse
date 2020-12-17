package app.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Strings")
public class Strings extends MusicInstrument {

    @Column(name = "tuning", length = 15)
    private String tuning;

    @Column(name = "countOfStrings")
    private  int countOfStrings;
    public Strings(){}
    public Strings(String name, String soundBankReference, String tuning, int countOfStrings){
        super(name, soundBankReference);
        this.tuning = tuning;
        this.countOfStrings = countOfStrings;
    }

    public  String getTuning(){return tuning;}
    public void setTuning(String tuning){this.tuning = tuning;}

    public int getCountOfStrings(){return countOfStrings;}
    public void setCountOfStrings(int countOfStrings){this.countOfStrings = countOfStrings;}
}
