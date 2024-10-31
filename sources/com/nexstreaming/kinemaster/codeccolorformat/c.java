package com.nexstreaming.kinemaster.codeccolorformat;

import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorFormatChecker.java */
/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorFormatChecker f3289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ColorFormatChecker colorFormatChecker) {
        this.f3289a = colorFormatChecker;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i, long j) {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, int i, int i2, long j) {
        Vector vector;
        Vector vector2;
        vector = this.f3289a.h;
        if (vector.size() <= 0) {
            vector2 = this.f3289a.h;
            vector2.add(bArr);
            return true;
        }
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, byte[] bArr2) {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i) {
        if (i == 4) {
            this.f3289a.e = true;
        }
        return true;
    }
}
