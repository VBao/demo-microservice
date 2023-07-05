package vn.itlearn.account.services;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.itlearn.account.entities.User;
import vn.itlearn.account.entities.value_objects.Course;
import vn.itlearn.account.entities.value_objects.ResponseTemplateVO;
import vn.itlearn.account.repos.UserRepository;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User save(User user){
        return this.userRepository.save(user);
    }

    public User getById(ObjectId id){
        return this.userRepository.findById(id).orElse(null);
    }

    public ResponseTemplateVO getUserWithCourse(ObjectId id){
        User user=this.getById(id);
        Course course =restTemplate.getForObject("http://course/"+user.getCourseId(), Course.class);
        return new ResponseTemplateVO(user,course);
    }
}
