package com.scm20.scm22.helper;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Message {

    private String content;
    @Builder.Default
    private MessageType type=MessageType.blue;

    
    
    
}
