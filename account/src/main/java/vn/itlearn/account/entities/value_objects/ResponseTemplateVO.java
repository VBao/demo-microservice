package vn.itlearn.account.entities.value_objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.itlearn.account.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplateVO {

    private User user;
    private Course course;
}
