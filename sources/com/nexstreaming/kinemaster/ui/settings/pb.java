package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
public class pb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f23178a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ tb f23179b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pb(tb tbVar, String str) {
        this.f23179b = tbVar;
        this.f23178a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f23179b.getActivity() == null || this.f23178a == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.f23178a));
        this.f23179b.startActivity(intent);
    }
}
