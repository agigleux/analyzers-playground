package RIPS_Calendar_2019;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "UserEntity", uniqueConstraints = { @UniqueConstraint(columnNames = "ID"),
    @UniqueConstraint(columnNames = "EMAIL") })
public class Day16_Candle_UserEntity implements Serializable {

  public Day16_Candle_UserEntity(String email, String firstName, String lastName) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  private static final long serialVersionUID = -1798070786993154676L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  private Integer userId;

  @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
  private String email;

  @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
  private String firstName;

  @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
  private String lastName;
}