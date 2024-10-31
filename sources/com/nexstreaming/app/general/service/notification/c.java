package com.nexstreaming.app.general.service.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.SplashActivity;

/* compiled from: NotificationHelper.java */
/* loaded from: classes2.dex */
public class c extends com.nexstreaming.app.general.service.a {

    /* renamed from: b */
    private NotificationManager f19732b;

    public c(Context context) {
        super(context);
        this.f19732b = null;
        this.f19732b = (NotificationManager) context.getSystemService("notification");
    }

    public static /* synthetic */ void a(c cVar, NotificationData notificationData, Bitmap bitmap) {
        cVar.a(notificationData, bitmap);
    }

    public void a(NotificationData notificationData) {
        if (notificationData != null && notificationData.id > -1) {
            if (notificationData.imageUrl != null) {
                new Handler(a().getMainLooper()).post(new b(this, notificationData));
                return;
            } else {
                a(notificationData, null);
                return;
            }
        }
        Log.i("NotificationHelper", "createNotification() called with: data = [ null ]");
    }

    public void a(NotificationData notificationData, Bitmap bitmap) {
        Log.i("NotificationHelper", "createNotification() called with: data = [" + notificationData.toString() + "]");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(a());
        builder.setContentTitle(notificationData.title).setColor(a().getResources().getColor(R.color.km_red)).setContentText(notificationData.message).setDefaults(-1).setWhen(System.currentTimeMillis()).setSmallIcon(notificationData.defaultSmallImageResource).setPriority(notificationData.priority).setAutoCancel(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        } else {
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationData.message).setSummaryText(notificationData.title));
        }
        if (notificationData.priority > 0 && Build.VERSION.SDK_INT >= 21) {
            builder.setVibrate(new long[0]);
        }
        String str = notificationData.targetClass;
        if (str != null) {
            Class<?> cls = null;
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            Intent intent = new Intent(a(), cls);
            intent.setAction(NotificationData.ACTION_NOTIFICATION);
            if (!TextUtils.isEmpty(notificationData.uri)) {
                intent.setData(Uri.parse(notificationData.uri));
            }
            String str2 = notificationData.weblink;
            if (str2 != null) {
                intent.putExtra("weblink", str2);
            }
            TaskStackBuilder create = TaskStackBuilder.create(a());
            create.addParentStack(SplashActivity.class);
            create.addNextIntent(intent);
            builder.setContentIntent(create.getPendingIntent(0, 134217728));
        }
        this.f19732b.notify(notificationData.id, builder.build());
        Log.i("NotificationHelper", "createNotification() complete");
    }
}
