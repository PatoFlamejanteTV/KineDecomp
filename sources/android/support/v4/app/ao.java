package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* compiled from: NotificationCompatGingerbread.java */
/* loaded from: classes.dex */
class ao {
    public static Notification a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
