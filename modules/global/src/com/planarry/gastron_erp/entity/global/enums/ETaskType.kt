package com.planarry.gastron_erp.entity.global.enums

import com.haulmont.chile.core.datatypes.impl.EnumClass

enum class ETaskType(private val id: String) : EnumClass<String> {
    DOWNLOADING("DOWNLOADING"),
    UNLOADING("UNLOADING");

    override fun getId() = id

    companion object {

        @JvmStatic
        fun fromId(id: String): ETaskType? = ETaskType.values().find { it.id == id }
    }
}