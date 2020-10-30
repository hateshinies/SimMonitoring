package base.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name = "SimInfo")
public class SimInfo {

    @Id
    private long id;
    private boolean isFunctioning;
    private boolean CSD;
    private String employee;
    private String phoneNumber;
    private String curLocation;
    private String lastLocation;
    private Timestamp lastChangeDate;
    private String hostName;
    private String ipAddress;
    private String operator;

    public SimInfo(){
    }

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
    public String getEmployee() {
        return employee;
    }
    public void setEmployee(String employeeSurname) {
        this.employee = employeeSurname;
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
    public boolean isCSD() {
        return CSD;
    }
    public void setCSD(boolean CSD) {
        this.CSD = CSD;
    }
}
