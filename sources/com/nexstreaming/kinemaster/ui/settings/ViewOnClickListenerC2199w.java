package com.nexstreaming.kinemaster.ui.settings;

import android.app.Activity;
import android.view.View;
import com.umeng.analytics.pro.k;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2199w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2199w(FragmentC2201x fragmentC2201x) {
        this.f23216a = fragmentC2201x;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity = this.f23216a.getActivity();
        if (activity == null || !(activity instanceof com.nextreaming.nexeditorui.I)) {
            return;
        }
        ((com.nextreaming.nexeditorui.I) this.f23216a.getActivity()).b(k.a.t);
    }
}
