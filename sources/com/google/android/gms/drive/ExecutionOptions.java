package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class ExecutionOptions {

    /* renamed from: a, reason: collision with root package name */
    private final String f1058a;
    private final boolean b;
    private final int c;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f1059a = 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) obj;
        return zzw.a(this.f1058a, executionOptions.f1058a) && this.c == executionOptions.c && this.b == executionOptions.b;
    }

    public int hashCode() {
        return zzw.a(this.f1058a, Integer.valueOf(this.c), Boolean.valueOf(this.b));
    }
}
