package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.app.NotificationCompat;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class _d implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _d(Bd bd) {
        this.f22202a = bd;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean Ha;
        kotlin.jvm.internal.h.a((Object) motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (motionEvent.getActionMasked() == 0) {
            Ha = this.f22202a.Ha();
            if (Ha) {
                return true;
            }
        }
        return false;
    }
}
