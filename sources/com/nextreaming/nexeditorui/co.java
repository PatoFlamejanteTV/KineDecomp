package com.nextreaming.nexeditorui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
public final class co implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f4579a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(int[] iArr, Context context) {
        this.f4579a = iArr;
        this.b = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                return true;
            case 1:
                if (this.f4579a[0] <= 0) {
                    cl.c(this.b);
                    return true;
                }
                this.f4579a[0] = r2[0] - 1;
                return true;
            default:
                return false;
        }
    }
}
