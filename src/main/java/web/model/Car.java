package web.model;
import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private String engine;

    @Column
    private int series;


    public Car() {
    }

    public Car(String model, String engine, int series) {
        this.model = model;
        this.engine = engine;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public int getSeries() {
        return series;
    }
}
