package captain.classsquared.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import captain.classsquared.R;


public class EndPage extends Activity {

    private int mScore;
    private int mIncorrect;
    private String mName;
    private TextView mScoreView;
    private TextView mWrongView;
    private TextView mTextView;
    private Button mFinishButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);
        Intent intent = getIntent();
        mScore = intent.getIntExtra("score", 0);
        mIncorrect = intent.getIntExtra("incorrect", 0);
        mName = intent.getStringExtra("name");


        mScoreView = (TextView)findViewById(R.id.textScoreView);
        mWrongView = (TextView)findViewById(R.id.textWrongView);
        mTextView = (TextView)findViewById(R.id.endText);

        String endText = "Well Done " + mName + " You finished!" + "\n" +"These are your Scores";
        String score = "Score: " + mScore;
        String wrong = "Wrong: " + mIncorrect;

        mTextView.setText(endText);
        mScoreView.setText(score);
        mWrongView.setText(wrong);



        mFinishButton = (Button)findViewById(R.id.buttonFinish);


        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToStart();
            }
        });

    }


    public void backToStart(){
        startActivity(new Intent(this, MainPage.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end_page, menu);
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
