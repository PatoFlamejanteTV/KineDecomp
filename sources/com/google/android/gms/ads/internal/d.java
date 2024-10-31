package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
class d implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zze f560a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, zze zzeVar) {
        this.b = cVar;
        this.f560a = zzeVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f560a.a();
        return false;
    }
}
