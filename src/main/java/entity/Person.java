package entity;

import entity.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="person", schema = "public")
public class Person {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;
  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;
  @ManyToOne(targetEntity = Country.class)
  @JoinColumn(name = "id_country", referencedColumnName = "id")
  private Country country;
  @Column(name = "gender")
  private GenderEnum gender;
  @Column(name = "birthday")
  private LocalDate birthday;
  @Column(name = "phone")
  private String phoneNumber;
  @Column(name = "email")
  private String email;
  @Column(name = "user_id")
  private String userId;
  @Column(name = "external_id")
  private String externalId;
  @OneToMany(targetEntity = PersonEvent.class, mappedBy = "person")
  private List<PersonEvent> personEvents;


}
