package com.nexstreaming.kinemaster.ui.widget;

import com.nexstreaming.kinemaster.ui.widget.C;

/* compiled from: WheelPicker.java */
/* loaded from: classes2.dex */
class w implements C.a {

    /* renamed from: a */
    final /* synthetic */ WheelPicker f23892a;

    public w(WheelPicker wheelPicker) {
        this.f23892a = wheelPicker;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.C.a
    public void a(int i) {
        int i2;
        int i3;
        C c2;
        C c3;
        this.f23892a.a(i);
        int height = this.f23892a.getHeight();
        i2 = this.f23892a.n;
        if (i2 > height) {
            this.f23892a.n = height;
            c3 = this.f23892a.f23846b;
            c3.b();
            return;
        }
        i3 = this.f23892a.n;
        int i4 = -height;
        if (i3 < i4) {
            this.f23892a.n = i4;
            c2 = this.f23892a.f23846b;
            c2.b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.C.a
    public void b() {
        this.f23892a.o = true;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.C.a
    public void c() {
        boolean z;
        z = this.f23892a.o;
        if (z) {
            this.f23892a.o = false;
        }
        this.f23892a.n = 0;
        this.f23892a.invalidate();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.C.a
    public void a() {
        int i;
        C c2;
        int i2;
        i = this.f23892a.n;
        if (Math.abs(i) > 1) {
            c2 = this.f23892a.f23846b;
            i2 = this.f23892a.n;
            c2.a(i2, 0);
        }
    }
}
