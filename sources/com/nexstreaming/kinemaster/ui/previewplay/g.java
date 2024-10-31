package com.nexstreaming.kinemaster.ui.previewplay;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class g implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f3726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PreviewPlayActivity previewPlayActivity) {
        this.f3726a = previewPlayActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getActionMasked() == 0) {
            z = this.f3726a.r;
            if (!z) {
                this.f3726a.e();
                return true;
            }
        }
        return false;
    }
}
