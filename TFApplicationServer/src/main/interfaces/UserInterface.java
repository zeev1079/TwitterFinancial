package main.interfaces;

import main.objects.User;

public interface UserService {

    User doRegistration(User user);

    void remove(int id);

    boolean doLogin(String username, String password);

}
