package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
public class sb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ tb f23195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sb(tb tbVar) {
        this.f23195a = tbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        tb.a aVar;
        tb.a aVar2;
        HashMap hashMap = new HashMap();
        str = this.f23195a.f23203d;
        if (str.equalsIgnoreCase("share")) {
            hashMap.put("button", "Skip");
        } else {
            hashMap.put("button", "Close");
        }
        KMEvents.SUBSCRIPTION_CLICK_BUTTON.logEvent(hashMap);
        aVar = this.f23195a.j;
        if (aVar != null) {
            this.f23195a.J.a(false, (Purchase) null, "cancel subscription");
            aVar2 = this.f23195a.j;
            aVar2.a(this.f23195a.z());
        }
    }
}
