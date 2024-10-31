package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.app.x;
import android.transition.Transition;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes2.dex */
public final class aa extends Transition.EpicenterCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x.a f31a;
    private Rect b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x.a aVar) {
        this.f31a = aVar;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        Rect c;
        if (this.b == null && this.f31a.f67a != null) {
            c = x.c(this.f31a.f67a);
            this.b = c;
        }
        return this.b;
    }
}
