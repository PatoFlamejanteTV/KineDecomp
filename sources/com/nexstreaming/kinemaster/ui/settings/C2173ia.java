package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.ui.settings.C2202xa;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ia, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2173ia implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2202xa.b f23151a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23152b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2173ia(C2202xa c2202xa, C2202xa.b bVar) {
        this.f23152b = c2202xa;
        this.f23151a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f23151a.a(i);
        this.f23151a.notifyDataSetInvalidated();
        C2202xa.a aVar = (C2202xa.a) this.f23151a.getItem(i);
        this.f23152b.r = aVar.f23236b;
    }
}
