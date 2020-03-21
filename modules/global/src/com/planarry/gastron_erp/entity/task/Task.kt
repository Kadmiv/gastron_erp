package com.planarry.gastron_erp.entity.task

import com.haulmont.cuba.core.entity.annotation.Lookup
import com.haulmont.cuba.core.entity.annotation.LookupType
import com.haulmont.cuba.core.entity.annotation.OnDelete
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse
import com.haulmont.cuba.core.global.DeletePolicy
import com.planarry.gastron_erp.entity.driver.Driver
import com.planarry.gastron_erp.entity.global.BaseEntity
import com.planarry.gastron_erp.entity.global.enums.ETaskType
import com.planarry.gastron_erp.entity.trailer.Trailer
import com.planarry.gastron_erp.entity.truck.Truck
import com.planarry.gastron_erp.entity.waypoint.WayPoint
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Table(name = "GASTRONERP_TASK")
@Entity(name = "gastronerp_Task")
class Task : BaseEntity() {
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "DATE_AND_T_IME", nullable = false)
    var dateAndTIme: Date? = null


    @NotNull
    @Column(name = "TASK_TYPE", nullable = false)
    private var taskType: String? = null

    @NotNull
    @Lookup(type = LookupType.SCREEN, actions = ["lookup", "open"])
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POINT_ID")
    var point: WayPoint? = null

    @NotNull
    @Lookup(type = LookupType.SCREEN, actions = ["lookup", "open"])
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TRUCK_ID")
    var truck: Truck? = null

    @Lookup(type = LookupType.SCREEN, actions = ["lookup", "open"])
    @NotNull
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TRAILER_ID")
    var trailer: Trailer? = null

    @Lookup(type = LookupType.SCREEN, actions = ["lookup", "open"])
    @NotNull
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DRIVER_ID")
    var driver: Driver? = null

    fun getTaskType(): ETaskType? = taskType?.let { ETaskType.fromId(it) }

    fun setTaskType(taskType: ETaskType?) {
        this.taskType = taskType?.id
    }

    companion object {
        private const val serialVersionUID = -7541049270650584711L
    }
}