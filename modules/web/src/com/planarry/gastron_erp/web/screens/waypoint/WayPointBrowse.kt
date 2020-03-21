package com.planarry.gastron_erp.web.screens.waypoint

import com.haulmont.cuba.gui.screen.*
import com.planarry.gastron_erp.entity.waypoint.WayPoint

@UiController("gastronerp_WayPoint.browse")
@UiDescriptor("way-point-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
class WayPointBrowse : MasterDetailScreen<WayPoint>()