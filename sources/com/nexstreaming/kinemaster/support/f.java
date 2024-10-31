package com.nexstreaming.kinemaster.support;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SupportInfoV4Fragment f21243a;

    public f(SupportInfoV4Fragment supportInfoV4Fragment) {
        this.f21243a = supportInfoV4Fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (c.d.b.m.e.f3850a.a()) {
            this.f21243a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://mp.weixin.qq.com/s/XcztPLl565Tw_aMPTIKENA")));
            KMEvents.HELP_TUTORIAL_VIDEO.logEvent("click");
            return;
        }
        KMEvents.HELP_HELP.logEvent("click");
        Uri parse = Uri.parse("https://support.kinemaster.com");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(805306368);
        intent.setData(parse);
        if (!c.d.b.m.i.f(this.f21243a.getActivity())) {
            e.a aVar = new e.a(this.f21243a.getActivity());
            aVar.c(R.string.theme_download_server_connection_error);
            aVar.a(R.string.button_cancel, new e(this));
            aVar.c(R.string.retry, new d(this, intent));
            aVar.a().show();
            return;
        }
        this.f21243a.startActivity(intent);
    }
}
