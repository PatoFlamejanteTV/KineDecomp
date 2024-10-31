package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccountInfoFragment.java */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4255a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, String str) {
        this.b = aVar;
        this.f4255a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.getActivity() != null && this.f4255a != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f4255a));
            this.b.startActivity(intent);
        }
    }
}
