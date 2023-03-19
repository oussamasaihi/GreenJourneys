package com.greenjourneys.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MilieuCoucher {
    @Id
    long idM ;
    int NombreLits ;
    long Prix;
    int NbChambres ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MilieuCoucher that = (MilieuCoucher) o;
        return Objects.equals(getIdM(), that.getIdM());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
