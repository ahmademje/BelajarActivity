package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.profile.ProfileActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class ToDoListFragment extends BaseFragment<ToDoListActivity, ToDoListContract.Presenter> implements ToDoListContract.View {

    EditText etJudulItem;
    Button btnTambahList;
    ListView lvItemList;
    String judulItem;
    Intent intent;
    String items[] = new String(){"Install laravel", "TodoList App", "Learning API"};

    public ToDoListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.todolist_dashboard, container, false);
        mPresenter = new ToDoListPresenter(this);
        mPresenter.start();

        etJudulItem = fragmentView.findViewById(R.id.et_judulItem);
        btnTambahList = fragmentView.findViewById(R.id.btn_tambahList);
        lvItemList = fragmentView.findViewById(R.id.lv_itemLists);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItemList.setAdapter(adapter);

        lvItemList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setItemClick(view, position);
            }
        });

        btnTambahList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });

        setTitle("My Login View");

        return fragmentView;
    }

    public void setBtLoginClick(){
        judulItem = etJudulItem.getText().toString();
        mPresenter.saveNewList(judulItem);
    }

    public void setItemClick(View view, int position){
        intent = new Intent(view.getContext(), ToDoListItemActivity.class);
        if(position == 0){
            intent.putExtra('item', 'Your Next Task Must be Installing Laravel');
        }else if(position == 1){
            intent.putExtra('item', 'You must think about your ToDoList Design and Architecture');
        }else if(position == 2) {
            intent.putExtra('item', 'Did You Know About API?, Lets find out!');
        }
        mPresenter.showDescrptionItem(position, intent);
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
