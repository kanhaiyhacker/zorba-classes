package com.kanhaiya.dao;

import com.kanhaiya.entity.Role;
import com.kanhaiya.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User myUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(myUser);
    }

    @Override
    public Role checkIfRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "select r from Role r where r.type=:role";
        Query<Role> roleQuery = session.createQuery(query, Role.class);
        roleQuery.setParameter("role", role.getType());
        return roleQuery.uniqueResultOptional().orElse(role);
    }

    @Override
    public boolean checkIsUsernameAlreadyExist(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "Select p from User p where p.username=:uname";
        Query<User> myQuery = session.createQuery(query, User.class);
        myQuery.setParameter("uname", userName);
        User user = myQuery.uniqueResultOptional().orElse(null);
        return user != null;
    }

    @Override
    public User getUser(String userName, String password, String roleType) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "Select p from User p where p.password =:pass and p.username=:uname";
        Query<User> personQuery = session.createQuery(query, User.class);
        personQuery.setParameter("pass", password);
        personQuery.setParameter("uname", userName);
        return personQuery.uniqueResultOptional().orElse(null);
    }

}
