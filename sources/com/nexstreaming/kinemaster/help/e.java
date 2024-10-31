package com.nexstreaming.kinemaster.help;

import android.app.Activity;
import android.content.Intent;
import android.widget.GridView;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f20407a;

    /* renamed from: b */
    final /* synthetic */ Intent f20408b;

    /* renamed from: c */
    final /* synthetic */ HelpActivity f20409c;

    public e(HelpActivity helpActivity, int i, Intent intent) {
        this.f20409c = helpActivity;
        this.f20407a = i;
        this.f20408b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        g gVar;
        g gVar2;
        Activity u;
        GridView gridView2;
        g gVar3;
        gridView = this.f20409c.P;
        int i = this.f20407a;
        gVar = this.f20409c.O;
        gridView.performItemClick(null, i, gVar.getItemId(this.f20407a));
        int intExtra = this.f20408b.getIntExtra("DEPTH_SECOND", 0);
        if (intExtra != 0) {
            gVar2 = this.f20409c.N;
            u = this.f20409c.u();
            int a2 = gVar2.a(intExtra, u);
            gridView2 = this.f20409c.P;
            gVar3 = this.f20409c.O;
            gridView2.performItemClick(null, a2, gVar3.getItemId(a2));
        }
    }
}
