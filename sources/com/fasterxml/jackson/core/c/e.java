package com.fasterxml.jackson.core.c;

/* compiled from: Name2.java */
/* loaded from: classes.dex */
public final class e extends c {
    final int c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, int i, int i2, int i3) {
        super(str, i);
        this.c = i2;
        this.d = i3;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int i, int i2) {
        return i == this.c && i2 == this.d;
    }

    @Override // com.fasterxml.jackson.core.c.c
    public boolean a(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.c && iArr[1] == this.d;
    }
}
