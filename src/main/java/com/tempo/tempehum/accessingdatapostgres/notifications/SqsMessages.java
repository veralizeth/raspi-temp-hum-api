package com.tempo.tempehum.accessingdatapostgres.notifications;
import com.tempo.tempehum.accessingdatapostgres.utils.SQSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SqsMessages implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private SQSUtil sqsUtil;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        sqsUtil.startListeningToMessages();
    }
}


