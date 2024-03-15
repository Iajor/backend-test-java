package org.restapiparkinglot.restapiparkinglot.model;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Entity
@Table(name = "parkinglot")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Setter
    @Column(name = "name", nullable = false) private String name;
    @Setter
    @Column(name = "cnpj", nullable = false, unique = true, length = 14) private int cnpj;
    @Setter
    @Column(name = "address", nullable = false) private String address;
    @Setter
    @Column(name = "phonenumber", nullable = false, unique = true, length = 11) private int phoneNumber;
    @Setter
    @Column(name = "vacancymotorcycle", nullable = false) private int vacancyMotorcycle;
    @Setter
    @Column(name = "vacancycar", nullable = false) private int vacancyCar;
    @Setter
    @Column(name = "totalparkedmotorcycle") private int totalParkedMotorcycle;
    @Setter
    @Column(name = "totalparkedcar") private int totalParkedCar;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vehicles",
            joinColumns = @JoinColumn(name = "parkinglot_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id", referencedColumnName = "id"))

    @Setter private List<Vehicle> vehicles;

    public ParkingLot() {

    }
}
