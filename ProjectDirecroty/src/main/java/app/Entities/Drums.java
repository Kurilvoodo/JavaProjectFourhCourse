package app.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Drums")
public class Drums extends MusicInstrument {
    @Column(name = "countOfToms")
    private int countOfToms;
    @Column(name = "countOfCymbals")
    private int countOfCymbals;
    @Column(name = "cordan")
    private boolean cordan;

    public Drums(){}
    public Drums(String name, String soundBankReference,int countOfToms, int countOfCymbals, boolean cordan){
        super(name,soundBankReference);
        this.countOfCymbals = countOfCymbals;
        this.countOfToms = countOfToms;
        this.cordan = cordan;
    }
    public int getCountOfToms(){return countOfToms;}

    public  void setCountOfToms(int countOfToms){this.countOfToms = countOfToms;}

    public int getCountOfCymbals(){return countOfCymbals;}

    public void setCountOfCymbals(int countOfCymbals){this.countOfCymbals = countOfCymbals;}

    public boolean getCordan(){return cordan;}

    public void setCordan(boolean cordan){this.cordan =cordan;}
}
