package fi.academy.climateswipe.Controllers;


import fi.academy.climateswipe.Entities.Users;
import fi.academy.climateswipe.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private  UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/")
    public Iterable<Users> contact() {
        return usersRepository.findAll();
    }

    @GetMapping("/oneuser/{id}")
    public Optional<Users> show(@PathVariable Integer id) {
        return usersRepository.findById(id);
    }


}