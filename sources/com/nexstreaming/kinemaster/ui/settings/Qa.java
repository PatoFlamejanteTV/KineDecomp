package com.nexstreaming.kinemaster.ui.settings;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public class Qa implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f23076a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f23077b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qa(int[] iArr, Context context) {
        this.f23076a = iArr;
        this.f23077b = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return false;
            }
            int[] iArr = this.f23076a;
            if (iArr[0] <= 0) {
                Ua.e(this.f23077b);
            } else {
                iArr[0] = iArr[0] - 1;
            }
        }
        return true;
    }
}
