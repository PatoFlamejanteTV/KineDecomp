package com.nexstreaming.app.general.iab.Presenter;

import android.app.Activity;
import com.nexstreaming.app.general.iab.SKUDetails;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1683l<T> implements io.reactivex.o<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1695y f19392a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SKUDetails f19393b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f19394c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1683l(C1695y c1695y, SKUDetails sKUDetails, Activity activity) {
        this.f19392a = c1695y;
        this.f19393b = sKUDetails;
        this.f19394c = activity;
    }

    @Override // io.reactivex.o
    public final void a(io.reactivex.n<com.nexstreaming.app.general.iab.b.f> nVar) {
        kotlin.jvm.internal.h.b(nVar, "it");
        this.f19392a.a(new RunnableC1682k(this, nVar));
    }
}
