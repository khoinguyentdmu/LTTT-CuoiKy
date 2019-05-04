package tdmu.service;

import tdmu.model.Phone;

import java.util.List;

public interface RecommendationService {
    List<Phone> recommend(Long idUser, int numberOfPhones);
}
