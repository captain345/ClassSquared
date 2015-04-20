package captain.classsquared.model;

/**
 * Created by Thomas on 20/04/2015.
 */
public class Question {
    private String mQuestion;
    private Choice mChoice1;
    private Choice mChoice2;
    private Choice mChoice3;
    private Choice mChoice4;
   //private boolean mIsFinal = false;




    public Question(String question, Choice choice1, Choice choice2, Choice choice3, Choice choice4){
        mQuestion = question;
        mChoice1 = choice1;
        mChoice2 = choice2;
        mChoice3 = choice3;
        mChoice4 = choice4;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public Choice getChoice3() {
        return mChoice3;
    }

    public void setChoice3(Choice choice3) {
        mChoice3 = choice3;
    }

    public Choice getChoice4() {
        return mChoice4;
    }

    public void setChoice4(Choice choice4) {
        mChoice4 = choice4;
    }
}//end of class
