package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.aj;
import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zza {

    /* renamed from: a, reason: collision with root package name */
    static zza f1415a;
    private Context b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.gcm.zza$zza, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0034zza extends IllegalArgumentException {
        private C0034zza(String str) {
            super(str);
        }
    }

    private zza(Context context) {
        this.b = context.getApplicationContext();
    }

    private int a() {
        return (int) SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized zza a(Context context) {
        zza zzaVar;
        synchronized (zza.class) {
            if (f1415a == null) {
                f1415a = new zza(context);
            }
            zzaVar = f1415a;
        }
        return zzaVar;
    }

    static String a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String a(String str) {
        return str.substring("gcm.n.".length());
    }

    private void a(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.b.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Bundle bundle) {
        return a(bundle, "gcm.n.icon") != null;
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new C0034zza("Missing icon");
        }
        Resources resources = this.b.getResources();
        int identifier = resources.getIdentifier(str, "drawable", this.b.getPackageName());
        if (identifier == 0 && (identifier = resources.getIdentifier(str, "mipmap", this.b.getPackageName())) == 0) {
            throw new C0034zza("Icon resource not found: " + str);
        }
        return identifier;
    }

    private String b(Bundle bundle, String str) {
        String a2 = a(bundle, str);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String a3 = a(bundle, str + "_loc_key");
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        Resources resources = this.b.getResources();
        int identifier = resources.getIdentifier(a3, "string", this.b.getPackageName());
        if (identifier == 0) {
            throw new C0034zza(a(str + "_loc_key") + " resource not found: " + a3);
        }
        String a4 = a(bundle, str + "_loc_args");
        if (TextUtils.isEmpty(a4)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(a4);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            try {
                return resources.getString(identifier, objArr);
            } catch (MissingFormatArgumentException e) {
                throw new C0034zza("Missing format argument for " + a3 + ": " + e);
            }
        } catch (JSONException e2) {
            throw new C0034zza("Malformed " + a(str + "_loc_args") + ": " + a4);
        }
    }

    private Notification c(Bundle bundle) {
        String b = b(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(b)) {
            throw new C0034zza("Missing title");
        }
        String b2 = b(bundle, "gcm.n.body");
        int b3 = b(a(bundle, "gcm.n.icon"));
        Uri c = c(a(bundle, "gcm.n.sound"));
        PendingIntent d = d(bundle);
        if (Build.VERSION.SDK_INT < 11) {
            if (d == null) {
                Intent intent = new Intent();
                intent.setPackage("com.google.example.invalidpackage");
                d = PendingIntent.getBroadcast(this.b, 0, intent, 0);
            }
            aj.d b4 = new aj.d(this.b).a(b3).a(true).a(d).a(b).b(b2);
            if (c != null) {
                b4.a(c);
            }
            return b4.a();
        }
        Notification.Builder contentText = new Notification.Builder(this.b).setAutoCancel(true).setSmallIcon(b3).setContentTitle(b).setContentText(b2);
        if (Build.VERSION.SDK_INT >= 21) {
            String a2 = a(bundle, "gcm.n.color");
            if (!TextUtils.isEmpty(a2)) {
                contentText.setColor(Color.parseColor(a2));
            }
        }
        if (c != null) {
            contentText.setSound(c);
        }
        if (d != null) {
            contentText.setContentIntent(d);
        }
        return Build.VERSION.SDK_INT >= 16 ? contentText.build() : contentText.getNotification();
    }

    private Uri c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str)) {
            return RingtoneManager.getDefaultUri(2);
        }
        throw new C0034zza("Invalid sound: " + str);
    }

    private PendingIntent d(Bundle bundle) {
        String a2 = a(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        Intent intent = new Intent(a2);
        intent.setPackage(this.b.getPackageName());
        intent.setFlags(268435456);
        intent.putExtras(bundle);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.b, a(), intent, 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle) {
        try {
            a(a(bundle, "gcm.n.tag"), c(bundle));
            return true;
        } catch (C0034zza e) {
            Log.w("GcmNotification", "Failed to show notification: " + e.getMessage());
            return false;
        }
    }
}
