package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
class kb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ tb f23161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kb(tb tbVar) {
        this.f23161a = tbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f23161a.getActivity().onBackPressed();
    }
}
