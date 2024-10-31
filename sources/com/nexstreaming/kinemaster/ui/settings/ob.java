package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.SKUDetails;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
public class ob implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SKUDetails f23174a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ tb f23175b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ob(tb tbVar, SKUDetails sKUDetails) {
        this.f23175b = tbVar;
        this.f23174a = sKUDetails;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f23175b.getActivity() != null) {
            if (c.d.b.m.i.f(this.f23175b.getActivity())) {
                SKUDetails sKUDetails = this.f23174a;
                if (sKUDetails != null) {
                    this.f23175b.a(sKUDetails);
                    return;
                }
                IABManager iABManager = this.f23175b.J;
                if (iABManager != null) {
                    iABManager.a((DialogInterface.OnClickListener) null);
                    return;
                }
                return;
            }
            IABManager iABManager2 = this.f23175b.J;
            if (iABManager2 != null) {
                iABManager2.a((DialogInterface.OnClickListener) null);
            }
        }
    }
}
