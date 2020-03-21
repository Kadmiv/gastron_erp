package com.planarry.gastron_erp.web.screens.driver

import com.haulmont.cuba.gui.screen.*
import com.planarry.gastron_erp.entity.driver.Driver

@UiController("gastronerp_Driver.browse")
@UiDescriptor("driver-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
class DriverBrowse : MasterDetailScreen<Driver>()