package com.google.common.escape;

import com.google.common.escape.Escapers;
import java.util.Map;

/* compiled from: Escapers.java */
/* loaded from: classes2.dex */
public class c extends ArrayBasedCharEscaper {

    /* renamed from: f */
    private final char[] f15894f;

    /* renamed from: g */
    final /* synthetic */ Escapers.Builder f15895g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Escapers.Builder builder, Map map, char c2, char c3) {
        super((Map<Character, String>) map, c2, c3);
        String str;
        char[] cArr;
        String str2;
        this.f15895g = builder;
        str = this.f15895g.f15892d;
        if (str != null) {
            str2 = this.f15895g.f15892d;
            cArr = str2.toCharArray();
        } else {
            cArr = null;
        }
        this.f15894f = cArr;
    }

    @Override // com.google.common.escape.ArrayBasedCharEscaper
    protected char[] b(char c2) {
        return this.f15894f;
    }
}
