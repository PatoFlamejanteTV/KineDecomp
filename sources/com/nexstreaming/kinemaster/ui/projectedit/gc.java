package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes2.dex */
class Gc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f21872a;

    /* renamed from: b */
    final /* synthetic */ Jc f21873b;

    public Gc(Jc jc, int i) {
        this.f21873b = jc;
        this.f21872a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        listView = this.f21873b.l;
        listView.smoothScrollToPosition(this.f21872a);
    }
}
