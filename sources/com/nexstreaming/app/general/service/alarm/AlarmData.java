package com.nexstreaming.app.general.service.alarm;

import com.nexstreaming.app.general.service.notification.NotificationData;

/* loaded from: classes2.dex */
public class AlarmData {
    public long dTime;
    public int id;
    public String name;
    public NotificationData notificationData;

    public AlarmData() {
        this.id = -1;
        this.name = null;
        this.dTime = 0L;
        this.notificationData = null;
    }

    public String toString() {
        return "AlarmData{id=" + this.id + ", name='" + this.name + "', dTime=" + this.dTime + ", notificationData=" + this.notificationData + '}';
    }

    public AlarmData(int i, String str, long j, NotificationData notificationData) {
        this.id = -1;
        this.name = null;
        this.dTime = 0L;
        this.notificationData = null;
        this.id = i;
        this.name = str;
        this.dTime = j;
        this.notificationData = notificationData;
    }
}
