package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3902a;
    final /* synthetic */ fk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(fk fkVar, String str) {
        this.b = fkVar;
        this.f3902a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        KineMasterApplication.a().c().a(new File(this.f3902a)).onComplete(new fm(this));
    }
}
