package com.fasterxml.jackson.core.c;

/* compiled from: NameN.java */
/* loaded from: classes.dex */
public final class g extends c {
    final int[] c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str, int i, int[] iArr, int i2) {
        super(str, i);
        if (i2 < 3) {
            throw new IllegalArgumentException("Qlen must >= 3");
        }
        this.c = iArr;
        this.d = i2;
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
        if (i != this.d) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != this.c[i2]) {
                return false;
            }
        }
        return true;
    }
}
