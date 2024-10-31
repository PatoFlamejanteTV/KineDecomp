package com.nexstreaming.app.general.nexasset.assetpackage.security.provider;

import com.nexstreaming.app.general.util.H;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import org.keyczar.Crypter;
import org.keyczar.exceptions.KeyczarException;

/* compiled from: BasicEncryptionProvider.java */
/* loaded from: classes2.dex */
class b implements com.nexstreaming.app.general.nexasset.assetpackage.a.a {

    /* renamed from: a, reason: collision with root package name */
    ByteArrayOutputStream f19550a = new ByteArrayOutputStream();

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Set f19551b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Crypter f19552c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ BasicEncryptionProvider f19553d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BasicEncryptionProvider basicEncryptionProvider, Set set, Crypter crypter) {
        this.f19553d = basicEncryptionProvider;
        this.f19551b = set;
        this.f19552c = crypter;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.a.a
    public InputStream a(InputStream inputStream, String str) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        if (!this.f19551b.contains(str)) {
            return inputStream;
        }
        synchronized (this) {
            this.f19550a.reset();
            H.a(inputStream, this.f19550a);
            inputStream.close();
            try {
                byteArrayInputStream = new ByteArrayInputStream(this.f19552c.decrypt(this.f19550a.toByteArray()));
            } catch (KeyczarException e2) {
                e2.printStackTrace();
                throw new IllegalStateException();
            }
        }
        return byteArrayInputStream;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.a.a
    public boolean a(String str) {
        return !this.f19551b.contains(str);
    }
}
