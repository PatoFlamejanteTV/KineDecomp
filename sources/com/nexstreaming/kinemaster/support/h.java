package com.nexstreaming.kinemaster.support;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.I;

/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
class h implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SupportInfoV4Fragment f21245a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SupportInfoV4Fragment supportInfoV4Fragment) {
        this.f21245a = supportInfoV4Fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        KMEvents.HELP_EMAIL_SUPPORT.logEvent("click");
        Intent intent = new Intent(this.f21245a.getActivity(), (Class<?>) SupportInputActivity.class);
        intent.putExtra("PT", ((I) this.f21245a.getActivity()).B().getId());
        this.f21245a.startActivity(intent);
    }
}
