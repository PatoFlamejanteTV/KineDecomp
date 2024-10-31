package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.iab.IABHelper;

/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f4517a;
    final /* synthetic */ int b;
    final /* synthetic */ ah c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, boolean z, int i) {
        this.c = ahVar;
        this.f4517a = z;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        IABHelper.e eVar;
        IABHelper.e eVar2;
        this.c.f4516a.P();
        if (this.f4517a) {
            this.c.f4516a.u();
        }
        eVar = this.c.f4516a.b;
        if (eVar != null) {
            eVar2 = this.c.f4516a.b;
            eVar2.a(this.f4517a, this.b);
        }
    }
}
