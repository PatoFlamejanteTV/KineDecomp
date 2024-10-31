package com.nexstreaming.kinemaster.help;

import android.app.Activity;
import android.content.Intent;
import android.widget.GridView;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3400a;
    final /* synthetic */ Intent b;
    final /* synthetic */ HelpActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HelpActivity helpActivity, int i, Intent intent) {
        this.c = helpActivity;
        this.f3400a = i;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        g gVar;
        g gVar2;
        Activity D;
        GridView gridView2;
        g gVar3;
        gridView = this.c.j;
        int i = this.f3400a;
        gVar = this.c.i;
        gridView.performItemClick(null, i, gVar.getItemId(this.f3400a));
        int intExtra = this.b.getIntExtra("DEPTH_SECOND", 0);
        if (intExtra != 0) {
            gVar2 = this.c.h;
            D = this.c.D();
            int a2 = gVar2.a(intExtra, D);
            gridView2 = this.c.j;
            gVar3 = this.c.i;
            gridView2.performItemClick(null, a2, gVar3.getItemId(a2));
        }
    }
}
