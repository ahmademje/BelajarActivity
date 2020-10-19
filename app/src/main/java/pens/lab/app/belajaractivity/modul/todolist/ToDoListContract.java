package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface ToDoListContract {
    interface View extends BaseView<Presenter> {
        void redirectToItem();
        void redirectToListItem();
    }

    interface Presenter extends BasePresenter {
        void saveNewList(String judulItem);
        void showDescrptionItem();
        void editItem(int idItem);
    }
}
