package vn.itlearn.course.HomeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vn.itlearn.course.entities.Course;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home(){
        return "Hello to the course list";
    }

    @RequestMapping("/{id}")
    public Course getGallery(@PathVariable final int id){
        Course course =new Course();
        course.setId(id);
        List images=restTemplate.getForObject("http://AccountService/images/", List.class);
        course.setImages(images);
        return course;
    }

    @RequestMapping("/admin")
    public String homeAdmin(){
        return "This is admin area";
    }
}
