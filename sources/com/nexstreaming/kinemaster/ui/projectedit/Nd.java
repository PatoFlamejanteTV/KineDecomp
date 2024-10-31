package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Nd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Od f21972a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f21973b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nd(Od od, String str) {
        this.f21972a = od;
        this.f21973b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.nexstreaming.kinemaster.mediastore.scanner.e h2 = KineMasterApplication.f24058f.c().h();
        if (h2 != null) {
            h2.a(new File(this.f21973b)).onComplete(new Md(this));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
