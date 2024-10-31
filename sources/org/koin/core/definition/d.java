package org.koin.core.definition;

import kotlin.jvm.internal.f;

/* compiled from: Options.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a */
    private boolean f29371a;

    /* renamed from: b */
    private boolean f29372b;

    public d() {
        this(false, false, 3, null);
    }

    public d(boolean z, boolean z2) {
        this.f29371a = z;
        this.f29372b = z2;
    }

    public final boolean a() {
        return this.f29372b;
    }

    public final boolean b() {
        return this.f29371a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (this.f29371a == dVar.f29371a) {
                    if (this.f29372b == dVar.f29372b) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f29371a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.f29372b;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "Options(isCreatedAtStart=" + this.f29371a + ", override=" + this.f29372b + ")";
    }

    public /* synthetic */ d(boolean z, boolean z2, int i, f fVar) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public final void a(boolean z) {
        this.f29371a = z;
    }

    public final void b(boolean z) {
        this.f29372b = z;
    }
}
