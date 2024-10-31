package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: ShareSubscriptionActivity.java */
/* loaded from: classes2.dex */
class Ia implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSubscriptionActivity f23283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(ShareSubscriptionActivity shareSubscriptionActivity) {
        this.f23283a = shareSubscriptionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f23283a.y().a((DialogInterface.OnClickListener) null);
    }
}
