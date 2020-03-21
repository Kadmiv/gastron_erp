package com.planarry.gastron_erp.entity.sensor

import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.annotation.Lookup
import com.haulmont.cuba.core.entity.annotation.LookupType
import com.haulmont.cuba.core.entity.annotation.OnDelete
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse
import com.haulmont.cuba.core.global.DeletePolicy
import com.planarry.gastron_erp.entity.driver.Driver
import com.planarry.gastron_erp.entity.global.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "GASTRONERP_SENSOR")
@Entity(name = "gastronerp_Sensor")
class Sensor : BaseEntity() {

    @NotNull(message = "Name is empty")
    @Column(name = "NAME", nullable = false)
    var name: String? = null

    @NotNull(message = "IMEI is empty")
    @Column(name = "IMEI", nullable = false, length = 17)
    var imei: String? = null

    @Lookup(type = LookupType.SCREEN, actions = ["lookup", "open"])
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sensor")
    var driver: Driver? = null

    companion object {
        private const val serialVersionUID = 3507679487317999181L
    }
}