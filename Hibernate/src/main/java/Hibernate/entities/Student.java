package Hibernate.entities;

import Hibernate.experiments.Faculty;
import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="students")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "faculty")
    private Faculty faculty;
}
