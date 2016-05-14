package main.interfaces;

import com.google.inject.Singleton;
import main.objects.User;

import java.util.List;

@Singleton
public class UserService implements UserInterface {

    private final UserModel userModel;
   
    public UserService(UserModel userModel) {
        this.userModel = userModel;
    }

    public User doRegistration(User user) {
        User u = this.userModel.create(user);
        return u;
    }

    public void remove(int id) {
        this.userModel.remove(id);
    }

    public boolean doLogin(String email, String password) {
        boolean flag = this.userModel.create(user);
        return flag;
    }

}
