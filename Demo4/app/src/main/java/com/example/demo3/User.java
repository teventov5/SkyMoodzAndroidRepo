package com.example.demo3;
public class User {
    private String Username,Pwd,secretQuestion,secretAnswer;
    public User(String tempUserName,String tempPwd,String secretQuestion,String secretAnswer)
    {
     this.setUsername(tempUserName);
     this.setPwd(tempPwd);
     this.setSecretQuestion(secretQuestion);
     this.setSecretAnswer(secretAnswer);
    }
    public User(String tempUserName,String tempPwd)
    {
        this.setUsername(tempUserName);
        this.setPwd(tempPwd);
        this.setSecretQuestion("Empty Question");
        this.setSecretAnswer("Empty Answer");
    }

    public String getPwd() {
        return Pwd;
    }

    public String getUsername() {
        return Username;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
}
