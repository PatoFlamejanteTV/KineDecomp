package com.nextreaming.nexeditorui;

import android.view.View;

/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
class bx implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorHelp f4560a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(NexEditorHelp nexEditorHelp) {
        this.f4560a = nexEditorHelp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4560a.finish();
    }
}
