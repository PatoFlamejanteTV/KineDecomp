package com.nextreaming.nexeditorui.newproject.b;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar) {
        this.f4675a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4675a.getFragmentManager().popBackStackImmediate();
    }
}
