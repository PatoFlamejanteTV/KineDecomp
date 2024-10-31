package com.nexstreaming.kinemaster.ui.welcome;

import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

/* compiled from: WelcomeDTO.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    private final int f23690a;

    /* renamed from: b */
    private final int f23691b;

    /* renamed from: c */
    private final int f23692c;

    /* renamed from: d */
    private final String f23693d;

    public b(int i, int i2, int i3, String str) {
        h.b(str, "videoName");
        this.f23690a = i;
        this.f23691b = i2;
        this.f23692c = i3;
        this.f23693d = str;
    }

    public final int a() {
        return this.f23691b;
    }

    public final int b() {
        return this.f23690a;
    }

    public final int c() {
        return this.f23692c;
    }

    public final String d() {
        return this.f23693d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!h.a(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            b bVar = (b) obj;
            return this.f23690a == bVar.f23690a && this.f23691b == bVar.f23691b && this.f23692c == bVar.f23692c && !(h.a((Object) this.f23693d, (Object) bVar.f23693d) ^ true);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.welcome.WelcomeDTO");
    }

    public int hashCode() {
        return (((((this.f23690a * 31) + this.f23691b) * 31) + this.f23692c) * 31) + this.f23693d.hashCode();
    }

    public String toString() {
        return "WelcomeDTO(titleId=" + this.f23690a + ", contentId=" + this.f23691b + ", videoId=" + this.f23692c + ", videoName=" + this.f23693d + ")";
    }
}
