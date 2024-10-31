package com.google.common.net;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import java.util.Collection;

/* compiled from: MediaType.java */
/* loaded from: classes2.dex */
class a implements Function<Collection<String>, ImmutableMultiset<String>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaType f2927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MediaType mediaType) {
        this.f2927a = mediaType;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImmutableMultiset<String> apply(Collection<String> collection) {
        return ImmutableMultiset.copyOf(collection);
    }
}
