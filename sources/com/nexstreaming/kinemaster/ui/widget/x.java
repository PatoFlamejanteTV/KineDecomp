package com.nexstreaming.kinemaster.ui.widget;

import android.database.DataSetObserver;

/* compiled from: WheelPicker.java */
/* loaded from: classes2.dex */
class x extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ WheelPicker f23893a;

    public x(WheelPicker wheelPicker) {
        this.f23893a = wheelPicker;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f23893a.a(false);
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f23893a.a(true);
    }
}
