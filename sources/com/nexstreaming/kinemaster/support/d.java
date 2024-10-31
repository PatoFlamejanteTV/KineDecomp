package com.nexstreaming.kinemaster.support;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f21240a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f21241b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(f fVar, Intent intent) {
        this.f21241b = fVar;
        this.f21240a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent;
        if (!c.d.b.m.i.f(this.f21241b.f21243a.getActivity()) || (intent = this.f21240a) == null) {
            return;
        }
        this.f21241b.f21243a.startActivity(intent);
        dialogInterface.dismiss();
    }
}
