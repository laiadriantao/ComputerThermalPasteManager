package adrian.lai;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;



@Entity (name = "computer")
@Table (name = "computer")
@Data
@AllArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "last_revision_date")
    private LocalDate lastRevisionDate;
    @Column(name = "next_revision_date")
    private LocalDate nextRevisionDate;
    @Column(name = "needs_revision")
    private boolean needsRevision;


    //creates computer with date input
    public Computer(LocalDate creationDate){
        this.creationDate = creationDate;
        this.lastRevisionDate = creationDate;
        this.nextRevisionDate = creationDate.plusYears(2);

        //condition if computer needs revision
        if(this.nextRevisionDate.isBefore(LocalDate.now())){
            this.needsRevision = true;
        } else {
            this.needsRevision = false;
        }

    }

    //creates computer at current date
    public Computer(){
        this.creationDate = LocalDate.now();
        this.lastRevisionDate = creationDate;
        this.nextRevisionDate = creationDate.plusYears(2);
        this.needsRevision = false;
    }
}
