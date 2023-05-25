package example.api;

import example.dto.NewDTO;
import example.services.impl.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//controller thi se can responseBody
//@Controller
@RestController
public class NewAPI {
    @Autowired
    private NewService newService;

//    @RequestMapping(value = "/new", method = RequestMethod.POST)

    //    @ResponseBody
//
//    public NewDTO createNew(@RequestBody NewDTO model) {
//
//        return model;
//
//    }
    @PostMapping(value = "/new")
    public NewDTO addNew(@RequestBody NewDTO model) {
        return newService.save(model);
    }

    @PutMapping(value = "/test")
    public NewDTO updateNew(@RequestBody NewDTO model) {
        return model;
    }

    @DeleteMapping
    public NewDTO deleteNew(@RequestBody NewDTO model) {
        return model;
    }


}
