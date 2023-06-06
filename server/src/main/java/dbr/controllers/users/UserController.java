package dbr.controllers.users;

import dbr.entities.users.UserEntity;
import dbr.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    ResponseEntity register(@RequestBody Map<String, String> req) {
        try {
            if (req.get("login") == null || req.get("password") == null) {
                return ResponseEntity.badRequest().body("Нет обязательеых входных параметров");
            }
            UserEntity user = userService.create(req.get("login"), req.get("password"));
            return ResponseEntity.ok().body(user);
        } catch (Exception err) {
            return ResponseEntity.badRequest().body("Ошибка");
        }

    }

    @PostMapping("/login")
    ResponseEntity auth(@RequestBody Map<String, String> req) {
        try {
            if (req.get("login") == null || req.get("password") == null) {
                return ResponseEntity.badRequest().body("Нет обязательеых входных параметров");
            }
            UserEntity user = userService.auth(req.get("login"), req.get("password"));
            return ResponseEntity.ok().body(user);
        }
        catch (Exception err) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
