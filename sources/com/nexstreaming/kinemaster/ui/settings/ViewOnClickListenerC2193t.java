package com.nexstreaming.kinemaster.ui.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.app.general.iab.IABManager;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2193t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f23196a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23197b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2193t(FragmentC2201x fragmentC2201x, IABManager iABManager) {
        this.f23197b = fragmentC2201x;
        this.f23196a = iABManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String packageName = this.f23197b.getActivity().getPackageName();
        try {
            if (this.f23196a.q() != null) {
                str = String.format("https://play.google.com/store/account/subscriptions?sku=%s&package=%s", this.f23196a.q().d(), packageName);
            } else {
                str = "market://details?id=" + packageName;
            }
            this.f23197b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            this.f23197b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }
}
