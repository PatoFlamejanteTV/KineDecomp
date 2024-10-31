package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.sdk2.nexsns.Privacy;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class cc implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ShareSNSActivity shareSNSActivity) {
        this.f4341a = shareSNSActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        ShareSNSActivity shareSNSActivity = this.f4341a;
        list = this.f4341a.l;
        shareSNSActivity.q = (Privacy) list.get(i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f4341a.q = null;
    }
}
