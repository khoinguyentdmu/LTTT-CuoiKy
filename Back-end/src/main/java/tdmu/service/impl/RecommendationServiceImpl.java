package tdmu.service.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdmu.model.Phone;
import tdmu.repository.PhoneRepository;
import tdmu.repository.UserRepository;
import tdmu.service.RecommendationService;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PhoneRepository phoneRepo;

    public List<Phone> recommend(Long idUser, int numberOfPhones){
        List<Phone> res = null;

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("binhduong");
        dataSource.setDatabaseName("phonedb");
        JDBCDataModel model = new MySQLJDBCDataModel(dataSource,
                "phone_rating", "user_id", "phone_id", "rating", null);

        try {
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);

            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            List<RecommendedItem> recommendations = recommender.recommend(idUser, numberOfPhones);

            for (RecommendedItem recommendation : recommendations) {
                System.out.println(recommendation);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return res;
    }

}
