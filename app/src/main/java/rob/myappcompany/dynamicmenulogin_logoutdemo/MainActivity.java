package rob.myappcompany.dynamicmenulogin_logoutdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isLogged = false;
    TextView mTextView;
    Switch mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mSwitch = findViewById(R.id.switch1);


        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Toast.makeText(MainActivity.this, "Switch"+isChecked, Toast.LENGTH_SHORT).show();
                isLogged = isChecked;
                updateUI();
            }
        });

        updateUI();
    }

    private void updateUI(){
        String text = isLogged ? "Logged In" : "Logged out";
        mTextView.setText(text);
        //for updating UI in Menu should use InvalidOption, else be gone Visible
        invalidateOptionsMenu();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        /*if (isLogged){
            menu.removeItem(R.id.action_login);
        }else{
            menu.removeItem(R.id.action_logout);
        }*/
        menu.removeItem(isLogged ? R.id.action_login : R.id.action_logout);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_logout:
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}