package com.company.speedypizzaapp.web.screens.staff;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizzaapp.entity.Staff;

@UiController("speedypizzaapp_Staff.edit")
@UiDescriptor("staff-edit.xml")
@EditedEntityContainer("staffDc")
@LoadDataBeforeShow
public class StaffEdit extends StandardEditor<Staff> {
}