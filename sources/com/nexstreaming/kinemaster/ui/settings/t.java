package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Locale;

/* compiled from: KineInfoFragment.java */
/* loaded from: classes2.dex */
class T implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ U f23081a;

    public T(U u) {
        this.f23081a = u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            this.f23081a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.kinemaster.com/hc/ko/articles/206376422-Terms-of-Service")));
        } else {
            this.f23081a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.kinemaster.com/hc/en-us/articles/206376422-Terms-of-Service")));
        }
    }
}
