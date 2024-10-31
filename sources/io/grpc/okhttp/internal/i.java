package io.grpc.okhttp.internal;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Util.java */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a */
    public static final byte[] f27959a = new byte[0];

    /* renamed from: b */
    public static final String[] f27960b = new String[0];

    /* renamed from: c */
    public static final Charset f27961c = Charset.forName("UTF-8");

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        List a2 = a(tArr, tArr2);
        return (T[]) a2.toArray((Object[]) Array.newInstance((Class<?>) cls, a2.size()));
    }

    private static <T> List<T> a(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            int length = tArr2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    T t2 = tArr2[i];
                    if (t.equals(t2)) {
                        arrayList.add(t2);
                        break;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }
}
