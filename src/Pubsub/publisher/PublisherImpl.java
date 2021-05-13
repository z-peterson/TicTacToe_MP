package Pubsub.publisher;

import Pubsub.Message;
import Pubsub.service.PubSubService;

public class PublisherImpl {
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }
}
