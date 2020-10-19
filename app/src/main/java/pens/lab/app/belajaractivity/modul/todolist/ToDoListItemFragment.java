package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;


/**
 * Created by fahrul on 13/03/19.
 */

public class ToDoListItemFragment extends BaseFragment<ToDoListActivity, ToDoListContract.Presenter> implements ToDoListContract.View {

    Button btnEdit;
    Button btnHapus;
    TextView tv_descriptionItem;

    public ToDoListItemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.todolist_item, container, false);
        mPresenter = new ToDoListPresenter(this);
        mPresenter.start();

        btnEdit = fragmentView.findViewById(R.id.btn_edit);
        btnHapus = fragmentView.findViewById(R.id.btn_hapus);
        tv_descriptionItem = fragmentView.findViewById(R.id.item_selected_view);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnEditClick();
            }
        });

        Intent intent = new Intent

        setTitle("My Login View");

        return fragmentView;
    }

    public void setBtnEditClick(){
        mPresenter.saveNewList(idItem);
    }

    @Override
    public void setPresenter(ToDoListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToItem() {
        Intent intent = new Intent(activity, ToDoListItemActivity.class);
        intent.putExtra("judulItem", judulItem);
        startActivity(intent);
        activity.finish();
    }

}
