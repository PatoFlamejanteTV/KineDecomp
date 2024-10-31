package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.Button;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Dh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ih f21821a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f21822b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dh(Ih ih, String str) {
        this.f21821a = ih;
        this.f21822b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zh.h(this.f21821a.f21906a) != null) {
            Button h2 = zh.h(this.f21821a.f21906a);
            if (h2 != null) {
                h2.setText(this.f21822b);
                Button h3 = zh.h(this.f21821a.f21906a);
                if (h3 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                h3.setEnabled(true);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        if (zh.l(this.f21821a.f21906a)) {
            zh.c(this.f21821a.f21906a, false);
        }
    }
}
