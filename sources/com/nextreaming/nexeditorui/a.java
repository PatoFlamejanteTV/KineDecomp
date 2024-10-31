package com.nextreaming.nexeditorui;

import android.view.View;

/* compiled from: BailActivity.java */
/* loaded from: classes.dex */
class a implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BailActivity f4504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BailActivity bailActivity) {
        this.f4504a = bailActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        cl.a(this.f4504a);
        return true;
    }
}
