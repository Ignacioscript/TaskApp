package edu.UdA.TaskApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long idUser;

    @Column(name="name")
    private String name;

    @Column(name="Email")
    private String email;

    //@Transient
   @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;




    @OneToMany
    //@Transient
    @JoinColumn(name= "user_id")
    private List<Task> tasks = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

}