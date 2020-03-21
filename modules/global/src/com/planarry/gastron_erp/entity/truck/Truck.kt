package com.planarry.gastron_erp.entity.truck

import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.BaseEntityInternalAccess
import com.haulmont.cuba.core.entity.StandardEntity
import com.planarry.gastron_erp.entity.global.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "GASTRONERP_TRUCK")
@Entity(name = "gastronerp_Truck")
class Truck : BaseEntity() {


    @NotNull(message = "Name is empty")
    @Column(name = "NAME", nullable = false)
    var name: String? = null

    companion object {
        private const val serialVersionUID = 3035886252491751808L
    }
}