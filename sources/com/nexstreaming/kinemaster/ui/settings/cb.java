package com.nexstreaming.kinemaster.ui.settings;

import android.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
class cb implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean f23129a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f23130b = 0;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23131c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(SettingsActivity settingsActivity) {
        this.f23131c = settingsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean L;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f23129a = true;
            this.f23130b = 0;
        } else if (actionMasked != 1 && actionMasked != 3) {
            if (actionMasked == 6 && this.f23129a && motionEvent.getActionIndex() == 1) {
                L = this.f23131c.L();
                if (L) {
                    this.f23130b++;
                    if (this.f23130b >= 3) {
                        FragmentTransaction beginTransaction = this.f23131c.getFragmentManager().beginTransaction();
                        beginTransaction.replace(R.id.container, new Aa());
                        beginTransaction.addToBackStack("");
                        beginTransaction.commit();
                        this.f23129a = false;
                    }
                }
            }
        } else {
            this.f23129a = false;
        }
        return true;
    }
}
