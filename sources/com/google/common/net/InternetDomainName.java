package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class InternetDomainName {

    /* renamed from: a, reason: collision with root package name */
    private static final CharMatcher f2925a = CharMatcher.a((CharSequence) ".。．｡");
    private static final Splitter b = Splitter.a('.');
    private static final Joiner c = Joiner.a('.');
    private static final CharMatcher e = CharMatcher.a((CharSequence) "-_");
    private static final CharMatcher f = CharMatcher.f.b(e);
    private final String d;

    public String toString() {
        return Objects.a(this).a("name", this.d).toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.d.equals(((InternetDomainName) obj).d);
        }
        return false;
    }

    public int hashCode() {
        return this.d.hashCode();
    }
}
