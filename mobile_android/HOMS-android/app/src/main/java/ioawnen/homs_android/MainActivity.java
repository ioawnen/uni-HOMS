package ioawnen.homs_android;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeToast(String message) {

        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public boolean validateLogin() //Validates login input against some set rules.
    {
        //Grab the login details
        EditText usernameEditText = (EditText) findViewById(R.id.login_username);
        String sUsername = usernameEditText.getText().toString();
        EditText passwordEditText = (EditText) findViewById(R.id.login_password);
        String sPassword = passwordEditText.getText().toString();

        //Check if empty
        if (!sUsername.matches("") && !sPassword.matches("")) {

            return true;
        }
        else if (sUsername.matches("")) {
            makeToast(getString(R.string.login_no_username));
            return false;
        }
        else if (sPassword.matches("")) {
            makeToast(getString(R.string.login_no_password));
            return false;
        }
        else {
            makeToast(getString(R.string.login_error_generic));
            return false;
        }


    }
    //
    //Button Events
    //
    public void onLoginButtonPress(View view) {

        //Check yo credentials

        //Stub. Use this to control login progress at some point

        if(validateLogin()) {



            Intent intent = new Intent(this, HomeActivity.class);
            makeToast(getString(R.string.login_successful));
            startActivity(intent);
        }
        else {
            makeToast(getString(R.string.login_error_generic));
            return;
        }
    }
}
