package com.google.common.net;

import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class HostSpecifier {

    /* renamed from: a, reason: collision with root package name */
    private final String f2923a;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostSpecifier) {
            return this.f2923a.equals(((HostSpecifier) obj).f2923a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2923a.hashCode();
    }

    public String toString() {
        return this.f2923a;
    }
}
