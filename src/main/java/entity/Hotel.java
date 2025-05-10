package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="hotel", schema = "public")
public class Hotel {

  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "name", nullable = false)
  private String name;

}
