package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.g.a.d;
import com.bumptech.glide.load.engine.b.l;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class k implements d.a<l.a> {

    /* renamed from: a */
    final /* synthetic */ l f8863a;

    public k(l lVar) {
        this.f8863a = lVar;
    }

    @Override // com.bumptech.glide.g.a.d.a
    public l.a create() {
        try {
            return new l.a(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
