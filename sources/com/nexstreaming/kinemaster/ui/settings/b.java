package com.nexstreaming.kinemaster.ui.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccountInfoFragment.java */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4251a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4251a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String packageName = this.f4251a.getActivity().getPackageName();
        try {
            this.f4251a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            this.f4251a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }
}
