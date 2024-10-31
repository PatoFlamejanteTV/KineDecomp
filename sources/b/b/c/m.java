package b.b.c;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

/* compiled from: CustomTabsSession.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    private final Object f3288a = new Object();

    /* renamed from: b */
    private final o f3289b;

    /* renamed from: c */
    private final n f3290c;

    /* renamed from: d */
    private final ComponentName f3291d;

    public m(o oVar, n nVar, ComponentName componentName) {
        this.f3289b = oVar;
        this.f3290c = nVar;
        this.f3291d = componentName;
    }

    public boolean a(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.f3289b.a(this.f3290c, uri, bundle, list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public ComponentName b() {
        return this.f3291d;
    }

    public IBinder a() {
        return this.f3290c.asBinder();
    }
}
