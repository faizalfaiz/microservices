package org.notification;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.myapp.clients.Notification.NotificationRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {

	private final NotificationService notificationService;
@PostMapping
public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
	log.info("new notification...{}", notificationRequest);
	notificationService.send(notificationRequest);
}

}
