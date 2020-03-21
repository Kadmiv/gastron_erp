package com.planarry.gastron_erp.web.screens.task

import com.haulmont.cuba.gui.screen.*
import com.planarry.gastron_erp.entity.task.Task

@UiController("gastronerp_Task.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
@LoadDataBeforeShow
class TaskBrowse : StandardLookup<Task>()