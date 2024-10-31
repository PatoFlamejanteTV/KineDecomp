package com.nexstreaming.app.general.util;

import com.nexstreaming.app.general.util.FileType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileType.java */
/* loaded from: classes.dex */
public class g extends FileType.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[][] f3228a;
    final /* synthetic */ FileType b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(FileType fileType, int[][] iArr) {
        super(null);
        this.b = fileType;
        this.f3228a = iArr;
    }

    @Override // com.nexstreaming.app.general.util.FileType.a
    boolean a(byte[] bArr) {
        for (int i = 0; i < this.f3228a.length; i++) {
            int[] iArr = this.f3228a[i];
            if (bArr.length >= iArr.length) {
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (iArr[i2] != -1 && bArr[i2] != ((byte) iArr[i2])) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
