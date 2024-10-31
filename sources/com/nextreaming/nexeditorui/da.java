package com.nextreaming.nexeditorui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
public class Da implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f24010a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f24011b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(int[] iArr, Context context) {
        this.f24010a = iArr;
        this.f24011b = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return false;
            }
            int[] iArr = this.f24010a;
            if (iArr[0] <= 0) {
                La.c(this.f24011b);
            } else {
                iArr[0] = iArr[0] - 1;
            }
        }
        return true;
    }
}
