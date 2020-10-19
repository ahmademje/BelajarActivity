package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;

/**
 * Created by fahrul on 13/03/19.
 */

public class ToDoListPresenter implements ToDoListContract.Presenter{
    private final ToDoListContract.View view;

    public ToDoListPresenter(ToDoListContract.View view) {
        this.view = view;
    }

    @Override
    public void saveNewList(String judulItem) {
        // Add New Item on List View
    }

    @Override
    public void showDescrptionItem() {
        // Show this Description Selected item
        view.redirectToItem();
    }

    @Override
    public void editItem(int idItem) {
        //Edit This Selected Item
    }
}
