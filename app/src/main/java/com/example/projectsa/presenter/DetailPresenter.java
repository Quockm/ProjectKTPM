package com.example.projectsa.presenter;

import com.example.projectsa.common.Utils;
import com.example.projectsa.model.Meals;
import com.example.projectsa.view.detail.DetailView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    public void getMealById(String mealName) {

        view.showLoading();

        Utils.getApi().getMealByName(mealName)
                .enqueue(new Callback<Meals>() {
                    @Override
                    public void onResponse(Call<Meals> call, Response<Meals> response) {
                        view.hideLoading();
                        if(response.isSuccessful() && response.body() != null)
                        {
                            view.setMeals(response.body().getMeals().get(0));
                        }else{
                            view.onErrorLoading(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Meals> call, Throwable t) {
                        view.hideLoading();
                        view.onErrorLoading(t.getLocalizedMessage());

                    }
                });

    }
}
