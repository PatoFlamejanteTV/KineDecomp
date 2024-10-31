package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import c.d.b.b.d;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdManager;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.store.controller.nb;
import com.nexstreaming.kinemaster.ui.store.model.c;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FeaturedPageFragment.java */
/* loaded from: classes2.dex */
public class Sa extends Fragment implements nb.d, d.a, fb {

    /* renamed from: b, reason: collision with root package name */
    private nb f23488b;

    /* renamed from: c, reason: collision with root package name */
    private nb f23489c;

    /* renamed from: d, reason: collision with root package name */
    private Context f23490d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f23491e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f23492f;

    /* renamed from: g, reason: collision with root package name */
    private ProgressBar f23493g;
    private io.reactivex.disposables.b i;

    /* renamed from: a, reason: collision with root package name */
    private final int f23487a = 1;

    /* renamed from: h, reason: collision with root package name */
    private TencentAdManager f23494h = null;
    private TencentAdListener.NativeExpressAdListener j = new Qa(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        KineMasterApplication.m().q().a(1).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.L
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                Sa.this.a(resultTask, event, (com.nexstreaming.kinemaster.network.l) obj);
            }
        }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.M
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                Sa.this.a(task, event, taskError);
            }
        });
    }

    private void B() {
        com.nexstreaming.kinemaster.ui.f.a.b.a().b().a((io.reactivex.q<? super com.nexstreaming.kinemaster.ui.f.a.a>) new Ra(this));
    }

    public static Sa z() {
        return new Sa();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            this.f23490d = getActivity().getApplicationContext();
        }
        this.f23488b = new nb(getActivity(), com.bumptech.glide.c.a(this), this);
        this.f23489c = new nb(getActivity(), com.bumptech.glide.c.a(this), this);
        if (c.d.b.m.e.f3850a.a()) {
            this.f23494h = new TencentAdManager(getActivity(), this.j, TencentAdProvider.Companion.getSF_UNIT_ID());
            this.f23494h.setContainer();
        }
        B();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(Sa.class.getName());
        View inflate = layoutInflater.inflate(R.layout.asset_store_featured, viewGroup, false);
        this.f23492f = (RecyclerView) inflate.findViewById(R.id.bannerListView);
        this.f23492f.setAdapter(this.f23488b);
        this.f23492f.getLayoutParams().height = (int) (this.f23492f.getResources().getDisplayMetrics().heightPixels * 0.36f);
        this.f23492f.addItemDecoration(new com.nexstreaming.kinemaster.ui.store.view.c((int) getResources().getDimension(R.dimen.asset_store_item_spacing)));
        this.f23491e = (RecyclerView) inflate.findViewById(R.id.itemListView);
        this.f23491e.setAdapter(this.f23489c);
        this.f23491e.addItemDecoration(new com.nexstreaming.kinemaster.ui.store.view.c((int) getResources().getDimension(R.dimen.asset_store_item_spacing)));
        this.f23493g = (ProgressBar) inflate.findViewById(R.id.progress);
        ViewCompat.setNestedScrollingEnabled(this.f23491e, false);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        com.nexstreaming.kinemaster.ad.g a2;
        super.onPause();
        if (!(getActivity() instanceof StoreActivity) || ((StoreActivity) getActivity()).C() || (a2 = AdManager.a(getActivity()).a(AdmobAdProvider.STORE_AD_UNIT_ID)) == null) {
            return;
        }
        a2.clearAd();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        c.d.b.b.i.b().a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        c.d.b.b.i.b().b(this);
        this.i.dispose();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.f23493g.setVisibility(0);
        this.f23493g.postOnAnimation(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.store.controller.N
            @Override // java.lang.Runnable
            public final void run() {
                Sa.this.A();
            }
        });
    }

    @Override // c.d.b.b.d.a
    public void a(c.d.b.b.d dVar, c.d.b.b.a.e eVar) {
        if ((getActivity() instanceof StoreActivity) && ((StoreActivity) getActivity()).C()) {
            this.f23489c.a((FrameLayout) null);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.store.controller.nb.d
    public void a(View view, int i, com.nexstreaming.kinemaster.ui.store.model.c cVar) {
        a(cVar.b());
    }

    public /* synthetic */ void a(ResultTask resultTask, Task.Event event, com.nexstreaming.kinemaster.network.l lVar) {
        if (this.f23490d == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<InterfaceC1821j> a2 = lVar.a();
            for (int i = 0; i < a2.size(); i++) {
                c.a aVar = new c.a(this.f23490d, a2.get(i));
                if (i < 4) {
                    aVar.a(1);
                    arrayList.add(aVar.a());
                } else {
                    aVar.a(0);
                    arrayList2.add(aVar.a());
                }
            }
            if (this.f23488b != null) {
                nb nbVar = this.f23488b;
                nbVar.f();
                nbVar.b(arrayList);
                nbVar.notifyDataSetChanged();
            }
            if (this.f23489c != null) {
                nb nbVar2 = this.f23489c;
                nbVar2.f();
                nbVar2.b(arrayList2);
                nbVar2.notifyDataSetChanged();
            }
            com.nexstreaming.kinemaster.ui.store.view.a a3 = com.nexstreaming.kinemaster.ui.store.view.a.a();
            com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
            a3.a("feature_banner_view", this.f23492f);
            com.nexstreaming.kinemaster.ui.store.view.a a4 = com.nexstreaming.kinemaster.ui.store.view.a.a();
            com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
            a4.a("feature_asset_view", this.f23491e);
            if ((getActivity() instanceof StoreActivity) && !((StoreActivity) getActivity()).C()) {
                if (c.d.b.m.e.f3850a.a() && this.f23494h != null) {
                    this.f23494h.requestNativeExpressAd();
                } else {
                    ((StoreActivity) getActivity()).I();
                }
            }
        } finally {
            this.f23493g.setVisibility(8);
        }
    }

    public /* synthetic */ void a(Task task, Task.Event event, Task.TaskError taskError) {
        this.f23493g.setVisibility(8);
    }

    public void a(InterfaceC1821j interfaceC1821j) {
        if (getActivity() instanceof StoreActivity) {
            ((StoreActivity) getActivity()).a(interfaceC1821j);
        }
    }
}
