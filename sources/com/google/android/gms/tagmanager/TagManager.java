package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class TagManager {
    private static TagManager g;

    /* renamed from: a, reason: collision with root package name */
    private final zza f2205a;
    private final Context b;
    private final DataLayer c;
    private final zzct d;
    private final ConcurrentMap<zzo, Boolean> e;
    private final ap f;

    /* loaded from: classes.dex */
    public interface zza {
    }

    TagManager(Context context, zza zzaVar, DataLayer dataLayer, zzct zzctVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.b = context.getApplicationContext();
        this.d = zzctVar;
        this.f2205a = zzaVar;
        this.e = new ConcurrentHashMap();
        this.c = dataLayer;
        this.c.a(new d(this));
        this.c.a(new ak(this.b));
        this.f = new ap();
        b();
    }

    public static TagManager a(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (g == null) {
                if (context == null) {
                    zzbg.a("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                g = new TagManager(context, new e(), new DataLayer(new ar(context)), ae.b());
            }
            tagManager = g;
        }
        return tagManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Iterator<zzo> it = this.e.keySet().iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.b.registerComponentCallbacks(new f(this));
        }
    }

    public void a() {
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean a(Uri uri) {
        boolean z;
        zzcb a2 = zzcb.a();
        if (a2.a(uri)) {
            String d = a2.d();
            switch (a2.b()) {
                case NONE:
                    for (zzo zzoVar : this.e.keySet()) {
                        if (zzoVar.b().equals(d)) {
                            zzoVar.b(null);
                            zzoVar.a();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzo zzoVar2 : this.e.keySet()) {
                        if (zzoVar2.b().equals(d)) {
                            zzoVar2.b(a2.c());
                            zzoVar2.a();
                        } else if (zzoVar2.c() != null) {
                            zzoVar2.b(null);
                            zzoVar2.a();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(zzo zzoVar) {
        return this.e.remove(zzoVar) != null;
    }
}
