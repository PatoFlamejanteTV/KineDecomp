package com.nexstreaming.kinemaster.ui.previewplay;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f21731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PreviewPlayActivity previewPlayActivity) {
        this.f21731a = previewPlayActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        z = this.f21731a.X;
        if (z) {
            return false;
        }
        this.f21731a.S();
        return true;
    }
}
