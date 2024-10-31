package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
/* loaded from: classes2.dex */
public class TagManager {

    /* renamed from: a */
    private static TagManager f14181a;

    /* renamed from: b */
    private final zza f14182b;

    /* renamed from: c */
    private final Context f14183c;

    /* renamed from: d */
    private final DataLayer f14184d;

    /* renamed from: e */
    private final zzfm f14185e;

    /* renamed from: f */
    private final ConcurrentMap<String, F> f14186f;

    /* renamed from: g */
    private final C1455a f14187g;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public interface zza {
    }

    @VisibleForTesting
    private TagManager(Context context, zza zzaVar, DataLayer dataLayer, zzfm zzfmVar) {
        if (context != null) {
            this.f14183c = context.getApplicationContext();
            this.f14185e = zzfmVar;
            this.f14182b = zzaVar;
            this.f14186f = new ConcurrentHashMap();
            this.f14184d = dataLayer;
            this.f14184d.a(new A(this));
            this.f14184d.a(new z(this.f14183c));
            this.f14187g = new C1455a();
            this.f14183c.registerComponentCallbacks(new C(this));
            com.google.android.gms.tagmanager.zza.a(this.f14183c);
            return;
        }
        throw new NullPointerException("context cannot be null");
    }

    public static TagManager a(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (f14181a == null) {
                if (context != null) {
                    f14181a = new TagManager(context, new B(), new DataLayer(new C1458d(context)), u.b());
                } else {
                    zzdi.c("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
            }
            tagManager = f14181a;
        }
        return tagManager;
    }

    public void a() {
        this.f14185e.a();
    }

    public final synchronized boolean a(Uri uri) {
        zzeh b2 = zzeh.b();
        if (!b2.a(uri)) {
            return false;
        }
        String a2 = b2.a();
        int i = D.f14162a[b2.c().ordinal()];
        if (i == 1) {
            F f2 = this.f14186f.get(a2);
            if (f2 != null) {
                f2.b(null);
                f2.b();
            }
        } else if (i == 2 || i == 3) {
            for (String str : this.f14186f.keySet()) {
                F f3 = this.f14186f.get(str);
                if (str.equals(a2)) {
                    f3.b(b2.d());
                    f3.b();
                } else if (f3.c() != null) {
                    f3.b(null);
                    f3.b();
                }
            }
        }
        return true;
    }

    @VisibleForTesting
    public final boolean a(F f2) {
        return this.f14186f.remove(f2.a()) != null;
    }

    public final void a(String str) {
        Iterator<F> it = this.f14186f.values().iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }
}
