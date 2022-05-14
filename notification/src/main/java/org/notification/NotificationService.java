package org.notification;

import java.time.LocalDateTime;


import org.springframework.stereotype.Service;

import com.myapp.clients.Notification.NotificationRequest;
import lombok.AllArgsConstructor;




@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                .toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerName())
                .sender("Service")
                .message(notificationRequest.getMessage())
                .sentAt(LocalDateTime.now())
                .build()
);
    }
}