package com.bumptech.glide.load.engine.b;

import android.support.v4.util.Pools;
import com.bumptech.glide.g.a.d;
import com.bumptech.glide.g.n;
import java.security.MessageDigest;

/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    private final com.bumptech.glide.g.i<com.bumptech.glide.load.c, String> f8864a = new com.bumptech.glide.g.i<>(1000);

    /* renamed from: b */
    private final Pools.Pool<a> f8865b = com.bumptech.glide.g.a.d.a(10, new k(this));

    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: classes.dex */
    public static final class a implements d.c {

        /* renamed from: a */
        final MessageDigest f8866a;

        /* renamed from: b */
        private final com.bumptech.glide.g.a.g f8867b = com.bumptech.glide.g.a.g.a();

        public a(MessageDigest messageDigest) {
            this.f8866a = messageDigest;
        }

        @Override // com.bumptech.glide.g.a.d.c
        public com.bumptech.glide.g.a.g d() {
            return this.f8867b;
        }
    }

    private String b(com.bumptech.glide.load.c cVar) {
        a acquire = this.f8865b.acquire();
        com.bumptech.glide.g.l.a(acquire);
        a aVar = acquire;
        try {
            cVar.a(aVar.f8866a);
            return n.a(aVar.f8866a.digest());
        } finally {
            this.f8865b.release(aVar);
        }
    }

    public String a(com.bumptech.glide.load.c cVar) {
        String a2;
        synchronized (this.f8864a) {
            a2 = this.f8864a.a((com.bumptech.glide.g.i<com.bumptech.glide.load.c, String>) cVar);
        }
        if (a2 == null) {
            a2 = b(cVar);
        }
        synchronized (this.f8864a) {
            this.f8864a.b(cVar, a2);
        }
        return a2;
    }
}
