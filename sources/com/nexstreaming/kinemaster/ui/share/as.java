package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import com.nexstreaming.kinemaster.ui.share.aq;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareEventFragment.java */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aq f4303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar) {
        this.f4303a = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq.a aVar;
        aq.a aVar2;
        KMUsage.WeChat_Promotion_Button.logEvent("button", "share");
        aVar = this.f4303a.d;
        if (aVar != null) {
            aVar2 = this.f4303a.d;
            aVar2.d();
        }
    }
}
