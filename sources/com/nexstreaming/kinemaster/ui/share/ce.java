package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class ce implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(ShareSNSActivity shareSNSActivity) {
        this.f4343a = shareSNSActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        List list2;
        list = this.f4343a.o;
        if (list != null) {
            ShareSNSActivity shareSNSActivity = this.f4343a;
            list2 = this.f4343a.o;
            shareSNSActivity.p = (com.nexstreaming.sdk2.nexsns.ac) list2.get(i);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f4343a.p = null;
    }
}
