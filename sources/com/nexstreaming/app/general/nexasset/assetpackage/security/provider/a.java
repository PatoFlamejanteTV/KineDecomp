package com.nexstreaming.app.general.nexasset.assetpackage.security.provider;

import org.keyczar.interfaces.KeyczarReader;

/* compiled from: BasicEncryptionProvider.java */
/* loaded from: classes2.dex */
public class a implements KeyczarReader {

    /* renamed from: a */
    final /* synthetic */ BasicEncryptionProvider f19549a;

    public a(BasicEncryptionProvider basicEncryptionProvider) {
        this.f19549a = basicEncryptionProvider;
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey(int i) {
        String a2;
        a2 = this.f19549a.a(i);
        return a2;
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getMetadata() {
        String a2;
        a2 = this.f19549a.a(0);
        return a2;
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey() {
        String a2;
        a2 = this.f19549a.a(1);
        return a2;
    }
}
