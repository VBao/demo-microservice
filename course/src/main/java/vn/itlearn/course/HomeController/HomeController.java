package vn.itlearn.course.HomeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vn.itlearn.course.entities.Gallery;

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
    public Gallery getGallery(@PathVariable final int id){
        Gallery gallery=new Gallery();
        gallery.setId(id);
        List images=restTemplate.getForObject("http://AccountService/images/", List.class);
        gallery.setImages(images);
        return gallery;
    }

    @RequestMapping("/admin")
    public String homeAdmin(){
        return "This is admin area";
    }
}
