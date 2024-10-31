package com.nexstreaming.kinemaster.ui.a;

import android.widget.CompoundButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexDialog.java */
/* loaded from: classes.dex */
public class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f3651a = aVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2;
        onCheckedChangeListener = this.f3651a.v;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener2 = this.f3651a.v;
            onCheckedChangeListener2.onCheckedChanged(compoundButton, z);
        }
    }
}
