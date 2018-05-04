package com.event.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class GameEvent {

	@PrimaryKey
	private int userId;
	private String userName;
	private int topicId;
	private String topicName;
	private String gender;
	private String userLabel;
	private String userCountry;
	private String gameStatus;
	private int questionId;
	private String questionOption;
	private int userFinalScore;
	private boolean active;
	
	public GameEvent() {
		
	}
	
	

	public GameEvent(int userId, String userName, int topicId, String topicName, String gender, String userLabel,
			String userCountry, String gameStatus, int questionId, String questionOption, int userFinalScore,
			boolean active) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.topicId = topicId;
		this.topicName = topicName;
		this.gender = gender;
		this.userLabel = userLabel;
		this.userCountry = userCountry;
		this.gameStatus = gameStatus;
		this.questionId = questionId;
		this.questionOption = questionOption;
		this.userFinalScore = userFinalScore;
		this.active = active;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(String questionOption) {
		this.questionOption = questionOption;
	}

	public int getUserFinalScore() {
		return userFinalScore;
	}

	public void setUserFinalScore(int userFinalScore) {
		this.userFinalScore = userFinalScore;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



	@Override
	public String toString() {
		return "GameEvent [userId=" + userId + ", userName=" + userName + ", topicId=" + topicId + ", topicName="
				+ topicName + ", gender=" + gender + ", userLabel=" + userLabel + ", userCountry=" + userCountry
				+ ", gameStatus=" + gameStatus + ", questionId=" + questionId + ", questionOption=" + questionOption
				+ ", userFinalScore=" + userFinalScore + ", active=" + active + "]";
	}
	
	
	
}