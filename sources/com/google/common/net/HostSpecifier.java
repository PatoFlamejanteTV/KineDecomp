package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class HostSpecifier {

    /* renamed from: a */
    private final String f16011a;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostSpecifier) {
            return this.f16011a.equals(((HostSpecifier) obj).f16011a);
        }
        return false;
    }

    public int hashCode() {
        return this.f16011a.hashCode();
    }

    public String toString() {
        return this.f16011a;
    }
}
