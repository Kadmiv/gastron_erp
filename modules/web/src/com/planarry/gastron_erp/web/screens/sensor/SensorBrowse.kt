package com.planarry.gastron_erp.web.screens.sensor

import com.haulmont.cuba.gui.screen.*
import com.planarry.gastron_erp.entity.sensor.Sensor

@UiController("gastronerp_Sensor.browse")
@UiDescriptor("sensor-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
class SensorBrowse : MasterDetailScreen<Sensor>()