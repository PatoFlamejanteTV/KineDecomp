package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Zd implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zd(Bd bd) {
        this.f22195a = bd;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        boolean Ha;
        if (i == 66) {
            kotlin.jvm.internal.h.a((Object) keyEvent, NotificationCompat.CATEGORY_EVENT);
            if (keyEvent.getAction() == 0) {
                Ha = this.f22195a.Ha();
                if (Ha) {
                    return true;
                }
            }
        }
        return false;
    }
}
