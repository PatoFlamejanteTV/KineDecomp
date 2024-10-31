package com.nexstreaming.app.general.service.notification;

import android.content.ContextWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.Map;

/* loaded from: classes2.dex */
public final class NotificationData {
    public static final String ACTION_NOTIFICATION = NotificationData.class.getName() + ".notification";
    public int defaultLargeImageResource;
    public int defaultSmallImageResource;
    public int id;
    public String imageUrl;
    public String message;
    public int priority;
    public String targetClass;
    public String title;
    public String uri;
    public String weblink;

    public NotificationData() {
        this.id = -1;
        this.title = null;
        this.message = null;
        this.targetClass = null;
        this.uri = null;
        this.defaultSmallImageResource = -1;
        this.defaultLargeImageResource = -1;
        this.priority = 2;
        this.imageUrl = null;
        this.weblink = null;
        this.defaultSmallImageResource = R.drawable.notification_icon;
        this.defaultLargeImageResource = R.mipmap.ic_launcher;
        this.priority = 0;
    }

    public static NotificationData fromJson(String str) {
        return (NotificationData) new GsonBuilder().create().fromJson(str, NotificationData.class);
    }

    public static NotificationData fromMap(Map<String, String> map) {
        Gson create = new GsonBuilder().create();
        return (NotificationData) create.fromJson(create.toJson(map), NotificationData.class);
    }

    public String toString() {
        return "NotificationData{id=" + this.id + ", title='" + this.title + "', message='" + this.message + "', targetClass='" + this.targetClass + "', uri=" + this.uri + ", defaultSmallImageResource=" + this.defaultSmallImageResource + ", defaultLargeImageResource=" + this.defaultLargeImageResource + ", priority: " + this.priority + ", imageUrl: " + this.imageUrl + ", weblink: " + this.weblink + '}';
    }

    public NotificationData(int i, String str, String str2, Class<? extends ContextWrapper> cls, String str3) {
        this(i, str, str2, cls, str3, R.drawable.notification_icon, R.mipmap.ic_launcher, null, null);
    }

    public NotificationData(int i, String str, String str2, Class<? extends ContextWrapper> cls, String str3, String str4, String str5) {
        this(i, str, str2, cls, str3, R.drawable.notification_icon, R.mipmap.ic_launcher, str4, str5);
    }

    public NotificationData(int i, String str, String str2, Class<? extends ContextWrapper> cls, String str3, int i2, int i3, String str4, String str5) {
        this.id = -1;
        this.title = null;
        this.message = null;
        this.targetClass = null;
        this.uri = null;
        this.defaultSmallImageResource = -1;
        this.defaultLargeImageResource = -1;
        this.priority = 2;
        this.imageUrl = null;
        this.weblink = null;
        this.id = i;
        this.title = str;
        this.message = str2;
        this.targetClass = cls.getName();
        this.uri = str3;
        this.defaultSmallImageResource = i2;
        this.defaultLargeImageResource = i3;
        this.imageUrl = str4;
        this.weblink = str5;
    }
}
