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

@Entity(name = "PetOwner")
@Table(name = "\"PetOwner\"", schema =  "\"petcare\"")
@Data
                        
public class PetOwner {
	public PetOwner () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"OwnerId\"", nullable = true )
  private Integer ownerId;
	  
  @Column(name = "\"OwnerName\"", nullable = true )
  private String ownerName;
  
	  
  @Column(name = "\"ContactPrimary\"", nullable = true )
  private String contactPrimary;
  
	  
  @Column(name = "\"ContactSecondary\"", nullable = true )
  private String contactSecondary;
  
	  
  @Embedded
  @Column(name = "\"Address\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "aId", column = @Column(name = "\"Address_AId\"")) ,
            	@AttributeOverride(name = "houseNumber", column = @Column(name = "\"Address_HouseNumber\"")) ,
            	@AttributeOverride(name = "societyName", column = @Column(name = "\"Address_SocietyName\"")) ,
            	@AttributeOverride(name = "area", column = @Column(name = "\"Address_Area\"")) ,
            	@AttributeOverride(name = "pincode", column = @Column(name = "\"Address_Pincode\"")) ,
            	@AttributeOverride(name = "city", column = @Column(name = "\"Address_City\"")) ,
            	@AttributeOverride(name = "state", column = @Column(name = "\"Address_State\"")) ,
            	@AttributeOverride(name = "country", column = @Column(name = "\"Address_Country\""))  }) 
  private Address address;
  
	  
  @Column(name = "\"Pincode\"", nullable = true )
  private String pincode;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"PetOwnerPets\"",
            joinColumns = @JoinColumn( name="\"OwnerId\""),
            inverseJoinColumns = @JoinColumn( name="\"PetId\""), schema = "\"petcare\"")
private List<Pet> pets = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "PetOwner [" 
  + "OwnerId= " + ownerId  + ", " 
  + "OwnerName= " + ownerName  + ", " 
  + "ContactPrimary= " + contactPrimary  + ", " 
  + "ContactSecondary= " + contactSecondary  + ", " 
  + "Address= " + address  + ", " 
  + "Pincode= " + pincode 
 + "]";
	}
	
}