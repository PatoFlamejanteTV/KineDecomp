package com.nextreaming.nexeditorui.newproject.b;

import com.nextreaming.nexeditorui.newproject.b.f;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class k implements Comparator<f.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.f4673a = fVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(f.b bVar, f.b bVar2) {
        if (bVar.b() == bVar2.b()) {
            return bVar.a().a(this.f4673a.getActivity()).compareTo(bVar2.a().a(this.f4673a.getActivity()));
        }
        if (bVar.b()) {
            return -1;
        }
        return 1;
    }
}
