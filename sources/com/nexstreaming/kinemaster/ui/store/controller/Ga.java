package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetDetailPreviewImagePagerAdapter.java */
/* loaded from: classes2.dex */
public class Ga implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f23443a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ha f23444b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(Ha ha, int i) {
        this.f23444b = ha;
        this.f23443a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentManager fragmentManager;
        ArrayList arrayList;
        FragmentManager fragmentManager2;
        FragmentManager fragmentManager3;
        fragmentManager = this.f23444b.f23447d;
        if (fragmentManager.findFragmentById(R.id.fragmentHolder) != null) {
            fragmentManager3 = this.f23444b.f23447d;
            if (fragmentManager3.findFragmentById(R.id.fragmentHolder) instanceof eb) {
                return;
            }
        }
        com.nexstreaming.kinemaster.usage.analytics.j.a(this.f23443a);
        int i = this.f23443a;
        arrayList = this.f23444b.f23446c;
        Fragment a2 = Fa.a(i, arrayList);
        fragmentManager2 = this.f23444b.f23447d;
        fragmentManager2.beginTransaction().addToBackStack("AssetDetailPreviewImageListFragment").replace(android.R.id.content, a2).commit();
    }
}
