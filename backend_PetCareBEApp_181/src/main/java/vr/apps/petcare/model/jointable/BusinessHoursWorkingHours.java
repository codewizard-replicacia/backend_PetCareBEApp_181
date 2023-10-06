package vr.apps.petcare.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import vr.apps.petcare.model.Pet;
import vr.apps.petcare.model.PetCareCenter;
import vr.apps.petcare.model.PetOwner;
import vr.apps.petcare.model.Document;
import vr.apps.petcare.model.PetService;
import vr.apps.petcare.model.BusinessHours;
import vr.apps.petcare.model.complex.Address;
import vr.apps.petcare.enums.PetServiceType;
import vr.apps.petcare.converter.PetServiceTypeConverter;

@Entity(name = "BusinessHoursWorkingHours")
@Table(schema = "\"petcare\"", name = "\"BusinessHoursWorkingHours\"")
@Data
public class BusinessHoursWorkingHours{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"BhId\"")
	private Integer bhId;

    
    @Column(name = "\"WorkingHours\"")
    private Integer workingHours;
}