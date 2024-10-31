package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import com.nexstreaming.kinemaster.ui.share.aq;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareEventFragment.java */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aq f4302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.f4302a = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq.a aVar;
        aq.a aVar2;
        KMUsage.WeChat_Promotion_Button.logEvent("button", "later");
        aVar = this.f4302a.d;
        if (aVar != null) {
            aVar2 = this.f4302a.d;
            aVar2.c();
        }
    }
}
