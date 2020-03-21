package com.planarry.gastron_erp.web.screens.task

import com.haulmont.cuba.gui.screen.*
import com.planarry.gastron_erp.entity.task.Task

@UiController("gastronerp_Task.edit")
@UiDescriptor("task-edit.xml")
@EditedEntityContainer("taskDc")
@LoadDataBeforeShow
class TaskEdit : StandardEditor<Task>()