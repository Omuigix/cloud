package com.xinxiong.cloud.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface MySource {

    @Output("myOutput")
    MessageChannel myOutput();
}