package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Stepan.Kachan
 */
@Getter
@Setter
@Entity(name="permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "permission",cascade = CascadeType.ALL, orphanRemoval = true)
     private List<RolePermission> roles;

}
