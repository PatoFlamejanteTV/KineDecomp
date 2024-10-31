package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.Gb;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class U implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f4553a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f4554b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f4555c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ha f4556d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(ha haVar, ha haVar2, boolean z, boolean z2) {
        this.f4556d = haVar;
        this.f4553a = haVar2;
        this.f4554b = z;
        this.f4555c = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.adobe.creativesdk.foundation.internal.net.k kVar;
        G g2;
        synchronized (this.f4553a) {
            if (this.f4553a.y) {
                return;
            }
            kVar = this.f4556d.F;
            if (kVar != null) {
                g2 = this.f4556d.f4625a;
                if (!g2.x()) {
                    if (this.f4554b) {
                        this.f4553a.q();
                    }
                    if (this.f4553a.m.isEmpty() && this.f4553a.i.isEmpty() && this.f4553a.f4630f.isEmpty() && this.f4553a.n.isEmpty() && this.f4553a.f4631g.isEmpty() && !this.f4553a.g() && !this.f4553a.h()) {
                        if (!this.f4553a.y && this.f4555c) {
                            this.f4553a.x = new Date();
                            this.f4556d.n();
                        }
                        return;
                    }
                    this.f4553a.y = true;
                    this.f4553a.r();
                    this.f4553a.s();
                    this.f4553a.p();
                    try {
                        this.f4553a.c(true);
                        this.f4553a.c(false);
                    } catch (Exception e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, ha.class.getSimpleName(), null, e2);
                    }
                    this.f4556d.a(false);
                }
            }
        }
    }
}
