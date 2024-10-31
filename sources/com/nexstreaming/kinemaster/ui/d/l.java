package com.nexstreaming.kinemaster.ui.d;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: OptionGroupFragment.java */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ m f21556a;

    public l(m mVar) {
        this.f21556a = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f21556a.w.a()) {
            return;
        }
        this.f21556a.w.a(i);
        this.f21556a.a((f) this.f21556a.w.getItem(i));
    }
}
