package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "writers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "writer_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> posts;

    public Writer(String name) {
        this.name = name;
        posts = new ArrayList<>();
    }

    public void addPosts(Post post){
        post.setWriter(this);
        posts.add(post);
    }
}
