package com.sharibekoff.smartcity.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "colleges")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String address;

    @Positive
    private Integer numberOfStudents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        College college = (College) o;
        return id != null && Objects.equals(id, college.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
