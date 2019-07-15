package com.company.speedypizzaapp.web.screens.staff;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizzaapp.entity.Staff;

@UiController("speedypizzaapp_Staff.browse")
@UiDescriptor("staff-browse.xml")
@LookupComponent("staffsTable")
@LoadDataBeforeShow
public class StaffBrowse extends StandardLookup<Staff> {
}