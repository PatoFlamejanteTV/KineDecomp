package com.nexstreaming.app.general.util;

import com.nexstreaming.app.general.util.FileType;

/* compiled from: FileType.java */
/* renamed from: com.nexstreaming.app.general.util.k */
/* loaded from: classes2.dex */
public class C1707k extends FileType.a {

    /* renamed from: a */
    final /* synthetic */ int[][] f19870a;

    /* renamed from: b */
    final /* synthetic */ FileType f19871b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1707k(FileType fileType, int[][] iArr) {
        super(null);
        this.f19871b = fileType;
        this.f19870a = iArr;
    }

    @Override // com.nexstreaming.app.general.util.FileType.a
    boolean a(byte[] bArr) {
        int i = 0;
        while (true) {
            int[][] iArr = this.f19870a;
            if (i >= iArr.length) {
                return false;
            }
            int[] iArr2 = iArr[i];
            if (bArr.length >= iArr2.length) {
                for (int i2 = 0; i2 < iArr2.length; i2++) {
                    if (iArr2[i2] != -1 && bArr[i2] != ((byte) iArr2[i2])) {
                        break;
                    }
                }
                return true;
            }
            i++;
        }
    }
}
