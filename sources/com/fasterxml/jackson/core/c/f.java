package com.fasterxml.jackson.core.c;

/* compiled from: Name3.java */
/* loaded from: classes.dex */
public final class f extends c {
    final int c;
    final int d;
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, int i, int i2, int i3, int i4) {
        super(str, i);
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int i, int i2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int[] iArr, int i) {
        return i == 3 && iArr[0] == this.c && iArr[1] == this.d && iArr[2] == this.e;
    }
}
