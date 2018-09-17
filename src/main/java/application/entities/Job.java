package application.entities;

import javax.persistence.*;

@Entity
@Table(name = "jobs_user")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jobId;

    //@Column(name = "userId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "fk_user_to_job", referencedColumnName = "userId")
    private User user;

    @Column(nullable = false)
    private String jobdescription;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }
}
