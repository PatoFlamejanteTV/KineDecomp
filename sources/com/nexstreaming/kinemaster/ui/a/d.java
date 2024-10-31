package com.nexstreaming.kinemaster.ui.a;

import android.widget.CompoundButton;

/* compiled from: NexDialog.java */
/* loaded from: classes.dex */
public class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ e f21308a;

    public d(e eVar) {
        this.f21308a = eVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2;
        onCheckedChangeListener = this.f21308a.w;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener2 = this.f21308a.w;
            onCheckedChangeListener2.onCheckedChanged(compoundButton, z);
        }
    }
}
