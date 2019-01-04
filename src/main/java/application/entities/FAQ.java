package application.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "faq")
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long faqId;

    private String engQuestion;
    private String estQuestion;
    private String engAnswer;
    private String estAnswer;

    public FAQ(String engQuestion, String estQuestion, String engAnswer, String estAnswer) {
        this.engQuestion = engQuestion;
        this.estQuestion = estQuestion;
        this.engAnswer = engAnswer;
        this.estAnswer = estAnswer;
    }

    public FAQ() {
    }

    public Long getFaqId() {
        return faqId;
    }

    public void setFaqId(Long faqId) {
        this.faqId = faqId;
    }

    public String getEngQuestion() {
        return engQuestion;
    }

    public void setEngQuestion(String engQuestion) {
        this.engQuestion = engQuestion;
    }

    public String getEstQuestion() {
        return estQuestion;
    }

    public void setEstQuestion(String estQuestion) {
        this.estQuestion = estQuestion;
    }

    public String getEngAnswer() {
        return engAnswer;
    }

    public void setEngAnswer(String engAnswer) {
        this.engAnswer = engAnswer;
    }

    public String getEstAnswer() {
        return estAnswer;
    }

    public void setEstAnswer(String estAnswer) {
        this.estAnswer = estAnswer;
    }

    @Override
    public String toString() {
        return "FAQ{" +
                "faqId=" + faqId +
                ", engQuestion='" + engQuestion + '\'' +
                ", estQuestion='" + estQuestion + '\'' +
                ", engAnswer='" + engAnswer + '\'' +
                ", estAnswer='" + estAnswer + '\'' +
                '}';
    }
}
