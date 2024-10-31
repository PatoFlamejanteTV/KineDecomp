package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Locale;

/* compiled from: KineInfoFragment.java */
/* loaded from: classes2.dex */
class S implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ U f23080a;

    public S(U u) {
        this.f23080a = u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            this.f23080a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/privacy/kr")));
        } else {
            this.f23080a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/privacy/en")));
        }
    }
}
