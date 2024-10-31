package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class m extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f60a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f60a = lVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f60a.mStopped) {
                    this.f60a.doReallyStop(false);
                    return;
                }
                return;
            case 2:
                this.f60a.onResumeFragments();
                this.f60a.mFragments.g();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
