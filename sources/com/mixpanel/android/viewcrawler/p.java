package com.mixpanel.android.viewcrawler;

import android.view.View;
import com.mixpanel.android.viewcrawler.o;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewVisitor.java */
/* loaded from: classes.dex */
public class p implements Comparator<View> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o.g f3119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o.g gVar) {
        this.f3119a = gVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(View view, View view2) {
        if (view == view2) {
            return 0;
        }
        if (view == null) {
            return -1;
        }
        if (view2 == null) {
            return 1;
        }
        return view2.hashCode() - view.hashCode();
    }
}
