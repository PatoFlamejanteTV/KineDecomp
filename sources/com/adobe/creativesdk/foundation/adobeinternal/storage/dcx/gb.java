package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import java.util.HashMap;
import java.util.Map;

/* compiled from: FileLockManager.java */
/* loaded from: classes.dex */
public class gb {

    /* renamed from: a */
    private static volatile gb f4383a;

    /* renamed from: b */
    private volatile Map<String, fb> f4384b = new HashMap();

    private gb() {
    }

    public static gb a() {
        gb gbVar = f4383a;
        if (gbVar == null) {
            synchronized (gb.class) {
                gbVar = f4383a;
                if (gbVar == null) {
                    gbVar = new gb();
                    f4383a = gbVar;
                }
            }
        }
        return gbVar;
    }

    public void b(String str) {
        synchronized (this) {
            if (this.f4384b.containsKey(str)) {
                fb fbVar = this.f4384b.get(str);
                if (fbVar.f4376b.getAndDecrement() == 1) {
                    this.f4384b.remove(str);
                }
                fbVar.f4375a.unlock();
            }
        }
    }

    public void a(String str) {
        fb fbVar;
        synchronized (this) {
            if (this.f4384b.containsKey(str)) {
                fbVar = this.f4384b.get(str);
            } else {
                fb fbVar2 = new fb();
                this.f4384b.put(str, fbVar2);
                fbVar = fbVar2;
            }
            fbVar.f4376b.getAndIncrement();
        }
        fbVar.f4375a.lock();
    }
}
