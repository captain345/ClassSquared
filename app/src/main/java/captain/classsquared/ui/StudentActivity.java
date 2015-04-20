package captain.classsquared.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;

import captain.classsquared.R;
import captain.classsquared.model.Question;
import captain.classsquared.model.QuestionStore;


public class StudentActivity extends Activity {

    public static final  String TAG = StudentActivity.class.getSimpleName();
    private QuestionStore mStore = new QuestionStore();
    private TextView mQuestionView;
    private TextView mStudentName;
    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;
    private RadioButton mChoice4;

    private String mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if(mName == null){
            mName = "Friend";
        }

        Log.d(TAG, mName);

        mQuestionView = (TextView)findViewById(R.id.studentQuestion);
        mStudentName = (TextView)findViewById(R.id.nameTextView);
        mChoice1 = (RadioButton)findViewById(R.id.radioA1);
        mChoice2 = (RadioButton)findViewById(R.id.radioA2);
        mChoice3 = (RadioButton)findViewById(R.id.radioA3);
        mChoice4 = (RadioButton)findViewById(R.id.radioA4);
    }

    private void loadQuestion(){
        Question store = mStore.getQuestionNumber(0);
        String nameView ="Hi" + mName + "Welcome to Class Squared";

        mStudentName.setText(nameView);
        mQuestionView.setText(store.getQuestion());
        mChoice1.setText(store.getChoice1().getText());
        mChoice2.setText(store.getChoice2().getText());
        mChoice3.setText(store.getChoice3().getText());
        mChoice4.setText(store.getChoice4().getText());

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student, menu);
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
