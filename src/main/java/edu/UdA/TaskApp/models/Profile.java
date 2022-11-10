package edu.UdA.TaskApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long idProfile;

    @Column(name="Phone")
    private String phone;

    //@Transient
    @OneToOne
    @JoinColumn(name= "user_id")
    private User user;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
