package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Stepan
 */
@Getter
@Setter
@Entity(name = "admins")
public class Admin extends User{

    @Column(name = "surname")
    private String surname;

}
