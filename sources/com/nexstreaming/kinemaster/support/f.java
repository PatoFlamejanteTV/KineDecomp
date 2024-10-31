package com.nexstreaming.kinemaster.support;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportInputActivity.java */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SupportInputActivity f3635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SupportInputActivity supportInputActivity) {
        this.f3635a = supportInputActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.f3635a.e;
        if (hVar != null) {
            hVar2 = this.f3635a.e;
            g item = hVar2.getItem(i);
            if (item != null) {
                if (item.e == null || item.e.size() <= 0) {
                    this.f3635a.b(item);
                } else {
                    hVar3 = this.f3635a.e;
                    hVar3.a(item);
                }
                this.f3635a.a(item);
            }
        }
    }
}
