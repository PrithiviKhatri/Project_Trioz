package trioz.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	private String Question;
	@ManyToOne
	@JoinColumn(name = "quizeId")
	private Quize quize;
	public Quize getQuize() {
		return quize;
	}
	public void setQuize(Quize quize) {
		this.quize = quize;
	}
	@OneToOne
	@JoinColumn(name = "answerId")
	private Answer answer;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
}
