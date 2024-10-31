package com.nexstreaming.app.general.service;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.general.service.notification.c;
import com.nexstreaming.kinemaster.ui.SplashActivity;
import java.util.Map;

/* loaded from: classes2.dex */
public class FCMService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void a(RemoteMessage remoteMessage) {
        NotificationData notificationData;
        Map<String, String> a2 = remoteMessage.a();
        if (a2.size() > 0) {
            notificationData = NotificationData.fromMap(a2);
        } else {
            notificationData = new NotificationData();
        }
        RemoteMessage.Notification O = remoteMessage.O();
        if (O != null) {
            notificationData.title = O.b();
            notificationData.message = O.a();
        }
        notificationData.targetClass = SplashActivity.class.getName();
        new c(this).a(notificationData);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void b(String str) {
        super.b(str);
        Log.d("FCMService", "onNewToken: " + str);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void a() {
        super.a();
    }
}
