package com.nexstreaming.kinemaster.codeccolorformat;

import java.util.Vector;

/* compiled from: ColorFormatChecker.java */
/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: a */
    final /* synthetic */ ColorFormatChecker f20154a;

    public c(ColorFormatChecker colorFormatChecker) {
        this.f20154a = colorFormatChecker;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i, long j) {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, int i, int i2, long j) {
        Vector vector;
        Vector vector2;
        vector = this.f20154a.f20150h;
        if (vector.size() > 0) {
            return true;
        }
        vector2 = this.f20154a.f20150h;
        vector2.add(bArr);
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, byte[] bArr2) {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i) {
        if (i == 4) {
            this.f20154a.f20147e = true;
        }
        return true;
    }
}
