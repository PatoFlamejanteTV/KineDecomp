package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class Escapers {

    /* renamed from: a */
    private static final Escaper f15888a = new b();

    @Beta
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        private final Map<Character, String> f15889a;

        /* renamed from: b */
        private char f15890b;

        /* renamed from: c */
        private char f15891c;

        /* renamed from: d */
        private String f15892d;

        /* synthetic */ Builder(b bVar) {
            this();
        }

        private Builder() {
            this.f15889a = new HashMap();
            this.f15890b = (char) 0;
            this.f15891c = (char) 65535;
            this.f15892d = null;
        }

        @CanIgnoreReturnValue
        public Builder a(char c2, char c3) {
            this.f15890b = c2;
            this.f15891c = c3;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder a(@Nullable String str) {
            this.f15892d = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder a(char c2, String str) {
            Preconditions.a(str);
            this.f15889a.put(Character.valueOf(c2), str);
            return this;
        }

        public Escaper a() {
            return new c(this, this.f15889a, this.f15890b, this.f15891c);
        }
    }

    private Escapers() {
    }

    public static Builder a() {
        return new Builder(null);
    }
}
