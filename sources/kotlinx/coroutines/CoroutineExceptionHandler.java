package kotlinx.coroutines;

import kotlin.coroutines.e;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends e.b {

    /* renamed from: c */
    public static final a f28578c = a.f28579a;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* loaded from: classes3.dex */
    public static final class a implements e.c<CoroutineExceptionHandler> {

        /* renamed from: a */
        static final /* synthetic */ a f28579a = new a();

        private a() {
        }
    }

    void a(kotlin.coroutines.e eVar, Throwable th);
}
