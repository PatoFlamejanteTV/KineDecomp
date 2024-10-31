package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzbm {

    /* renamed from: a */
    private final zzbp f13966a;

    public zzbm(zzbp zzbpVar) {
        Preconditions.a(zzbpVar);
        this.f13966a = zzbpVar;
    }

    public static boolean a(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.a(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void a(Context context, Intent intent) {
        zzbw a2 = zzbw.a(context, (zzan) null);
        zzas b2 = a2.b();
        if (intent == null) {
            b2.t().a("Receiver called with null intent");
            return;
        }
        a2.zzgw();
        String action = intent.getAction();
        b2.y().a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            b2.y().a("Starting wakeful intent.");
            this.f13966a.a(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                a2.zzgs().a(new RunnableC1434p(this, a2, b2));
            } catch (Exception e2) {
                b2.t().a("Install Referrer Reporter encountered a problem", e2);
            }
            BroadcastReceiver.PendingResult a3 = this.f13966a.a();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                b2.y().a("Install referrer extras are null");
                if (a3 != null) {
                    a3.finish();
                    return;
                }
                return;
            }
            b2.w().a("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            Bundle a4 = a2.p().a(Uri.parse(stringExtra));
            if (a4 == null) {
                b2.y().a("No campaign defined in install referrer broadcast");
                if (a3 != null) {
                    a3.finish();
                    return;
                }
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0L) * 1000;
            if (longExtra == 0) {
                b2.t().a("Install referrer is missing timestamp");
            }
            a2.zzgs().a(new RunnableC1436q(this, a2, longExtra, a4, context, b2, a3));
        }
    }
}
