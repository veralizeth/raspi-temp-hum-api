package com.tempo.tempehum.accessingdatapostgres.messages;

public class ReportedMessage {

    private ReportedData reported;
    public ReportedData getReported() {
        return reported;
    }

    public void setReported(ReportedData reported) {
        this.reported = reported;
    }
}
