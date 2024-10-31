package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public final class zzav {

    /* renamed from: a */
    private static zzav f17413a;

    /* renamed from: b */
    private final SimpleArrayMap<String, String> f17414b = new SimpleArrayMap<>();

    /* renamed from: c */
    private Boolean f17415c = null;

    /* renamed from: d */
    final Queue<Intent> f17416d = new ArrayDeque();

    /* renamed from: e */
    private final Queue<Intent> f17417e = new ArrayDeque();

    private zzav() {
    }

    public static synchronized zzav a() {
        zzav zzavVar;
        synchronized (zzav.class) {
            if (f17413a == null) {
                f17413a = new zzav();
            }
            zzavVar = f17413a;
        }
        return zzavVar;
    }

    public static void b(Context context, Intent intent) {
        context.sendBroadcast(b(context, "com.google.firebase.MESSAGING_EVENT", intent));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9 A[Catch: IllegalStateException -> 0x010e, SecurityException -> 0x0136, TryCatch #4 {IllegalStateException -> 0x010e, SecurityException -> 0x0136, blocks: (B:35:0x00d5, B:37:0x00d9, B:40:0x00e2, B:41:0x00e8, B:43:0x00f0, B:45:0x0102, B:49:0x00f5), top: B:34:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0 A[Catch: IllegalStateException -> 0x010e, SecurityException -> 0x0136, TryCatch #4 {IllegalStateException -> 0x010e, SecurityException -> 0x0136, blocks: (B:35:0x00d5, B:37:0x00d9, B:40:0x00e2, B:41:0x00e8, B:43:0x00f0, B:45:0x0102, B:49:0x00f5), top: B:34:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0102 A[Catch: IllegalStateException -> 0x010e, SecurityException -> 0x0136, TRY_LEAVE, TryCatch #4 {IllegalStateException -> 0x010e, SecurityException -> 0x0136, blocks: (B:35:0x00d5, B:37:0x00d9, B:40:0x00e2, B:41:0x00e8, B:43:0x00f0, B:45:0x0102, B:49:0x00f5), top: B:34:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5 A[Catch: IllegalStateException -> 0x010e, SecurityException -> 0x0136, TryCatch #4 {IllegalStateException -> 0x010e, SecurityException -> 0x0136, blocks: (B:35:0x00d5, B:37:0x00d9, B:40:0x00e2, B:41:0x00e8, B:43:0x00f0, B:45:0x0102, B:49:0x00f5), top: B:34:0x00d5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int c(android.content.Context r6, android.content.Intent r7) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzav.c(android.content.Context, android.content.Intent):int");
    }

    private static Intent b(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) FirebaseInstanceIdReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, i, b(context, "com.google.firebase.MESSAGING_EVENT", intent), 1073741824);
    }

    public final Intent b() {
        return this.f17417e.poll();
    }

    public static void a(Context context, Intent intent) {
        context.sendBroadcast(b(context, "com.google.firebase.INSTANCE_ID_EVENT", intent));
    }

    public final int a(Context context, String str, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Starting service: ".concat(valueOf) : new String("Starting service: "));
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -842411455) {
            if (hashCode == 41532704 && str.equals("com.google.firebase.MESSAGING_EVENT")) {
                c2 = 1;
            }
        } else if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            c2 = 0;
        }
        if (c2 == 0) {
            this.f17416d.offer(intent);
        } else {
            if (c2 != 1) {
                String valueOf2 = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf2.length() != 0 ? "Unknown service action: ".concat(valueOf2) : new String("Unknown service action: "));
                return 500;
            }
            this.f17417e.offer(intent);
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return c(context, intent2);
    }
}
