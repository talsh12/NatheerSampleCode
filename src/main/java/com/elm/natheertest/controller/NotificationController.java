package com.elm.natheertest.controller;

//sample code for natheer clients

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elm.natheertest.model.NotificationStatus;
import com.elm.natheertest.model.NotificationModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/myendpoint")
@RequiredArgsConstructor
@Log4j2
public class NotificationController {
	
//	/primaryIdNotification must be last of the endpoint 
	@PostMapping("/primaryIdNotification")
	public ResponseEntity<?> simpleClientReceiverNotifications(@RequestBody List<NotificationModel> list) {
		log.info("From Natheer Notification: " + list.toString());

		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getParameterList() != null) {
					list.get(i).getParameterList().forEach((k, v) -> {
						log.info("key:" + k + " , value: " + v);
					});
				} else {
					log.info("Parameter List is Empty");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(NotificationStatus.FAILURE.name());
		}
		
		return new ResponseEntity<String>(NotificationStatus.SUCCESS.toString(), HttpStatus.OK);
	}
}
