package com.nexstreaming.app.general.nexasset.assetpackage.security.provider;

import com.google.gson.Gson;
import java.util.HashSet;
import java.util.List;
import org.keyczar.Crypter;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;

/* loaded from: classes.dex */
public class BasicEncryptionProvider implements com.nexstreaming.app.general.nexasset.assetpackage.a.b {

    /* renamed from: a */
    private final int[] f19545a;

    /* renamed from: b */
    private final String[] f19546b;

    /* renamed from: c */
    private KeyczarReader f19547c = new a(this);

    /* loaded from: classes2.dex */
    private class ProviderSpecificDataJSON {

        /* renamed from: f */
        List<String> f19548f;
        int v;

        private ProviderSpecificDataJSON() {
        }
    }

    public BasicEncryptionProvider(int[] iArr, String[] strArr) {
        this.f19545a = iArr;
        this.f19546b = strArr;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.a.b
    public String getProviderId() {
        char[] cArr = new char[this.f19545a.length];
        int i = 0;
        while (true) {
            int[] iArr = this.f19545a;
            if (i >= iArr.length) {
                return new String(cArr);
            }
            cArr[i] = (char) (iArr[i] ^ 90);
            i++;
        }
    }

    private int a(String str, int i, int i2) {
        int i3;
        int i4;
        int length = str.length();
        int i5 = 0;
        while (i < i2 && i < length) {
            char charAt = str.charAt(i);
            i5 *= 16;
            if (charAt < '0' || charAt > '9') {
                if (charAt < 'a' || charAt > 'f') {
                    if (charAt >= 'A' && charAt <= 'F') {
                        i3 = charAt - 'A';
                    }
                    i++;
                } else {
                    i3 = charAt - 'a';
                }
                i4 = i3 + 10;
            } else {
                i4 = charAt - '0';
            }
            i5 += i4;
            i++;
        }
        return i5;
    }

    public String a(int i) {
        String str = this.f19546b[i];
        int length = str.length();
        int a2 = a(str, 0, 2) ^ 32;
        byte[] bArr = new byte[(length - 2) / 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            byte a3 = (byte) a(str, i3 + 2, i3 + 4);
            bArr[i2] = (byte) ((((a3 << 4) & 240) | ((a3 >> 4) & 15)) ^ a2);
        }
        return new String(bArr);
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.a.b
    public com.nexstreaming.app.general.nexasset.assetpackage.a.a a(String str) {
        ProviderSpecificDataJSON providerSpecificDataJSON = (ProviderSpecificDataJSON) new Gson().fromJson(str, ProviderSpecificDataJSON.class);
        HashSet hashSet = new HashSet();
        hashSet.addAll(providerSpecificDataJSON.f19548f);
        int i = providerSpecificDataJSON.v;
        try {
            return new b(this, hashSet, new Crypter(this.f19547c));
        } catch (KeyczarException unused) {
            throw new IllegalStateException();
        }
    }
}
