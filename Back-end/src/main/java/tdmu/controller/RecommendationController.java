package tdmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Phone> getAll() {
        return recommendationService.recommend(2L, 3);
    }
}
