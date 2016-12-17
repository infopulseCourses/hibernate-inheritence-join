package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mtarasenko on 17.12.16.
 */

@Entity
@Table(name="chat_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String login;

    private String password;

    @Temporal(value = TemporalType.TIMESTAMP)//maps java.util.DateTime to sql native type
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    private Role role;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public User() {
        createDate = new Date();
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
