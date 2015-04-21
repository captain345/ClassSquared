package captain.classsquared.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import captain.classsquared.R;
import captain.classsquared.model.Question;
import captain.classsquared.model.QuestionStore;


public class StudentActivity extends Activity {

    private QuestionStore mStore = new QuestionStore();
    private TextView mQuestionView;
    private TextView mStudentName;
    private TextView mScore;
    private RadioGroup mRadioGroup;
    private Button mButton;
    private Question mCurrentPage;
    private int mPageNumber = 0;
    private String mName;
    private String scoreView;
    private int score = 0;
    private int incorrect = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if(mName == null){
            mName = "Friend";
        }

        mQuestionView = (TextView)findViewById(R.id.studentQuestion);
        mStudentName = (TextView)findViewById(R.id.nameTextView);
        mScore = (TextView)findViewById(R.id.scoreTextView);
        mRadioGroup = (RadioGroup)findViewById(R.id.radioAnswers);
        mButton = (Button)findViewById(R.id.nextButton);
        loadQuestion(0);
    }

    private void loadQuestion(int choice) {
        mCurrentPage = mStore.getQuestionNumber(choice);
        String nameView = "Hi " + mName + " Welcome to Class Squared";

        scoreView = "Correct: " + score + "\n"  + "Wrong: " + incorrect;

        mScore.setText(scoreView);
        mStudentName.setText(nameView);
        mQuestionView.setText(mCurrentPage.getQuestion());

        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            ((RadioButton) mRadioGroup.getChildAt(i)).setText(mCurrentPage.getPossibleAnswers(i));
            (mRadioGroup.getChildAt(i)).setId(i);
        }

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mRadioGroup.getCheckedRadioButtonId() == mCurrentPage.getCorrect()) {
                        score++;
                    } else {
                        incorrect++;
                    }

                    mPageNumber++;

                    if(mPageNumber == mStore.getArrayLength()){
                        finishQuiz(score, incorrect);
                    }
                    else{
                        loadQuestion(mPageNumber);
                    }

                }
            });
    }


    private void finishQuiz(int score, int incorrect){
        Intent intent = new Intent(this, EndPage.class);
        intent.putExtra("score", score);
        intent.putExtra("incorrect", incorrect);
        intent.putExtra("name", mName);
        startActivity(intent);
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
