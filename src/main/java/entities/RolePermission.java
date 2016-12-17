package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mtarasenko on 17.12.16.
 */

@Entity(name="role_permission")
public class RolePermission implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Id
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private  Permission permission;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
