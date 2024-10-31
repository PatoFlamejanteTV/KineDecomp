package com.fasterxml.jackson.core.c;

/* compiled from: Name1.java */
/* loaded from: classes.dex */
public final class d extends c {
    static final d c = new d("", 0, 0);
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, int i, int i2) {
        super(str, i);
        this.d = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b() {
        return c;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int i) {
        return i == this.d;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int i, int i2) {
        return i == this.d && i2 == 0;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.d;
    }
}
