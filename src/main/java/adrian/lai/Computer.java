package adrian.lai;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity (name = "computer")
@Table (name = "computer")
@Setter
@Getter
@AllArgsConstructor
@ToString
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

    //How do I create a computer by just creating it.
    //I don't even want to have to input the date.

    public Computer(LocalDate creationDate){
        this.creationDate = creationDate;
        this.lastRevisionDate = creationDate;
        this.nextRevisionDate = creationDate.plusYears(2);
        this.needsRevision = false;

        }

    public Computer(){
        this.creationDate = LocalDate.now();
        this.lastRevisionDate = creationDate;
        this.nextRevisionDate = creationDate.plusYears(2);
        this.needsRevision = false;
    }
}