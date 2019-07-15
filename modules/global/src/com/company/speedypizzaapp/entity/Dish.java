package com.company.speedypizzaapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "SPEEDYPIZZAAPP_DISH")
@Entity(name = "speedypizzaapp_Dish")
public class Dish extends StandardEntity {
    private static final long serialVersionUID = 1843081453202528822L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    @NotNull
    @Column(name = "COOKING_TIME", nullable = false)
    protected LocalTime cookingTime;

    @JoinTable(name = "SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENTS_ID"))
    @ManyToMany
    protected List<Ingredients> ingredientses;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISH_TYPE_ID")
    protected DishType dishType;

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public List<Ingredients> getIngredientses() {
        return ingredientses;
    }

    public void setIngredientses(List<Ingredients> ingredientses) {
        this.ingredientses = ingredientses;
    }

    public LocalTime getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(LocalTime cookingTime) {
        this.cookingTime = cookingTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}