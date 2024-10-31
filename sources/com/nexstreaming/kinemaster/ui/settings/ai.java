package com.nexstreaming.kinemaster.ui.settings;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
public final class ai implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f4238a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(int[] iArr, Context context) {
        this.f4238a = iArr;
        this.b = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                return true;
            case 1:
                if (this.f4238a[0] <= 0) {
                    x.d(this.b);
                    return true;
                }
                this.f4238a[0] = r2[0] - 1;
                return true;
            default:
                return false;
        }
    }
}
