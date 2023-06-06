package dbr.controllers.tests;

import dbr.services.tests.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping
    public ResponseEntity getTest(@Param("id") int id) {
        return ResponseEntity.ok().body(testService.getTest(id));
    }

    @GetMapping("/:id")
    public ResponseEntity getById() {
        return null;

    }

    @PostMapping
    public ResponseEntity add() {
        return null;
    }

    @PutMapping("/:id")
    public ResponseEntity update() {
        return null;
    }

    @DeleteMapping("/:id")
    public ResponseEntity delete() {
        return null;
    }

}
