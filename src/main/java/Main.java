import entities.Permission;
import entities.Role;
import entities.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtarasenko on 17.12.16.
 */
public class Main {
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        User user1 = new User();
        user1.setName("God");
        user1.setLogin("Odin");
        user1.setPassword("Walhalla");

        Role userRole = new Role();
        userRole.setRoleName("user");

        Role adminRole = new Role();
        adminRole.setRoleName("admin");

        Permission read = new Permission();
        read.setName("read");

        Permission write = new Permission();
        write.setName("write");

        Permission ban = new Permission();
        ban.setName("ban");

        Permission delete = new Permission();
        delete.setName("delete");

        List<Permission> userPermissions = new ArrayList();
        userPermissions.add(read);
        userPermissions.add(write);

        List<Permission> adminPermissions = new ArrayList<>();
        adminPermissions.add(read);
        adminPermissions.add(write);
        adminPermissions.add(ban);
        adminPermissions.add(delete);

        userRole.addPermission(userPermissions);
        adminRole.addPermission(adminPermissions);

        user1.setRole(userRole);

        entityManager.persist(read);
        entityManager.persist(write);
        entityManager.persist(ban);
        entityManager.persist(delete);

        entityManager.persist(userRole);
        entityManager.persist(adminRole);

        entityManager.persist(user1);

        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();
    }
}
