package pens.lab.app.belajaractivity.modul.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import pens.lab.app.belajaractivity.FirstActivity;
import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;


/**
 * Created by fahrul on 13/03/19.
 */

public class ProfileFragment extends BaseFragment<ProfileActivity, ProfileContract.Presenter> implements ProfileContract.View {

    TextView tvEmail;
    TextView tvPassword;
    String email;
    String password;
    Button btnLogin;


    public ProfileFragment(String email, String password) {
        email = email;
        password = password;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        mPresenter = new ProfilePresenter(this);
        mPresenter.start();

        tvEmail = fragmentView.findViewById(R.id.tvEmailProfile);
        tvPassword = fragmentView.findViewById(R.id.tvPasswordProfile);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });

        setTitle("Profile");

        return fragmentView;
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToProfile() {
            Intent intent = new Intent(activity, FirstActivity.class);
            startActivity(intent);
            activity.finish();
    }


}
