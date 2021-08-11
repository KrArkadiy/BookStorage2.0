package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "writers")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPosts(Post post){
        post.setWriter(this);
        posts.add(post);
    }
}
