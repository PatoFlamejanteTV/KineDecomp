package com.nexstreaming.kinemaster.support;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;

/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SupportInfoV4Fragment f21244a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SupportInfoV4Fragment supportInfoV4Fragment) {
        this.f21244a = supportInfoV4Fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        KMEvents.HELP_WEBSITE.logEvent("click");
        this.f21244a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/")));
    }
}
