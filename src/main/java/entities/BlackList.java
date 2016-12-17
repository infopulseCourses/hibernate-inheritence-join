package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mtarasenko on 17.12.16.
 */
@Entity(name="black_list")
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @Temporal(value = TemporalType.TIMESTAMP)//maps java.util.DateTime to sql native type
    private Date timeAdded;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="banned_user_id")
    private User bannedUser;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="admin_id")
    private User admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }

    public User getBannedUser() {
        return bannedUser;
    }

    public void setBannedUser(User bannedUser) {
        this.bannedUser = bannedUser;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
