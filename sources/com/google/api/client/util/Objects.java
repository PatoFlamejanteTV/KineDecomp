package com.google.api.client.util;

import com.google.api.client.repackaged.com.google.common.base.Objects;

/* loaded from: classes.dex */
public final class Objects {
    public static boolean a(Object obj, Object obj2) {
        return com.google.api.client.repackaged.com.google.common.base.Objects.a(obj, obj2);
    }

    public static ToStringHelper a(Object obj) {
        return new ToStringHelper(com.google.api.client.repackaged.com.google.common.base.Objects.a(obj));
    }

    /* loaded from: classes.dex */
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        private final Objects.ToStringHelper f2545a;

        ToStringHelper(Objects.ToStringHelper toStringHelper) {
            this.f2545a = toStringHelper;
        }

        public ToStringHelper a(String str, Object obj) {
            this.f2545a.a(str, obj);
            return this;
        }

        public String toString() {
            return this.f2545a.toString();
        }
    }

    private Objects() {
    }
}
