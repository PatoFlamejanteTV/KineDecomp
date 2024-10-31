package com.nexstreaming.app.general.service.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.aj;
import android.support.v4.app.az;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;

/* compiled from: NotificationHelper.java */
/* loaded from: classes.dex */
public class b extends com.nexstreaming.app.general.service.a {

    /* renamed from: a */
    private NotificationManager f3186a;

    public b(Context context) {
        super(context);
        this.f3186a = null;
        this.f3186a = (NotificationManager) context.getSystemService("notification");
    }

    public void a(Intent intent) {
        if (intent != null) {
            a((NotificationData) intent.getParcelableExtra("noti_parcelable"));
        }
    }

    public void a(NotificationData notificationData) {
        if (notificationData != null && notificationData.id > -1) {
            Log.i("NotificationHelper", "createNotification() called with: data = [" + notificationData.toString() + "]");
            aj.d dVar = new aj.d(a());
            dVar.a(notificationData.title).b(notificationData.message).b(-1).a(System.currentTimeMillis()).a(true);
            if (notificationData.defaultSmallImageResource > 0) {
                dVar.a(notificationData.defaultLargeImageResource);
            } else {
                dVar.a(R.drawable.notification_icon);
            }
            if (notificationData.targetClass != null) {
                Class<?> cls = null;
                try {
                    cls = Class.forName(notificationData.targetClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(a(), cls);
                intent.setAction(NotificationData.ACTION_NOTIFICATION);
                if (!TextUtils.isEmpty(notificationData.uri)) {
                    intent.setData(Uri.parse(notificationData.uri));
                }
                az a2 = az.a(a());
                a2.a(ProjectGalleryActivity.class);
                a2.a(intent);
                dVar.a(a2.a(0, 134217728));
            }
            this.f3186a.notify(notificationData.id, dVar.a());
            Log.i("NotificationHelper", "createNotification() complete");
            return;
        }
        Log.i("NotificationHelper", "createNotification() called with: data = [ null ]");
    }

    public void b(Intent intent) {
        if (intent != null) {
            a(intent.getIntExtra(ShareConstants.WEB_DIALOG_PARAM_ID, -1));
        }
    }

    public void a(int i) {
        Log.i("NotificationHelper", "cancelNotification() called with: id = [" + i + "]");
        this.f3186a.cancel(i);
    }

    public void b() {
        this.f3186a.cancelAll();
    }
}
