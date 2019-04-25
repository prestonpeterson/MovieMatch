package com.moviematch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private LoginViewModel mViewModel;
    View view;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        System.out.println("LoginFragment::onCreateView");

        view = inflater.inflate(R.layout.login_fragment, container, false);
        view.findViewById(R.id.loginButton).setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        System.out.println("onclick");
        switch (v.getId()) {
            case R.id.loginButton:
                System.out.println("Logging in...");
                NavController navController = NavHostFragment.findNavController(this);
                navController.navigate(R.id.movieSelectFragment);
                navController.popBackStack(R.id.loginFragment, true);
                break;
        }

    }
}
