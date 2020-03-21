package com.planarry.gastron_erp.entity.global

import com.haulmont.cuba.core.entity.StandardEntity
import com.haulmont.cuba.core.entity.annotation.Lookup
import com.haulmont.cuba.core.entity.annotation.LookupType
import com.haulmont.cuba.core.entity.annotation.OnDelete
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.DeletePolicy
import com.haulmont.cuba.core.global.UserSessionSource
import com.haulmont.cuba.security.entity.Group
import java.util.*
import javax.annotation.PostConstruct
import javax.persistence.*
import javax.validation.constraints.NotNull


@MappedSuperclass
open class BaseEntity : StandardEntity() {


    @Lookup(type = LookupType.SCREEN, actions = ["lookup", "open"])
    @NotNull
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GROUPE_ID")
    var group: Group? = null


    @NotNull(message = "Id is empty")
    @Column(name = "EXTERNAL_ID")
    var externalID: String? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_DATE_OF_CHANGE")
    var lastDateOfChange: Date? = null

    @PostConstruct
    protected fun init() {
        val user = AppBeans.get(UserSessionSource::class.java).userSession.user
        val clientGroup = user.group
                ?: throw IllegalStateException("'clientGroup' user session attribute is absent. Log in as a client's user.")
        //        List<UserRole> roles  = user.getUserRoles();
        group = clientGroup
    }

    companion object {
        private val serialVersionUID = 2427519948469073047L
    }
}