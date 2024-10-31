package com.nexstreaming.app.kinemasterfree.b.a;

import android.view.View;

/* compiled from: OnClickListener.java */
/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a */
    final InterfaceC0101a f19913a;

    /* renamed from: b */
    final int f19914b;

    /* compiled from: OnClickListener.java */
    /* renamed from: com.nexstreaming.app.kinemasterfree.b.a.a$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC0101a {
        void a(int i, View view);
    }

    public a(InterfaceC0101a interfaceC0101a, int i) {
        this.f19913a = interfaceC0101a;
        this.f19914b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f19913a.a(this.f19914b, view);
    }
}
