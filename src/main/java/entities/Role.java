package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtarasenko on 17.12.16.
 */

@Entity(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @OneToMany(orphanRemoval = true, mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Permission> rolePermissions;

    //RolePermission class is unneeded if you use ManyToMany linking.
    //Othewise create two OneToMany connections

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RolePermission> rolePermissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
//
//    public List<Permission> getRolePermissions() {
//        return rolePermissions;
//    }
//
//    public void setRolePermissions(List<Permission> rolePermissions) {
//        this.rolePermissions = rolePermissions;
//    }
    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public void addPermission(List<Permission> permission){
        if(rolePermissions == null || rolePermissions.isEmpty()){
             rolePermissions = new ArrayList<>(permission.size());
        }

        for(Permission perm: permission){
            RolePermission rolePermission1 = new RolePermission();
            rolePermission1.setRole(this);
            rolePermission1.setPermission(perm);

            rolePermissions.add(rolePermission1);
        }

    }
}
