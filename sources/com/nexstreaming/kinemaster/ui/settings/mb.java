package com.nexstreaming.kinemaster.ui.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Locale;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
class mb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ tb f23167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mb(tb tbVar) {
        this.f23167a = tbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (Locale.getDefault().getLanguage().equals("ko")) {
                this.f23167a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/privacy/kr")));
            } else {
                this.f23167a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/privacy/en")));
            }
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
