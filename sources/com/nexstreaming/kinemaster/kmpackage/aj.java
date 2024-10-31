package com.nexstreaming.kinemaster.kmpackage;

import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMTPackage.java */
/* loaded from: classes.dex */
public class aj implements KeyczarReader {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ai f3436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.f3436a = aiVar;
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getMetadata() throws KeyczarException {
        return "{\"name\":\"\",\"purpose\":\"DECRYPT_AND_ENCRYPT\",\"type\":\"AES\",\"versions\":[{\"exportable\":false,\"status\":\"PRIMARY\",\"versionNumber\":1}],\"encrypted\":false}";
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey() throws KeyczarException {
        return null;
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey(int i) throws KeyczarException {
        return "{\"aesKeyString\":\"1kTba9wp8p0jkaWjkbqQaw\",\"hmacKey\":{\"hmacKeyString\":\"NQLKSNa3l_96SCI1-6FKfRl71DLz5Esomd3PpNK0M84\",\"size\":256},\"mode\":\"CBC\",\"size\":128}";
    }
}
