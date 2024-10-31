package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class InternetDomainName {

    /* renamed from: a */
    private static final CharMatcher f16015a = CharMatcher.a(".。．｡");

    /* renamed from: b */
    private static final Splitter f16016b = Splitter.a('.');

    /* renamed from: c */
    private static final Joiner f16017c = Joiner.a('.');

    /* renamed from: d */
    private static final CharMatcher f16018d = CharMatcher.a("-_");

    /* renamed from: e */
    private static final CharMatcher f16019e = CharMatcher.i().b(f16018d);

    /* renamed from: f */
    private final String f16020f;

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.f16020f.equals(((InternetDomainName) obj).f16020f);
        }
        return false;
    }

    public int hashCode() {
        return this.f16020f.hashCode();
    }

    public String toString() {
        return this.f16020f;
    }
}
