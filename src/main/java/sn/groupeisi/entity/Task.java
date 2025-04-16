package sn.groupeisi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
@NamedQuery(name = "toto", query ="SELECT t FROM Task t WHERE t.isCompleted =: completed")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(length =100)
    private String description;

    @Column(name = "due_date")
    private LocalDate date;

    @Column(name = "completed", columnDefinition = "boolean not null default false")
    private boolean isCompleted;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;
}
