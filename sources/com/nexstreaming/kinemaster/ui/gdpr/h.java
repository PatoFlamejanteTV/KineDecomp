package com.nexstreaming.kinemaster.ui.gdpr;

import android.app.DialogFragment;
import android.content.DialogInterface;
import com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment;
import java.util.Date;

/* compiled from: PrivacyPolicyAgreeUtil.java */
/* loaded from: classes.dex */
class h implements ConfirmFragment.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConfirmFragment f21602a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DialogFragment f21603b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DialogInterface f21604c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ i f21605d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, ConfirmFragment confirmFragment, DialogFragment dialogFragment, DialogInterface dialogInterface) {
        this.f21605d = iVar;
        this.f21602a = confirmFragment;
        this.f21603b = dialogFragment;
        this.f21604c = dialogInterface;
    }

    @Override // com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment.a
    public void a(ConfirmFragment.BUTTON button) {
        this.f21602a.dismiss();
        this.f21603b.setCancelable(true);
        if (k.f21610a[button.ordinal()] != 1) {
            return;
        }
        this.f21604c.dismiss();
        l.f21612b = false;
        Date date = new Date();
        this.f21605d.f21606a.setPrivacyVersion(0);
        this.f21605d.f21606a.setPrivacyAgreeTime(date.getTime());
        c.d.b.b.i.b().d();
        c.d.b.b.i.b().c();
    }
}
