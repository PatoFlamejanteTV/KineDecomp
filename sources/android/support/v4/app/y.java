package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;

/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes2.dex */
final class y extends Transition.EpicenterCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rect f68a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Rect rect) {
        this.f68a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        return this.f68a;
    }
}
