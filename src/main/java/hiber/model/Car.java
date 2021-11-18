package hiber.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Gaziz Bakyt
 */
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

    public Car() {}

    public Car(String name, String series) {
        this.name = name;
        this.series = series;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private String series;

    @OneToOne(mappedBy = "car")
    private User user;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getSeries(), car.getSeries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSeries());
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}
