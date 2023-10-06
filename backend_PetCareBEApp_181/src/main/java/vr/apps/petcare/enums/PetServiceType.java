package vr.apps.petcare.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum PetServiceType{
	    PetGrooming,
	    PetBoarding,
	    PetTraining,
	    PetSitting,
	    PetTherapy; 
    public int value(PetServiceType petServiceType) {
        return petServiceType.ordinal();
    }
    public static PetServiceType getPetServiceType(int ordinal) {
        for(PetServiceType petServiceType : PetServiceType.values())
                if(petServiceType.ordinal() == ordinal)
                        return petServiceType;
        return null;
    }
}


