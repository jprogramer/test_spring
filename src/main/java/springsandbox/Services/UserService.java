package springsandbox.Services;

import springsandbox.Entity.MutableUser;
import springsandbox.Entity.User;

import java.util.Collection;

public interface UserService<U extends User> {
    U create(String name);

    U rename(String name, String newName);

    Collection<U> findAll();

    void delete(String name);
    

    int count();

    U first();

    U last();

    U find(String name);
}
