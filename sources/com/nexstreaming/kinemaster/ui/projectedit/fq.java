package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3907a;
    final /* synthetic */ fp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(fp fpVar, String str) {
        this.b = fpVar;
        this.f3907a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        KineMasterApplication.a().c().a(new File(this.f3907a)).onComplete(new fr(this));
    }
}
