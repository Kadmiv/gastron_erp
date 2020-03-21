package com.planarry.gastron_erp.entity.trailer

import com.haulmont.chile.core.annotations.NamePattern
import com.planarry.gastron_erp.entity.global.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "GASTRONERP_TRAILER")
@Entity(name = "gastronerp_Trailer")
class Trailer : BaseEntity() {

    @NotNull(message = "Name is empty")
    @Column(name = "NAME", nullable = false)
    var name: String? = null

    companion object {
        private const val serialVersionUID = 36132019268102262L
    }
}