package vr.apps.petcare.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import vr.apps.petcare.model.Pet;
import vr.apps.petcare.model.PetCareCenter;
import vr.apps.petcare.model.PetOwner;
import vr.apps.petcare.model.Document;
import vr.apps.petcare.model.PetService;
import vr.apps.petcare.model.BusinessHours;
import vr.apps.petcare.model.complex.Address;
import vr.apps.petcare.enums.PetServiceType;
import vr.apps.petcare.converter.PetServiceTypeConverter;
import vr.apps.petcare.converter.DurationConverter;
import vr.apps.petcare.converter.UUIDToByteConverter;
import vr.apps.petcare.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "BusinessHours")
@Table(name = "\"BusinessHours\"", schema =  "\"petcare\"")
@Data
                        
public class BusinessHours {
	public BusinessHours () {   
  }
	  
	
@Column(name = "\"WorkingHours\"")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"petcare\"", name = "\"BusinessHoursWorkingHours\"",joinColumns = @JoinColumn(name = "\"BhId\""))
    private List<String> workingHours = new ArrayList<>();
	  
	
@Column(name = "\"Holidays\"")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"petcare\"", name = "\"BusinessHoursHolidays\"",joinColumns = @JoinColumn(name = "\"BhId\""))
    private List<String> holidays = new ArrayList<>();
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"BhId\"", nullable = true )
  private Integer bhId;
	  
  @Column(name = "\"Location\"", nullable = true )
  private String location;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "BusinessHours [" 
  + "WorkingHours= " + workingHours  + ", " 
  + "Holidays= " + holidays  + ", " 
  + "BhId= " + bhId  + ", " 
  + "Location= " + location 
 + "]";
	}
	
}