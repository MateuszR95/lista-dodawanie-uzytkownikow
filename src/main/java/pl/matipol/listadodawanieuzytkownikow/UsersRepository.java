package pl.matipol.listadodawanieuzytkownikow;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {

    private List<User> users;

    public UsersRepository() {
        users = new ArrayList<>();
        users.add(new User("Adam", "Nowak", 22));
        users.add(new User("Tomasz", "Kowalski", 33));
        users.add(new User("Igor", "Bolek", 44));
    }
    public void addUserToList(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
