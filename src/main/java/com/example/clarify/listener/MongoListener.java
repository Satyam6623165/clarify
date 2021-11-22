package com.example.clarify.listener;

import com.example.clarify.model.Post;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MongoListener extends AbstractMongoEventListener<Post> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Post> event) {
        super.onBeforeConvert(event);

        Date date = new Date();

        event.getSource().setCreatedAt(date);
        event.getSource().setModifiedAt(date);
    }
}
