package pers.jssd.mongodbcostomconverter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pers.jssd.mongodbcostomconverter.entity.pojo.User;

/**
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:30
 */
public interface UserRepository extends MongoRepository<User, String> {
}
