package com.google.android.gms.common.server.response;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class FastParser<T extends FastJsonResponse> {

    /* renamed from: a */
    private static final char[] f11210a = {'u', 'l', 'l'};

    /* renamed from: b */
    private static final char[] f11211b = {'r', 'u', 'e'};

    /* renamed from: c */
    private static final char[] f11212c = {'r', 'u', 'e', '\"'};

    /* renamed from: d */
    private static final char[] f11213d = {'a', 'l', 's', 'e'};

    /* renamed from: e */
    private static final char[] f11214e = {'a', 'l', 's', 'e', '\"'};

    /* renamed from: f */
    private static final char[] f11215f = {'\n'};

    /* renamed from: g */
    private static final a<Integer> f11216g = new com.google.android.gms.common.server.response.a();

    /* renamed from: h */
    private static final a<Long> f11217h = new b();
    private static final a<Float> i = new c();
    private static final a<Double> j = new d();
    private static final a<Boolean> k = new e();
    private static final a<String> l = new f();
    private static final a<BigInteger> m = new g();
    private static final a<BigDecimal> n = new h();
    private final char[] o = new char[1];
    private final char[] p = new char[32];
    private final char[] q = new char[1024];
    private final StringBuilder r = new StringBuilder(32);
    private final StringBuilder s = new StringBuilder(1024);
    private final Stack<Integer> t = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public interface a<O> {
    }
}
