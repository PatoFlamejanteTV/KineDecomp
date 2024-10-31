package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Locale;

/* compiled from: KineInfoFragment.java */
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f4270a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.f4270a = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            this.f4270a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/privacy/kr")));
        } else {
            this.f4270a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/privacy/en")));
        }
    }
}
