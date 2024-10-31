package com.nexstreaming.kinemaster.support;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* compiled from: SupportInputActivity.java */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ SupportInputActivity f21254a;

    public q(SupportInputActivity supportInputActivity) {
        this.f21254a = supportInputActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t tVar;
        t tVar2;
        t tVar3;
        tVar = this.f21254a.f21233e;
        if (tVar != null) {
            tVar2 = this.f21254a.f21233e;
            r item = tVar2.getItem(i);
            if (item != null) {
                List<r> list = item.f21259e;
                if (list != null && list.size() > 0) {
                    tVar3 = this.f21254a.f21233e;
                    tVar3.a(item);
                } else {
                    this.f21254a.b(item);
                }
                this.f21254a.c(item);
            }
        }
    }
}
