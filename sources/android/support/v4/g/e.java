package android.support.v4.g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: LayoutInflaterCompatBase.java */
/* loaded from: classes.dex */
class e {

    /* compiled from: LayoutInflaterCompatBase.java */
    /* loaded from: classes.dex */
    static class a implements LayoutInflater.Factory {

        /* renamed from: a, reason: collision with root package name */
        final h f92a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(h hVar) {
            this.f92a = hVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f92a.a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f92a + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LayoutInflater layoutInflater, h hVar) {
        layoutInflater.setFactory(hVar != null ? new a(hVar) : null);
    }
}
