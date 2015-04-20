package captain.classsquared.model;


import captain.classsquared.R;

public class QuestionStore {
    private Question[] mQuestions;

    public QuestionStore(){
        mQuestions = new Question[2];

        mQuestions[0] = new Question(
                "Here's Question 1",
                new Choice("This is the Answer", 1),
                new Choice("This is the 1st wrong answer", 1),
                new Choice("This is the 2nd wrong answer", 1),
                new Choice("This is the 3rd wrong answer", 1)
        );
        mQuestions[1] = new Question(
                "here's question 2",
                new Choice("This is the Answer", 2),
                new Choice("This is the 1st wrong answer", 2),
                new Choice("This is the 2nd wrong answer",2),
                new Choice("This is the 3rd wrong answer",2)
        );

        mQuestions[2] = new Question(
                "here's question 3",
                new Choice("this is the answer",3),
                new Choice("this is the 1st wrong answer",3),
                new Choice("This is the 2nd wrong answer",3),
                new Choice("This is the 3rd wrong answer",3)
        );
    }

    public Question getQuestionNumber(int questionNumber){
        return mQuestions[questionNumber];
    }


}
