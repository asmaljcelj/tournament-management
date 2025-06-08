package entity;

import entity.enums.EventTypeEnum;
import entity.enums.SportEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="event", schema = "public")
public class Event {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "event_type", nullable = false)
  private EventTypeEnum eventType;
  @Column(name = "sport", nullable = false)
  private SportEnum sport;
  @Column(name = "event_id")
  private String eventId;
  @Column(name = "year", nullable = false)
  private Integer year;
  @Column(name = "date_from")
  private LocalDate dateFrom;
  @Column(name = "date_to")
  private LocalDate dateTo;
  @Column(name = "event_from", nullable = false)
  private LocalDate eventFrom;
  @Column(name = "event_to", nullable = false)
  private LocalDate eventTo;
  @OneToMany(targetEntity = PersonEvent.class, mappedBy = "event")
  private List<PersonEvent> personEvents;

}
