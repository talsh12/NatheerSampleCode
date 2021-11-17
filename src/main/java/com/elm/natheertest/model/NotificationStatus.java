package com.elm.natheertest.model;


public enum NotificationStatus {
    SUCCESS,
    FAILURE,
    UNAUTHORIZED;
	
    public String value() {
        return name();
    }

    public static NotificationStatus fromValue(String v) {
        return valueOf(v);
    }
}
