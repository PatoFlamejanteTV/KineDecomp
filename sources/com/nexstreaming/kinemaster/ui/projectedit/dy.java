package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes.dex */
class dy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3860a;
    final /* synthetic */ dt b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dt dtVar, int i) {
        this.b = dtVar;
        this.f3860a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        listView = this.b.b;
        listView.smoothScrollToPosition(this.f3860a);
    }
}
