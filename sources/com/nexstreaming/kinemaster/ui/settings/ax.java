package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.kinemaster.ui.settings.aw;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes.dex */
class ax implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aw f4249a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.f4249a = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aw.a aVar;
        aw.a aVar2;
        aVar = this.f4249a.f;
        if (aVar != null) {
            aVar2 = this.f4249a.f;
            aVar2.w();
        }
    }
}
