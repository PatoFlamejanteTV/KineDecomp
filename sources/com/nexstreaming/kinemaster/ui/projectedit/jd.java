package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Jd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Kd f21912a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f21913b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Jd(Kd kd, String str) {
        this.f21912a = kd;
        this.f21913b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.nexstreaming.kinemaster.mediastore.scanner.e h2 = KineMasterApplication.f24058f.c().h();
        if (h2 != null) {
            h2.a(new File(this.f21913b)).onComplete(new Id(this));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
