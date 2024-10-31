package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
final class p implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ View f21453a;

    /* renamed from: b */
    final /* synthetic */ View f21454b;

    public p(View view, View view2) {
        this.f21453a = view;
        this.f21454b = view2;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        kotlin.jvm.internal.h.a((Object) keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 61) {
            return false;
        }
        if (keyEvent.hasModifiers(1)) {
            View view2 = this.f21453a;
            if (view2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            view2.requestFocus();
        } else {
            View view3 = this.f21454b;
            if (view3 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            view3.requestFocus();
        }
        return true;
    }
}
