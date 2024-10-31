package com.nexstreaming.kinemaster.support;

import android.content.Intent;
import android.view.View;

/* compiled from: SupportInfoFragment.java */
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3632a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3632a.startActivity(new Intent(this.f3632a.getActivity(), (Class<?>) SupportInputActivity.class));
    }
}
