package pers.jssd.mongodbcostomconverter.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.jssd.mongodbcostomconverter.entity.pojo.User;
import pers.jssd.mongodbcostomconverter.repository.UserRepository;
import pers.jssd.mongodbcostomconverter.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:37
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public String saveUser(User user) {
        user.setCreateTs(LocalDateTime.now());
        User save = userRepository.save(user);
        return save.getId();
    }

    @Override
    public User getOne(String id) {
        log.debug("id = {}", id);
        Optional<User> byId = userRepository.findById(id);

        return byId.orElse(null);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
