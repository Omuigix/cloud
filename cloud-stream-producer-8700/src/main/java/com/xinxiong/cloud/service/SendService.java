package com.xinxiong.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding({MySource.class})
public class SendService {

    @Autowired
    private  MySource mysource;

    public void sendMsg(String msg){
        mysource.myOutput().send(MessageBuilder.withPayload(msg).build());
    }
}