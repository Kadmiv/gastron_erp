package com.planarry.gastron_erp.web.screens.trailer

import com.haulmont.cuba.gui.screen.*
import com.planarry.gastron_erp.entity.trailer.Trailer

@UiController("gastronerp_Trailer.browse")
@UiDescriptor("trailer-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
class TrailerBrowse : MasterDetailScreen<Trailer>()