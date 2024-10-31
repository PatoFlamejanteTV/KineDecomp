package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2195u implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f23208a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23209b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2195u(FragmentC2201x fragmentC2201x, String str) {
        this.f23209b = fragmentC2201x;
        this.f23208a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f23209b.getActivity() == null || this.f23208a == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.f23208a));
        this.f23209b.startActivity(intent);
    }
}
