package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.net.G;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.Timer;

/* compiled from: AdobeCollaborationSessionModel.java */
/* loaded from: classes.dex */
public class j implements G {

    /* renamed from: a, reason: collision with root package name */
    private static j f5010a;

    private j() {
    }

    public static j a() {
        if (f5010a == null) {
            f5010a = new j();
        }
        return f5010a;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public void a(A a2) {
    }

    public void b() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public boolean b(A a2) {
        boolean z;
        if (!a2.e()) {
            z = c.a.a.a.a.a.a.b().h();
            a2.a(AdobeAuthIdentityManagementService.K().c());
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeStorageModel", "Too many authentication failures have occurred within the last 5 minutes.");
            a2.a((String) null);
            z = false;
        }
        if (z) {
            a2.a(false);
        }
        return z;
    }

    public void c() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public void c(A a2) {
        Timer timer = new Timer();
        timer.schedule(new i(this, a2, timer), 15000L, 15000L);
    }
}
