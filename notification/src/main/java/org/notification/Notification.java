package org.notification;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Getter
@Setter
@ToString

public class Notification {

	@Id
	@SequenceGenerator(
			name = "notification_sequence",
			sequenceName ="notification_sequence")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "notification_sequence")
	
	
private Integer notificationId;
private Integer toCustomerId;
private String toCustomerEmail;
private String sender;
private String message;
private LocalDateTime sentAt;
}
