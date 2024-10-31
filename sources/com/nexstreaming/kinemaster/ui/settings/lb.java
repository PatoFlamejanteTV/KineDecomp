package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Locale;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
class lb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ tb f23164a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lb(tb tbVar) {
        this.f23164a = tbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            this.f23164a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.kinemaster.com/hc/ko/articles/206376422-Terms-of-Service")));
        } else {
            this.f23164a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.kinemaster.com/hc/en-us/articles/206376422-Terms-of-Service")));
        }
    }
}
