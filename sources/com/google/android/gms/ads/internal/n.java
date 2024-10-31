package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzawr;

/* loaded from: classes.dex */
final class N implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzw f10005a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ L f10006b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(L l, zzw zzwVar) {
        this.f10006b = l;
        this.f10005a = zzwVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f10005a.a();
        zzawr zzawrVar = this.f10006b.f10001b;
        if (zzawrVar == null) {
            return false;
        }
        zzawrVar.zzxr();
        return false;
    }
}
