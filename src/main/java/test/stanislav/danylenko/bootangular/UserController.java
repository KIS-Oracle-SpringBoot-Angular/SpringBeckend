package test.stanislav.danylenko.bootangular;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping
    void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/operation")
    SpecificResponse processSpecificRequest(@RequestBody SpecificRequest specificRequest) {
        SpecificResponse response = new SpecificResponse();
        switch (specificRequest.getOperation()) {
            case "procedure":
                userRepository.insertUser(specificRequest.getParameter());
                response.setResult("successfully added");
                break;
            case "function":
                int res = userRepository.countNameLengthMore(Integer.parseInt(specificRequest.getParameter()));
                response.setResult(res + "");
                break;
            case "exception":
                try {
                    userRepository.validateEmail(specificRequest.getParameter());
                    response.setResult("Valid!");
                } catch (Exception e) {
                    response.setError(ExceptionUtils.getRootCause(e).getMessage());
                }
                break;
        }
        return response;
    }

}
