package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class F implements L {

    /* renamed from: a */
    private final boolean f28584a;

    public F(boolean z) {
        this.f28584a = z;
    }

    @Override // kotlinx.coroutines.L
    public aa a() {
        return null;
    }

    @Override // kotlinx.coroutines.L
    public boolean isActive() {
        return this.f28584a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
