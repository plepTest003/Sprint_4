package datafortests;

public class QuestionAnswerData {
    public String buttonId;
    public String textBlock;
    public String expectedText;

    public QuestionAnswerData(String buttonId, String textBlock, String expectedText) {
        this.buttonId = buttonId;
        this.textBlock = textBlock;
        this.expectedText = expectedText;
    }

}
