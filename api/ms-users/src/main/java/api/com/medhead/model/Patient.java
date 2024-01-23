package api.com.medhead.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name="patients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "ssnumber"),
                @UniqueConstraint(columnNames = "email")
        })
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "postcode")
    private String postCode;
    @Column(name = "longitude")
    private double longitude = 0;
    @Column(name = "latitude")
    private double latitude = 0;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column (name= "birthdate")
    private LocalDate birthdate;
    @Column (name= "ssnumber")
    private String socialSecurityNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Patient(String email) {
        this.email = email;
    }

    public Patient(Integer id, String firstName, String lastName, String address, String city, String postCode, double longitude, double latitude, String phone, String email, LocalDate birthdate, String socialSecurityNumber, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.socialSecurityNumber = socialSecurityNumber;
        this.user = user;
    }

    public Patient() {
    }
}
