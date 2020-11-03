package base.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "AnimalLoss")
public class AnimalLoss {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean isActual;
    private Date date;
    private long coordLong;
    private long coordLat;
    private Timestamp createDate;
    private String email;
    private String city;
    private String phoneNumber;

    private String name;
    private String breed;
    private String age;
    private String colour;
    private boolean gender;
    private boolean isFoundOrLost;
    private String reward;
    private String description;

    public AnimalLoss() {
    }

    //getter and setter stuff

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isFoundOrLost() {
        return isFoundOrLost;
    }

    public void setFoundOrLost(boolean foundOrLost) {
        isFoundOrLost = foundOrLost;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCoordLong() {
        return coordLong;
    }

    public void setCoordLong(long coordLong) {
        this.coordLong = coordLong;
    }

    public long getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(long coordLat) {
        this.coordLat = coordLat;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
