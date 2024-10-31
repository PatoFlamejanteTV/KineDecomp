package b.b.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a */
    private final o f3278a;

    /* renamed from: b */
    private final ComponentName f3279b;

    public h(o oVar, ComponentName componentName) {
        this.f3278a = oVar;
        this.f3279b = componentName;
    }

    public static boolean a(Context context, String str, l lVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, lVar, 33);
    }

    public boolean a(long j) {
        try {
            return this.f3278a.a(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public m a(a aVar) {
        g gVar = new g(this, aVar);
        try {
            if (this.f3278a.a(gVar)) {
                return new m(this.f3278a, gVar, this.f3279b);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }
}
