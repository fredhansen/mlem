package application.entities;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;

import javax.persistence.*;

@Entity
@Table(name = "stats")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statId;

    private OperatingSystem operatingSystem;

    private Browser browser;

    private DeviceType deviceType;

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}