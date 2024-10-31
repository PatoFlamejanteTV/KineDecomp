package com.nexstreaming.kinemaster.ui.gdpr;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.k;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrivacyPolicyAgreeUtil.java */
/* loaded from: classes.dex */
public class i implements k.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.d.b.b.a.e f21606a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f21607b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f21608c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c.d.b.b.a.e eVar, int i, Activity activity) {
        this.f21606a = eVar;
        this.f21607b = i;
        this.f21608c = activity;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.k.b
    public void onDialogCanceled(DialogInterface dialogInterface, DialogFragment dialogFragment) {
        ConfirmFragment a2 = ConfirmFragment.a(this.f21608c.getString(R.string.GDPR_account_uncheck_popup));
        dialogFragment.setCancelable(false);
        a2.a(new h(this, a2, dialogFragment, dialogInterface));
        a2.show(this.f21608c.getFragmentManager(), a2.getClass().getSimpleName());
    }

    @Override // com.nexstreaming.kinemaster.ui.a.k.b
    public void onDialogOk(DialogInterface dialogInterface, DialogFragment dialogFragment) {
        dialogInterface.dismiss();
        l.f21612b = false;
        Date date = new Date();
        this.f21606a.setPrivacyVersion(this.f21607b);
        this.f21606a.setPrivacyAgreeTime(date.getTime());
        c.d.b.b.i.b().d();
    }
}
