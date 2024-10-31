package com.bumptech.glide.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class n implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private static final a f8432a = new m();

    /* renamed from: b, reason: collision with root package name */
    private volatile com.bumptech.glide.j f8433b;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f8436e;

    /* renamed from: f, reason: collision with root package name */
    private final a f8437f;

    /* renamed from: c, reason: collision with root package name */
    final Map<FragmentManager, l> f8434c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    final Map<android.support.v4.app.FragmentManager, q> f8435d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final ArrayMap<View, Fragment> f8438g = new ArrayMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f8439h = new ArrayMap<>();
    private final Bundle i = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: classes.dex */
    public interface a {
        com.bumptech.glide.j a(com.bumptech.glide.c cVar, i iVar, o oVar, Context context);
    }

    public n(a aVar) {
        this.f8437f = aVar == null ? f8432a : aVar;
        this.f8436e = new Handler(Looper.getMainLooper(), this);
    }

    private com.bumptech.glide.j b(Context context) {
        if (this.f8433b == null) {
            synchronized (this) {
                if (this.f8433b == null) {
                    this.f8433b = this.f8437f.a(com.bumptech.glide.c.a(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.f8433b;
    }

    @TargetApi(17)
    private static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static boolean d(Activity activity) {
        return !activity.isFinishing();
    }

    public com.bumptech.glide.j a(Context context) {
        if (context != null) {
            if (com.bumptech.glide.g.n.c() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return a(((ContextWrapper) context).getBaseContext());
                }
            }
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks remove;
        int i = message.what;
        Object obj = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f8434c.remove(obj);
        } else if (i != 2) {
            z = false;
            remove = null;
        } else {
            obj = (android.support.v4.app.FragmentManager) message.obj;
            remove = this.f8435d.remove(obj);
        }
        if (z && remove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }

    public com.bumptech.glide.j a(FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.g.n.b()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c(fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public l b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q b(FragmentActivity fragmentActivity) {
        return a(fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    public com.bumptech.glide.j a(Fragment fragment) {
        com.bumptech.glide.g.l.a(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.g.n.b()) {
            return a(fragment.getActivity().getApplicationContext());
        }
        return a(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public com.bumptech.glide.j a(Activity activity) {
        if (com.bumptech.glide.g.n.b()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a(activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    private l a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        l lVar = (l) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (lVar == null && (lVar = this.f8434c.get(fragmentManager)) == null) {
            lVar = new l();
            lVar.a(fragment);
            if (z) {
                lVar.a().b();
            }
            this.f8434c.put(fragmentManager, lVar);
            fragmentManager.beginTransaction().add(lVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f8436e.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return lVar;
    }

    @Deprecated
    private com.bumptech.glide.j a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        l a2 = a(fragmentManager, fragment, z);
        com.bumptech.glide.j b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        com.bumptech.glide.j a3 = this.f8437f.a(com.bumptech.glide.c.a(context), a2.a(), a2.c(), context);
        a2.a(a3);
        return a3;
    }

    private q a(android.support.v4.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        q qVar = (q) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (qVar == null && (qVar = this.f8435d.get(fragmentManager)) == null) {
            qVar = new q();
            qVar.a(fragment);
            if (z) {
                qVar.z().b();
            }
            this.f8435d.put(fragmentManager, qVar);
            fragmentManager.beginTransaction().add(qVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f8436e.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return qVar;
    }

    private com.bumptech.glide.j a(Context context, android.support.v4.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        q a2 = a(fragmentManager, fragment, z);
        com.bumptech.glide.j A = a2.A();
        if (A != null) {
            return A;
        }
        com.bumptech.glide.j a3 = this.f8437f.a(com.bumptech.glide.c.a(context), a2.z(), a2.B(), context);
        a2.a(a3);
        return a3;
    }
}
