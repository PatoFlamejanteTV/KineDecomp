package com.qq.e.comm.adevent;

/* loaded from: classes3.dex */
public class ADEvent {

    /* renamed from: a */
    private final int f24944a;

    /* renamed from: b */
    private final Object[] f24945b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f24944a = i;
        this.f24945b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f24945b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f24944a;
    }
}
