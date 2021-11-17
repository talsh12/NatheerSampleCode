package com.elm.natheertest.model;

import java.util.HashMap;
import java.util.List;

import lombok.Data;


@Data
public class NotificationModel {
	private String notificationId;
	private String notificationCode;
	private String primaryId;
	private  HashMap<String, String> parameterList;
}
