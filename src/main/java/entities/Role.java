package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Stepan.Kachan
 */

@Getter
@Setter
@Entity(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @OneToMany(orphanRemoval = true, mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RolePermission> rolePermissions;

    public void addPermission(List<Permission> permission){
        if(rolePermissions == null || rolePermissions.isEmpty()){
            rolePermissions = new LinkedHashSet<>();
        }
        permission.forEach(permission1 -> rolePermissions.add(new RolePermission(this,permission1)));
    }

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Permission> rolePermissions;

    //RolePermission class is unneeded if you use ManyToMany linking.
    //Othewise create two OneToMany connections



//
//    public List<Permission> getRolePermissions() {
//        return rolePermissions;
//    }
//
//    public void setRolePermissions(List<Permission> rolePermissions) {
//        this.rolePermissions = rolePermissions;
//    }


}
