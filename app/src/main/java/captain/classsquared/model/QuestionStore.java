package captain.classsquared.model;


public class QuestionStore {
    private Question[] mQuestions;
    private String[] answer;



    private int mArrayLength = 3;

    public QuestionStore(){
        mQuestions = new Question[mArrayLength];
        answer = new String[4];

        mQuestions[0] = new Question("In a computer what is the component that stores information?",
                new String[]{answer[0] = "Random Access Memory (RAM)", answer[1] = "The Motherboard", answer[2] = "Hard Drive (HDD)", answer[3] = "Power Supply"}, 2);

        mQuestions[1] = new Question("Which one of the following is a programming language? ",
                new String[]{answer[0] = "Coffee", answer[1] = "Java", answer[2] = "HTTP", answer[3] = "HDD"}, 1);

        mQuestions[2] = new Question("What is the maximum amount of RAM for a 32-bit Operating System",
                new String[]{answer[0] = "2 RAMs", answer[1] = "A Lot", answer[2] = "64 Kilobytes", answer[3] = "4 Gigabytes"}, 3);
    }

    public Question getQuestionNumber(int questionNumber){
        return mQuestions[questionNumber];
    }
    public int getArrayLength() {
        return mArrayLength;
    }


}
