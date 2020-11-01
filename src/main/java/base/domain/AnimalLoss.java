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
    private String city;
    private String name;
    private String breed;
    private String age;
    private String colour;
    private boolean gender;
    private Date date;
    private boolean isFoundOrLost;
    private boolean isReward;
    private String description;
    private long coordLong;
    private long coordLat;
    private Timestamp createDate;

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

    public boolean isReward() {
        return isReward;
    }

    public void setReward(boolean reward) {
        isReward = reward;
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
