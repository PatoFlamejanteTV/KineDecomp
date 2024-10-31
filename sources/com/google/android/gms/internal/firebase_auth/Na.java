package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Na {
    public abstract int a(int i, byte[] bArr, int i2, int i3);

    public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

    public final boolean a(byte[] bArr, int i, int i2) {
        return a(0, bArr, i, i2) == 0;
    }

    public abstract String b(byte[] bArr, int i, int i2) throws zzgc;
}
