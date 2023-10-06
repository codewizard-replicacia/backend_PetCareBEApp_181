package vr.apps.petcare.model.complex;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class Address {
  
	
  @Column(name = "\"AId\"", nullable = true)
  private Integer aId;
	
  @Column(name = "\"HouseNumber\"", nullable = true)
  private String houseNumber;
	
  @Column(name = "\"SocietyName\"", nullable = true)
  private String societyName;
	
  @Column(name = "\"Area\"", nullable = true)
  private String area;
	
  @Column(name = "\"Pincode\"", nullable = true)
  private String pincode;
	
  @Column(name = "\"City\"", nullable = true)
  private String city;
	
  @Column(name = "\"State\"", nullable = true)
  private String state;
	
  @Column(name = "\"Country\"", nullable = true)
  private String country;
}
