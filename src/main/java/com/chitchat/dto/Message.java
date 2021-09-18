package com.chitchat.dto;

public class Message {
    private String text;
    private String from;
    private String to;
    private long timeStamp;

    public Message(){}

    public Message(String text, String from, String to, long timeStamp) {
        this.text = text;
        this.from = from;
        this.to = to;
        this.timeStamp = timeStamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
