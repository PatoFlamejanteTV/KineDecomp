package android.support.v4.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f24a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, Looper looper) {
        super(looper);
        this.f24a = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f24a.a();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
