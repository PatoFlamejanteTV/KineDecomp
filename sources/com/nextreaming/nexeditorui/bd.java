package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
class bd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SKUDetails f4541a;
    final /* synthetic */ ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ba baVar, SKUDetails sKUDetails) {
        this.b = baVar;
        this.f4541a = sKUDetails;
    }

    @Override // java.lang.Runnable
    public void run() {
        af afVar;
        afVar = this.b.i;
        afVar.a(this.f4541a, R.id.buyintent);
    }
}
