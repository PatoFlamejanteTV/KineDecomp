package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
final class e implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21439a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f21439a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        x xVar6;
        x xVar7;
        boolean b2;
        boolean C;
        u item;
        x xVar8;
        xVar = this.f21439a.o;
        if (xVar == null || xVar.a() != i) {
            xVar2 = this.f21439a.o;
            if (xVar2 == null || xVar2.b() != i) {
                this.f21439a.G();
                xVar3 = this.f21439a.o;
                if (xVar3 != null) {
                    xVar3.c(i);
                }
                xVar4 = this.f21439a.o;
                if (xVar4 != null) {
                    xVar4.b(i);
                }
                xVar5 = this.f21439a.o;
                if (xVar5 != null) {
                    xVar5.a(i);
                }
            } else {
                xVar6 = this.f21439a.o;
                if (xVar6 != null) {
                    xVar6.a(i);
                }
            }
        } else {
            xVar8 = this.f21439a.o;
            if (xVar8 != null) {
                xVar8.a(i);
            }
        }
        xVar7 = this.f21439a.o;
        String g2 = (xVar7 == null || (item = xVar7.getItem(i)) == null) ? null : item.g();
        if (TextUtils.isEmpty(g2)) {
            return;
        }
        b2 = kotlin.text.v.b(g2, "Premium", true);
        if (b2) {
            C = this.f21439a.C();
            if (C) {
                return;
            }
            this.f21439a.F();
        }
    }
}
