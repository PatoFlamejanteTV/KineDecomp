package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@KeepForSdk
/* loaded from: classes.dex */
public class ConnectionTracker {

    /* renamed from: b */
    private static volatile ConnectionTracker f11237b;

    /* renamed from: d */
    private final List<String> f11239d;

    /* renamed from: e */
    private final List<String> f11240e;

    /* renamed from: f */
    private final List<String> f11241f;

    /* renamed from: g */
    private final List<String> f11242g;

    /* renamed from: a */
    private static final Object f11236a = new Object();

    /* renamed from: c */
    @VisibleForTesting
    private static boolean f11238c = false;

    private ConnectionTracker() {
        List<String> list = Collections.EMPTY_LIST;
        this.f11239d = list;
        this.f11240e = list;
        this.f11241f = list;
        this.f11242g = list;
    }

    @KeepForSdk
    public static ConnectionTracker a() {
        if (f11237b == null) {
            synchronized (f11236a) {
                if (f11237b == null) {
                    f11237b = new ConnectionTracker();
                }
            }
        }
        return f11237b;
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : ClientLibraryUtils.b(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i);
    }

    @KeepForSdk
    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @KeepForSdk
    @SuppressLint({"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
