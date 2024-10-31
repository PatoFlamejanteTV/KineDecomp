package android.support.v7.internal.widget;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionBarOverlayLayout.java */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f171a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f171a = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActionBarContainer actionBarContainer;
        ActionBarContainer actionBarContainer2;
        android.support.v4.g.ad adVar;
        ActionBarContainer actionBarContainer3;
        ActionBarContainer actionBarContainer4;
        ActionBarContainer actionBarContainer5;
        ActionBarContainer actionBarContainer6;
        android.support.v4.g.ad adVar2;
        this.f171a.c();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f171a;
        actionBarContainer = this.f171a.f;
        android.support.v4.g.y f = android.support.v4.g.p.f(actionBarContainer);
        actionBarContainer2 = this.f171a.f;
        android.support.v4.g.y b = f.b(-actionBarContainer2.getHeight());
        adVar = this.f171a.A;
        actionBarOverlayLayout.y = b.a(adVar);
        actionBarContainer3 = this.f171a.e;
        if (actionBarContainer3 != null) {
            actionBarContainer4 = this.f171a.e;
            if (actionBarContainer4.getVisibility() != 8) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f171a;
                actionBarContainer5 = this.f171a.e;
                android.support.v4.g.y f2 = android.support.v4.g.p.f(actionBarContainer5);
                actionBarContainer6 = this.f171a.e;
                android.support.v4.g.y b2 = f2.b(actionBarContainer6.getHeight());
                adVar2 = this.f171a.B;
                actionBarOverlayLayout2.z = b2.a(adVar2);
            }
        }
    }
}
