package kotlin.coroutines.jvm.internal;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public final class a implements kotlin.coroutines.b<Object> {

    /* renamed from: a */
    public static final a f28517a = new a();

    private a() {
    }

    @Override // kotlin.coroutines.b
    public kotlin.coroutines.e getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // kotlin.coroutines.b
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
