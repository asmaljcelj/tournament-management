package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="hotel_event", schema = "public")
public class HotelEvent {

  @Id
  @Column(name = "id")
  private long id;
  @ManyToOne(targetEntity = Hotel.class)
  @JoinColumn(name = "id_hotel", referencedColumnName = "id")
  private long idHotel;
  @ManyToOne(targetEntity = Event.class)
  @JoinColumn(name = "id_event", referencedColumnName = "id")
  private long idEvent;

}
