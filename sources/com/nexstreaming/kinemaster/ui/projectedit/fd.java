package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Fd implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f21845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fd(Bd bd) {
        this.f21845a = bd;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f21845a.r = true;
    }
}
