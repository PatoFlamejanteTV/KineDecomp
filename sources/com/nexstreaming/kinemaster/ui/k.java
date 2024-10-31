package com.nexstreaming.kinemaster.ui;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.ui.gdpr.g;

/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class k implements g.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplashActivity f21616a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.gdpr.g f21617b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SplashActivity splashActivity, com.nexstreaming.kinemaster.ui.gdpr.g gVar) {
        this.f21616a = splashActivity;
        this.f21617b = gVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.gdpr.g.a
    public void a(DialogInterface dialogInterface, boolean z, boolean z2) {
        kotlin.jvm.internal.h.b(dialogInterface, "dialog");
        if (z && z2) {
            dialogInterface.dismiss();
            c.d.b.c.a.a(this.f21616a.getApplicationContext(), 3, z, z2);
            this.f21616a.L();
            return;
        }
        this.f21616a.a(this.f21617b, z, z2);
    }

    @Override // com.nexstreaming.kinemaster.ui.gdpr.g.a
    public void a(DialogInterface dialogInterface) {
        kotlin.jvm.internal.h.b(dialogInterface, "dialog");
        SplashActivity splashActivity = this.f21616a;
        splashActivity.a(this.f21617b, c.d.b.c.a.d(splashActivity), c.d.b.c.a.c(this.f21616a));
    }
}
