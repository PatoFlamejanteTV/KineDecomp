package com.nexstreaming.app.general.iab.Presenter;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import java.util.Locale;
import kotlin.TypeCastException;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class ea implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ fa f19378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(fa faVar) {
        this.f19378a = faVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context f2 = this.f19378a.f19381b.f19385a.f();
        String c2 = this.f19378a.f19381b.f19385a.c();
        Locale locale = Locale.ENGLISH;
        kotlin.jvm.internal.h.a((Object) locale, "Locale.ENGLISH");
        if (c2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = c2.toLowerCase(locale);
        kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        WXAccessToken wXAccessToken = this.f19378a.f19381b.f19385a.q;
        if (wXAccessToken != null) {
            com.nexstreaming.kinemaster.tracelog.f.a(f2, lowerCase, wXAccessToken.c(), "").onResultAvailable(new aa(this)).onFailure((Task.OnFailListener) new da(this));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
