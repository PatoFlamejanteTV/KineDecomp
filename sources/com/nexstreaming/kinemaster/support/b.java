package com.nexstreaming.kinemaster.support;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* compiled from: SupportInfoFragment.java */
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3631a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3631a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.kinemaster.com/")));
    }
}
