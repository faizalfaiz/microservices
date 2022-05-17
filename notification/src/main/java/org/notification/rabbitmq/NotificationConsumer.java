package org.notification.rabbitmq;

import org.notification.NotificationService;
import org.springframework.stereotype.Component;
import com.myapp.clients.Notification.NotificationRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {
private final NotificationService notificationService;

@RabbitListener(queues="${rabbitmq.queues.notification}")
public void consumer(NotificationRequest notificationRequest) {
log.info("Consumer {} from queue", notificationRequest);
notificationService.send(notificationRequest);
}
}
