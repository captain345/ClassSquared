package captain.classsquared.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import captain.classsquared.R;


public class MainPage extends Activity {

    private EditText mNameField;
    private Button mStudentButton;
    private Button mTeacherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mNameField = (EditText)findViewById(R.id.editTextMain);
        mStudentButton = (Button)findViewById(R.id.buttonStudent);
        mTeacherButton = (Button)findViewById(R.id.buttonTeacher);


        mStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mStudentButton.getText().toString();
                startStudent(name);
            }
        });

        mTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mTeacherButton.getText().toString();
                startTeacher(name);
            }
        });
    }

    private void startStudent(String name){
        Intent intent = new Intent(this, StudentActivity.class);
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }


    private void startTeacher(String name){
        /*Intent intent = new Intent(this, TeacherActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
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


}
