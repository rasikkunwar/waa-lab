package Lab.lab.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostV2 {
    private long id;
    private String title;
    private String content;
    private String author;
}
