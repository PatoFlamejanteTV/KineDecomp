package com.google.api.client.auth.openidconnect;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.util.Collection;
import java.util.Collections;

@Beta
/* loaded from: classes2.dex */
public class IdTokenVerifier {

    /* renamed from: a */
    private final Clock f14625a;

    /* renamed from: b */
    private final long f14626b;

    /* renamed from: c */
    private final Collection<String> f14627c;

    /* renamed from: d */
    private final Collection<String> f14628d;

    @Beta
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        Clock f14629a = Clock.f14923a;

        /* renamed from: b */
        long f14630b = 300;

        /* renamed from: c */
        Collection<String> f14631c;

        /* renamed from: d */
        Collection<String> f14632d;
    }

    public IdTokenVerifier() {
        this(new Builder());
    }

    protected IdTokenVerifier(Builder builder) {
        this.f14625a = builder.f14629a;
        this.f14626b = builder.f14630b;
        Collection<String> collection = builder.f14631c;
        this.f14627c = collection == null ? null : Collections.unmodifiableCollection(collection);
        Collection<String> collection2 = builder.f14632d;
        this.f14628d = collection2 != null ? Collections.unmodifiableCollection(collection2) : null;
    }
}
