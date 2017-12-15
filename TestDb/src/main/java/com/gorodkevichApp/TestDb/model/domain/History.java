package com.gorodkevichApp.TestDb.model.domain;

public class History {
    private int historyId;
    private int historyNumberCard;
    private String historyTypeOperation;
    private String historyDataOperation;
    private String historyTimeOperations;
    private double historyAmountOperations;

    public History(int historyNumberCard, String historyTypeOperation, String historyDataOperation, String historyTimeOperations, double historyAmountOperations) {
        this.historyNumberCard = historyNumberCard;
        this.historyTypeOperation = historyTypeOperation;
        this.historyDataOperation = historyDataOperation;
        this.historyTimeOperations = historyTimeOperations;
        this.historyAmountOperations = historyAmountOperations;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getHistoryNumberCard() {
        return historyNumberCard;
    }

    public void setHistoryNumberCard(int historyNumberCard) {
        this.historyNumberCard = historyNumberCard;
    }

    public String getHistoryTypeOperation() {
        return historyTypeOperation;
    }

    public void setHistoryTypeOperation(String historyTypeOperation) {
        this.historyTypeOperation = historyTypeOperation;
    }

    public String getHistoryDataOperation() {
        return historyDataOperation;
    }

    public void setHistoryDataOperation(String historyDataOperation) {
        this.historyDataOperation = historyDataOperation;
    }

    public String getHistoryTimeOperations() {
        return historyTimeOperations;
    }

    public void setHistoryTimeOperations(String historyTimeOperations) {
        this.historyTimeOperations = historyTimeOperations;
    }

    public double getHistoryAmountOperations() {
        return historyAmountOperations;
    }

    public void setHistoryAmountOperations(double historyAmountOperations) {
        this.historyAmountOperations = historyAmountOperations;
    }
}
