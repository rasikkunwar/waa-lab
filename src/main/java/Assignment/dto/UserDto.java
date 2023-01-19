package Assignment.dto;

import Assignment.domain.Post;
import lombok.Data;

import java.util.List;
@Data
public class UserDto {

    private long id;
    private String name;
    private List<Post> posts;
}
