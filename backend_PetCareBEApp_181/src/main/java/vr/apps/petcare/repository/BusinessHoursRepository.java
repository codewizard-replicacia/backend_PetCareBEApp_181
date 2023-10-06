package vr.apps.petcare.repository;


import vr.apps.petcare.model.BusinessHours;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class BusinessHoursRepository extends SimpleJpaRepository<BusinessHours, String> {
    private final EntityManager em;
    public BusinessHoursRepository(EntityManager em) {
        super(BusinessHours.class, em);
        this.em = em;
    }
    @Override
    public List<BusinessHours> findAll() {
        return em.createNativeQuery("Select * from \"petcare\".\"BusinessHours\"", BusinessHours.class).getResultList();
    }
}