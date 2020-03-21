package com.planarry.gastron_erp.web.screens.truck

import com.haulmont.cuba.gui.screen.*
import com.planarry.gastron_erp.entity.truck.Truck

@UiController("gastronerp_Truck.browse")
@UiDescriptor("truck-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
class TruckBrowse : MasterDetailScreen<Truck>()