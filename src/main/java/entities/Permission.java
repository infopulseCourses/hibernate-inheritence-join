package entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mtarasenko on 17.12.16.
 */
@Entity(name="permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "permission",cascade = CascadeType.ALL, orphanRemoval = true)
     private List<RolePermission> roles;

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

    public List<RolePermission> getRoles() {
        return roles;
    }

    public void setRoles(List<RolePermission> roles) {
        this.roles = roles;
    }
}
