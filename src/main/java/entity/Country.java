package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="country", schema = "public")
public class Country {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "name", length = 100, nullable = false)
  private String name;
  @Column(name = "abbreviation", length = 10, nullable = false)
  private String abbreviation;
  @OneToMany(targetEntity = Person.class, mappedBy = "country")
  private Set<Person> people;

}
