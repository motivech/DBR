package dbr.controllers.subjects;

import dbr.services.subjects.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/school-subjects")
@CrossOrigin(origins = "*")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    ResponseEntity getAllSubjects() {
        try {
            return ResponseEntity.ok().body(subjectService.getAll());
        }
        catch (Exception err) {
            return ResponseEntity.badRequest().body(err);
        }
    }

}
