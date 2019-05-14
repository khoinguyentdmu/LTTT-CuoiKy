package tdmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdmu.model.Phone;
import tdmu.service.RecommendationService;

import java.util.List;

@RestController
@RequestMapping("/rs")
    public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Phone> getAll(@RequestParam(name = "idUser") Long idUser, @RequestParam(name = "numberOfPhone") int numberOfPhone) {
        return recommendationService.recommend(idUser, numberOfPhone);
    }
}
