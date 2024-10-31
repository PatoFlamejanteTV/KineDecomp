package com.squareup.okhttp.internal.framed;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: NameValueBlockReader.java */
/* loaded from: classes3.dex */
class v extends Inflater {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f25403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(w wVar) {
        this.f25403a = wVar;
    }

    @Override // java.util.zip.Inflater
    public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
        int inflate = super.inflate(bArr, i, i2);
        if (inflate != 0 || !needsDictionary()) {
            return inflate;
        }
        setDictionary(B.f25278a);
        return super.inflate(bArr, i, i2);
    }
}
