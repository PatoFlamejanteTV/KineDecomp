package com.google.zxing.oned.rss;

/* loaded from: classes2.dex */
public class DataCharacter {

    /* renamed from: a */
    private final int f19190a;

    /* renamed from: b */
    private final int f19191b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        return this.f19190a == dataCharacter.f19190a && this.f19191b == dataCharacter.f19191b;
    }

    public final int hashCode() {
        return this.f19190a ^ this.f19191b;
    }

    public final String toString() {
        return this.f19190a + "(" + this.f19191b + ')';
    }
}
