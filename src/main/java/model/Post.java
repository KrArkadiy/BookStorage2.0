package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private Long created;

    @Column(name = "updated")
    private Long updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private Writer writer;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Label> labels;

    public Post(String content, Long created, Long updated) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        labels = new ArrayList<>();
    }

    public void addLabel(Label label){
        label.setPost(this);
        labels.add(label);
    }
}