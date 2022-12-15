package com.example.appmovilunab.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.appmovilunab.Listado_docentes;
import com.example.appmovilunab.MainActivity;
import com.example.appmovilunab.R;
import com.example.appmovilunab.forgotPass;
//import com.example.appmovilunab.password.CambioPassword;
//import com.example.appmovilunab.password.RestaurarPassword;
//import com.example.appmovilunab.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    //private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
//        binding = ActivityLoginBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);
//
//        final EditText usernameEditText = binding.username;
//        final EditText passwordEditText = binding.password;
//        final Button loginButton = binding.login;
//        final ProgressBar loadingProgressBar = binding.loading;
//
//        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
//            @Override
//            public void onChanged(@Nullable LoginFormState loginFormState) {
//                if (loginFormState == null) {
//                    return;
//                }
//                loginButton.setEnabled(loginFormState.isDataValid());
//                if (loginFormState.getUsernameError() != null) {
//                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
//                }
//                if (loginFormState.getPasswordError() != null) {
//                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
//                }
//            }
//        });
//
//        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
//            @Override
//            public void onChanged(@Nullable LoginResult loginResult) {
//                if (loginResult == null) {
//                    return;
//                }
//                loadingProgressBar.setVisibility(View.GONE);
//                if (loginResult.getError() != null) {
//                    showLoginFailed(loginResult.getError());
//                }
//                if (loginResult.getSuccess() != null) {
//                    updateUiWithUser(loginResult.getSuccess());
//                }
//                setResult(Activity.RESULT_OK);
//
//                //Complete and destroy login activity once successful
//                finish();
//            }
//        });
//
//        TextWatcher afterTextChangedListener = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // ignore
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // ignore
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        };
//        usernameEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    loginViewModel.login(usernameEditText.getText().toString(),
//                            passwordEditText.getText().toString());
//                }
//                return false;
//            }
//        });
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingProgressBar.setVisibility(View.VISIBLE);
//                loginViewModel.login(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        });
//    }
//
//    private void updateUiWithUser(LoggedInUserView model) {
//        String welcome = getString(R.string.welcome) + model.getDisplayName();
//        // TODO : initiate successful logged in experience
//        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//    }
//
//    private void showLoginFailed(@StringRes Integer errorString) {
//        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
//    }
    public void viewLogin(View view) {
        switch (view.getId()){

            case R.id.registrar:
                Intent intentHist=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentHist);
                break;

            case R.id.login:
                Intent intentProf=new Intent(LoginActivity.this, Listado_docentes.class);
                startActivity(intentProf);
                break;
            case R.id.forgetpass:
                Intent intentEst=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentEst);
                break;
//            case R.id.btnUpdateEst:
//                Intent intent =new Intent(LoginActivity.this, ImageTextListViewActivity.class);
//                //intent.putExtra("dato", x);
//                startActivity(intent);
//                Context context= getApplicationContext();
//                CharSequence updateMsg = "¡Datos actualizados con éxito!";
//                int time = Toast.LENGTH_LONG;
//                Toast toast = Toast.makeText(context, updateMsg, time);
//                toast.setGravity(Gravity.CENTER, 0, 0 );
//
//                toast.show();
//                break;
//            case R.id.btndeleteEst:
//                Context context2= getApplicationContext();
//                CharSequence deleteMsg = "¡Datos eliminados con éxito!";
//                int time2 = Toast.LENGTH_LONG;
//                Toast toast2 = Toast.makeText(context2, deleteMsg, time2);
//                toast2.setGravity(Gravity.CENTER, 0, 0 );
//
//
//                toast2.show();
//                break;


        }

    }
}