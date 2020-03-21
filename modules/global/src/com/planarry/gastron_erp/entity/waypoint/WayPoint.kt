package com.planarry.gastron_erp.entity.waypoint

import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import com.planarry.gastron_erp.entity.global.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "GASTRONERP_WAY_POINT")
@Entity(name = "gastronerp_WayPoint")
class WayPoint : BaseEntity() {

    @NotNull(message = "Name is empty")
    @Column(name = "NAME", nullable = false)
    var name: String? = null

    @NotNull(message = "Address is empty")
    @Column(name = "ADDRESS")
    var address: String? = null

    companion object {
        private const val serialVersionUID = -2211974196535154644L
    }
}