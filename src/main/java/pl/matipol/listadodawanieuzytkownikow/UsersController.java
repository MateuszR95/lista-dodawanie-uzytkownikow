package pl.matipol.listadodawanieuzytkownikow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @ResponseBody
    @RequestMapping("/users")
    public String printUsers() {
        StringBuilder result = new StringBuilder();
        //String result = "";
        List<User> users = usersRepository.getUsers();
        for (User user : users) {
            result.append(user.toString()).append("<br>");
        }
        return result.toString();
    }

    @RequestMapping("/add")
    public String add(@RequestParam("imie") String firstName, @RequestParam("nazwisko")
    String lastName, @RequestParam("wiek") Integer age) {
        User user = new User(firstName, lastName, age);
        if (!firstName.isBlank()) {
            usersRepository.addUserToList(user);
            return "redirect:success.html";
        }
        return "redirect:/err.html";
    }

}
