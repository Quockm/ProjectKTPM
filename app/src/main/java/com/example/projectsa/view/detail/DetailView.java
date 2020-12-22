package com.example.projectsa.view.detail;

import com.example.projectsa.model.Meals;

public interface DetailView {

    void showLoading();
    void hideLoading();
    void setMeals(Meals.Meal meal);
    void onErrorLoading(String message);

}
