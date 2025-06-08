package entity;

import entity.enums.PersonTypeEnum;
import entity.enums.RegistrationTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="person_event", schema = "public")
public class PersonEvent {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne(targetEntity = Person.class)
  @JoinColumn(name = "id_person", referencedColumnName = "id")
  private Person person;
  @ManyToOne(targetEntity = Event.class)
  @JoinColumn(name = "id_event", referencedColumnName = "id")
  private Event event;
  @Column(name = "type")
  private PersonTypeEnum type;
  @Column(name = "registration_type")
  private RegistrationTypeEnum registrationType;
  @Column(name = "comment")
  private String comment;
  @Column(name = "arrival_date")
  private LocalDate arrivalDate;
  @Column(name = "arrival_time")
  private LocalTime arrivalTime;
  @Column(name = "departure_date")
  private LocalDate departureDate;
  @Column(name = "departure_time")
  private LocalTime departureTime;

}
