package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class ArrayBasedEscaperMap {

    /* renamed from: a */
    private static final char[][] f15877a = (char[][]) Array.newInstance((Class<?>) char.class, 0, 0);

    /* renamed from: b */
    private final char[][] f15878b;

    private ArrayBasedEscaperMap(char[][] cArr) {
        this.f15878b = cArr;
    }

    public static ArrayBasedEscaperMap a(Map<Character, String> map) {
        return new ArrayBasedEscaperMap(b(map));
    }

    @VisibleForTesting
    static char[][] b(Map<Character, String> map) {
        Preconditions.a(map);
        if (map.isEmpty()) {
            return f15877a;
        }
        char[][] cArr = new char[((Character) Collections.max(map.keySet())).charValue() + 1];
        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            char charValue = it.next().charValue();
            cArr[charValue] = map.get(Character.valueOf(charValue)).toCharArray();
        }
        return cArr;
    }

    public char[][] a() {
        return this.f15878b;
    }
}
