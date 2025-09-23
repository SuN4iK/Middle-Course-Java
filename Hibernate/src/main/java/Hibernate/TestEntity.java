package Hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "test_table")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_name")
    private String name;

    // Конструкторы
    public TestEntity() {}

    public TestEntity(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "TestEntity{id=" + id + ", name='" + name + "'}";
    }
}