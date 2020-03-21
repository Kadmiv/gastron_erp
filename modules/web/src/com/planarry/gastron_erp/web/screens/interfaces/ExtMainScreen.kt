package com.planarry.gastron_erp.web.screens.interfaces

import com.haulmont.cuba.gui.components.SizeUnit
import com.haulmont.cuba.gui.components.SplitPanel
import com.haulmont.cuba.gui.components.Window
import com.haulmont.cuba.gui.components.mainwindow.FoldersPane
import com.haulmont.cuba.gui.screen.UiController
import com.haulmont.cuba.gui.screen.UiDescriptor
import com.haulmont.cuba.web.WebConfig
import com.haulmont.cuba.web.app.main.MainScreen
import com.haulmont.cuba.web.gui.components.WebComponentsHelper
import com.haulmont.cuba.web.widgets.CubaHorizontalSplitPanel
import com.vaadin.server.Sizeable

import javax.inject.Inject


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
class ExtMainScreen : MainScreen(), Window.HasFoldersPane {
    @Inject
    private lateinit var foldersSplit: SplitPanel
    @Inject
    private lateinit var foldersPane: FoldersPane
    @Inject
    private lateinit var webConfig: WebConfig

    init {
        addInitListener(this::initLayout)
    }

    private fun initLayout(@SuppressWarnings("unused") event: InitEvent) {
        if (webConfig.foldersPaneEnabled) {
            if (webConfig.foldersPaneVisibleByDefault) {
                foldersSplit.setSplitPosition(webConfig.foldersPaneDefaultWidth, SizeUnit.PIXELS)
            } else {
                foldersSplit.setSplitPosition(0)
            }
            val vSplitPanel = WebComponentsHelper.unwrap(foldersSplit) as CubaHorizontalSplitPanel
            vSplitPanel.defaultPosition = "${webConfig.foldersPaneDefaultWidth}px"
            vSplitPanel.setMaxSplitPosition(50f, Sizeable.Unit.PERCENTAGE)
            vSplitPanel.isDockable = true
        } else {
            foldersPane.isEnabled = false
            foldersPane.isVisible = false
            foldersSplit.remove(workArea)
            val foldersSplitIndex: Int = window.indexOf(foldersSplit)
            window.remove(foldersSplit)
            window.add(workArea, foldersSplitIndex)
            window.expand(workArea)
        }
    }

    override fun getFoldersPane(): FoldersPane? {
        return foldersPane
    }
}