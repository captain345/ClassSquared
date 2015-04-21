package captain.classsquared.model;

/**
 * Created by Thomas on 20/04/2015.
 */
public class Question {
    private String mQuestion;
    private String[] mAnswer = new String[4];



    private int mCorrect;

    public Question(String question, String[] answer, int correct){
        mQuestion = question;
        mAnswer = answer;
        mCorrect = correct;

    }


    public String getPossibleAnswers(int i) {
        String answer = mAnswer[i];
        return answer;
    }

    public void setAnswer(String[] answer) {
        mAnswer = answer;
    }


    public String getQuestion() {
        return mQuestion;
    }
    public int getCorrect() {
        return mCorrect;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }


}//end of class
