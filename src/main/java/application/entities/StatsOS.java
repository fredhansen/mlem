
package application.entities;

import eu.bitwalker.useragentutils.OperatingSystem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatsOS {

    @Id
    private Integer id;

    private OperatingSystem os;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

