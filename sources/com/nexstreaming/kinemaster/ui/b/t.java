package com.nexstreaming.kinemaster.ui.b;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiniFxGroupBrowserFragment.java */
/* loaded from: classes.dex */
public class t implements Comparator<com.nexstreaming.kinemaster.kmpackage.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f3707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.f3707a = oVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.nexstreaming.kinemaster.kmpackage.b bVar, com.nexstreaming.kinemaster.kmpackage.b bVar2) {
        return bVar.a(this.f3707a.getActivity()).compareTo(bVar2.a(this.f3707a.getActivity()));
    }
}
