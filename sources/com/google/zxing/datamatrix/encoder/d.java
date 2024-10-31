package com.google.zxing.datamatrix.encoder;

/* compiled from: DataMatrixSymbolInfo144.java */
/* loaded from: classes2.dex */
final class d extends SymbolInfo {
    public d() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int a(int i) {
        return i <= 8 ? 156 : 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int c() {
        return 10;
    }
}
