package kotlinx.coroutines;

/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public final class ba implements E, InterfaceC2536e {

    /* renamed from: a */
    public static final ba f28619a = new ba();

    private ba() {
    }

    @Override // kotlinx.coroutines.InterfaceC2536e
    public boolean a(Throwable th) {
        kotlin.jvm.internal.h.b(th, "cause");
        return false;
    }

    @Override // kotlinx.coroutines.E
    public void dispose() {
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
