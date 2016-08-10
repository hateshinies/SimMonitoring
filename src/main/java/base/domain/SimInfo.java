package base.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
@javax.persistence.Table(name = "SimInfo")
public class SimInfo {

    public SimInfo(){

    }

    @Id
    private long id;

    private boolean isFunctioning;

    /**
     * человек, на которого записана симка
     */
    private String ownerSurname;
    /**
     * пользователь симки
     */
    private String employeeSurname;

    private String phoneNumber;
    /**
     * текущее расположение(ШУ)
     */
    private String curLocation;
    /**
     * прошлое расположение(ШУ)
     */
    private String lastLocation;
    /**
     * время последнего изменения
     */
    private Timestamp lastChangeDate;

    private String hostName;

    private String ipAddress;

    private String operator;

    //getter and setter stuff

    public boolean isFunctioning() {
        return isFunctioning;
    }

    public void setFunctioning(boolean functioning) {
        isFunctioning = functioning;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
