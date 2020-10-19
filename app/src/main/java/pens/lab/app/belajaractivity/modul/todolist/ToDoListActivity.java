package pens.lab.app.belajaractivity.modul.todolist;

import android.view.View;

import pens.lab.app.belajaractivity.base.BaseFragmentHolderActivity;


public class ToDoListActivity extends BaseFragmentHolderActivity {
    ToDoListFragment toDoListFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        toDoListFragment = new ToDoListFragment();
        setCurrentFragment(toDoListFragment, false);

    }



}
