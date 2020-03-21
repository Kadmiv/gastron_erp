package com.planarry.gastron_erp.entity.driver

import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.annotation.OnDelete
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse
import com.haulmont.cuba.core.global.DeletePolicy
import com.planarry.gastron_erp.entity.global.BaseEntity
import com.planarry.gastron_erp.entity.sensor.Sensor
import javax.persistence.*
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "GASTRONERP_DRIVER")
@Entity(name = "gastronerp_Driver")
class Driver  : BaseEntity() {



    @NotNull(message = "Name is empty")
    @Column(name = "NAME")
    var name: String? = null

    @Column(name = "SECOND_NAME")
    var second_name: String? = null

    @NotNull(message = "Sensor is empty")
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SENSOR_ID")
    var sensor: Sensor? = null


    companion object {
        private const val serialVersionUID = -7583755084438744280L
    }
}