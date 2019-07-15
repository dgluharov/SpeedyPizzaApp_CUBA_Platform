package com.company.speedypizzaapp.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizzaapp.entity.Dish;

@UiController("speedypizzaapp_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {
}