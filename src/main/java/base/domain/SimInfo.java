package base.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


@Entity
@Table(name = "SimInfo")
public class SimInfo {

    @Id
    public long id;
    private boolean functioning;
    private boolean CSD;
    private String ownerSurname;
    private String employeeSurname;

    @Size(min=10,max=12)
    private String phoneNumber;

    //@NotNull
    private String curLocation;
    private String lastLocation;
    private String ipAddress;
    private String operator;
    private Timestamp lastChangeDate;

    public SimInfo() {

    }

    //getter and setter stuff

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public boolean getFunctioning() {
        return functioning;
    }
    public void setFunctioning(boolean functioning) {
        this.functioning = functioning;
    }
    public boolean getCSD() {
        return CSD;
    }
    public void setCSD(boolean CSD) {
        this.CSD = CSD;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getOwnerSurname() {
        return ownerSurname;
    }
    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }
    public String getEmployeeSurname() {
        return employeeSurname;
    }
    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getCurLocation() {
        return curLocation;
    }
    public void setCurLocation(String curLocation) {
        this.curLocation = curLocation;
    }
    public String getLastLocation() {
        return lastLocation;
    }
    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }
    public Timestamp getLastChangeDate() {
        return lastChangeDate;
    }
    public void setLastChangeDate(Timestamp lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
