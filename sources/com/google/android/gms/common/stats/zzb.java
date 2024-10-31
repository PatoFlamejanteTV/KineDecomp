package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class zzb {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1040a = new Object();
    private static zzb b;
    private static Integer h;
    private final List<String> c;
    private final List<String> d;
    private final List<String> e;
    private final List<String> f;
    private zze g;
    private zze i;

    private zzb() {
        if (c() == zzd.b) {
            this.c = Collections.EMPTY_LIST;
            this.d = Collections.EMPTY_LIST;
            this.e = Collections.EMPTY_LIST;
            this.f = Collections.EMPTY_LIST;
            return;
        }
        String str = zzc.zza.b.get();
        this.c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = zzc.zza.c.get();
        this.d = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = zzc.zza.d.get();
        this.e = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = zzc.zza.e.get();
        this.f = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        this.g = new zze(1024, zzc.zza.f.get().longValue());
        this.i = new zze(1024, zzc.zza.f.get().longValue());
    }

    public static zzb a() {
        synchronized (f1040a) {
            if (b == null) {
                b = new zzb();
            }
        }
        return b;
    }

    private String a(ServiceConnection serviceConnection) {
        return String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
    }

    private void a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if ((c() & zzd.f) != 0 && i != 13) {
            str6 = zzmy.zzl(3, 5);
        }
        long nativeHeapAllocatedSize = (c() & zzd.h) != 0 ? Debug.getNativeHeapAllocatedSize() : 0L;
        context.startService(new Intent().setComponent(zzd.f1044a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (i == 1 || i == 4 || i == 14) ? new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize) : new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize)));
    }

    private void a(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        String str5 = null;
        if (!b() || this.g == null) {
            return;
        }
        if (i != 4 && i != 1) {
            ServiceInfo b2 = b(context, intent);
            if (b2 == null) {
                Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", str2, intent.toUri(0)));
                return;
            }
            str4 = b2.processName;
            str3 = b2.name;
            str5 = zzmy.zzaq(context);
            if (!a(str5, str2, str4, str3)) {
                return;
            } else {
                this.g.a(str);
            }
        } else {
            if (!this.g.b(str)) {
                return;
            }
            str3 = null;
            str4 = null;
        }
        a(context, str, i, str5, str2, str4, str3);
    }

    private boolean a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null || (com.google.android.gms.common.internal.zzd.f1003a && "com.google.android.gms".equals(component.getPackageName()))) {
            return false;
        }
        return zzmm.zzl(context, component.getPackageName());
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return (this.c.contains(str) || this.d.contains(str2) || this.e.contains(str3) || this.f.contains(str4) || (str3.equals(str) && (c() & zzd.g) != 0)) ? false : true;
    }

    private static ServiceInfo b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", intent.toUri(0), zzmy.zzl(3, 20)));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", intent.toUri(0), zzmy.zzl(3, 20)));
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", it.next().serviceInfo.name);
                return null;
            }
        }
        return queryIntentServices.get(0).serviceInfo;
    }

    private boolean b() {
        return com.google.android.gms.common.internal.zzd.f1003a && c() != zzd.b;
    }

    private static int c() {
        if (h == null) {
            try {
                h = Integer.valueOf(zzmm.zzjA() ? zzc.zza.f1042a.get().intValue() : zzd.b);
            } catch (SecurityException e) {
                h = Integer.valueOf(zzd.b);
            }
        }
        return h.intValue();
    }

    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        a(context, a(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        a(context, a(serviceConnection), str, intent, 3);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            a(context, a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        a(context, a(serviceConnection), (String) null, (Intent) null, 4);
    }
}
