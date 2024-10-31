package okhttp3.a;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Util.java */
/* loaded from: classes3.dex */
public class d implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f28924a;

    /* renamed from: b */
    final /* synthetic */ boolean f28925b;

    public d(String str, boolean z) {
        this.f28924a = str;
        this.f28925b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f28924a);
        thread.setDaemon(this.f28925b);
        return thread;
    }
}
