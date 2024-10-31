package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.ui.store.controller.nb;
import com.nexstreaming.kinemaster.ui.store.model.FontAssetFixSubCategoryAlias;
import com.nexstreaming.kinemaster.ui.store.model.FontAssetNotFixSubCategoryAlias;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: GridPageFragment.java */
/* loaded from: classes2.dex */
public class _a extends Fragment implements nb.d, fb {

    /* renamed from: b, reason: collision with root package name */
    private int f23520b;

    /* renamed from: d, reason: collision with root package name */
    private ab f23522d;

    /* renamed from: e, reason: collision with root package name */
    private nb f23523e;

    /* renamed from: f, reason: collision with root package name */
    private ResultTask f23524f;

    /* renamed from: g, reason: collision with root package name */
    private RecyclerView f23525g;

    /* renamed from: h, reason: collision with root package name */
    private ListView f23526h;
    private ProgressBar i;
    private InterfaceC1822k j;
    private gb k;

    /* renamed from: a, reason: collision with root package name */
    private final int f23519a = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f23521c = 0;

    private boolean A() {
        InterfaceC1822k interfaceC1822k = this.j;
        return (interfaceC1822k == null || interfaceC1822k.getSubCategories() == null || this.j.getSubCategories().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (A()) {
            b(this.j.getSubCategories().get(0));
        } else {
            a(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (A()) {
            this.f23526h.setAdapter((ListAdapter) this.f23522d);
            this.f23526h.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.O
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    _a.this.a(adapterView, view, i, j);
                }
            });
            if (this.f23521c >= this.f23522d.getCount()) {
                this.f23521c = this.f23522d.getCount() - 1;
            }
            this.f23526h.setSoundEffectsEnabled(false);
            ListView listView = this.f23526h;
            listView.performItemClick(listView.getChildAt(0), 0, this.f23522d.getItemId(0));
            this.f23526h.setSoundEffectsEnabled(true);
            this.f23526h.setVisibility(0);
            this.f23526h.setSelection(0);
            com.nexstreaming.kinemaster.ui.store.view.a a2 = com.nexstreaming.kinemaster.ui.store.view.a.a();
            com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
            a2.a("sub_category_view", this.f23526h);
            this.f23526h.setOnKeyListener(new Ta(this));
            return;
        }
        this.f23526h.setVisibility(8);
    }

    private ResultTask<InterfaceC1822k> z() {
        ResultTask<InterfaceC1822k> resultTask = new ResultTask<>();
        try {
            KineMasterApplication.m().q().g().onResultAvailable(new Za(this, resultTask)).onFailure(resultTask);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return resultTask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (this.k == null && (context instanceof gb)) {
            this.k = (gb) context;
        }
        super.onAttach(context);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f23520b = getArguments().getInt("categoryIndex");
            this.f23521c = getArguments().getInt("SUB_CATEGORY_LIST_POSITION");
        }
        if (getActivity() == null || KineMasterApplication.m().q() == null) {
            return;
        }
        this.f23523e = new nb(getActivity(), com.bumptech.glide.c.a(this), this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(_a.class.getName());
        View inflate = layoutInflater.inflate(R.layout.asset_list_frag, viewGroup, false);
        this.f23525g = (RecyclerView) inflate.findViewById(R.id.assetGridView);
        this.f23525g.setNestedScrollingEnabled(false);
        this.f23525g.addItemDecoration(new com.nexstreaming.kinemaster.ui.store.view.c(getActivity(), 5, 1));
        this.f23525g.getLayoutManager().setAutoMeasureEnabled(true);
        this.f23525g.setHasFixedSize(true);
        this.f23525g.setAdapter(this.f23523e);
        this.f23526h = (ListView) inflate.findViewById(R.id.subCategoryList);
        this.i = (ProgressBar) inflate.findViewById(R.id.progress);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        b();
    }

    private void b() {
        this.i.setVisibility(0);
        z().onResultAvailable(new Ua(this));
    }

    public static _a c(int i, int i2) {
        _a _aVar = new _a();
        Bundle bundle = new Bundle();
        bundle.putInt("categoryIndex", i);
        bundle.putInt("SUB_CATEGORY_LIST_POSITION", i2);
        _aVar.setArguments(bundle);
        return _aVar;
    }

    private void b(com.nexstreaming.kinemaster.network.m mVar) {
        if (mVar == null) {
            this.i.setVisibility(4);
        } else {
            this.f23524f = KineMasterApplication.m().q().a(mVar).onResultAvailable(new Ya(this)).onFailure((Task.OnFailListener) new Xa(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.store.controller.nb.d
    public void a(View view, int i, com.nexstreaming.kinemaster.ui.store.model.c cVar) {
        a(cVar.b());
        this.f23521c = i;
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        ab abVar = this.f23522d;
        if (abVar == null || i == abVar.a()) {
            return;
        }
        this.i.setVisibility(0);
        this.f23522d.a(i);
        com.nexstreaming.kinemaster.network.m mVar = (com.nexstreaming.kinemaster.network.m) this.f23522d.getItem(i);
        a(mVar);
        b(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.nexstreaming.kinemaster.network.m> list, com.nexstreaming.kinemaster.network.m mVar) {
        for (int i = 0; i < list.size(); i++) {
            if (mVar.getSubcategoryIdx() == list.get(i).getSubcategoryIdx()) {
                this.f23521c = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.nexstreaming.kinemaster.network.m> a(List<com.nexstreaming.kinemaster.network.m> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<com.nexstreaming.kinemaster.network.m> arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        String language = Locale.getDefault().getLanguage();
        if (language.equals("zh")) {
            language = Locale.getDefault().toString();
        }
        FontAssetNotFixSubCategoryAlias fromLocale = FontAssetNotFixSubCategoryAlias.fromLocale(language);
        ArrayList arrayList3 = new ArrayList();
        if (fromLocale != null) {
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.nexstreaming.kinemaster.network.m mVar = (com.nexstreaming.kinemaster.network.m) it.next();
                if (mVar.getSubcategoryAliasName().equals(fromLocale.subCategoryAlias)) {
                    arrayList.add(mVar);
                    arrayList2.remove(mVar);
                    break;
                }
            }
            if (fromLocale.equals(FontAssetNotFixSubCategoryAlias.CHS)) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    com.nexstreaming.kinemaster.network.m mVar2 = (com.nexstreaming.kinemaster.network.m) it2.next();
                    if (mVar2.getSubcategoryAliasName().equals(FontAssetNotFixSubCategoryAlias.CHT.subCategoryAlias)) {
                        arrayList.add(mVar2);
                        arrayList2.remove(mVar2);
                        break;
                    }
                }
            } else if (fromLocale.equals(FontAssetNotFixSubCategoryAlias.CHT)) {
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    com.nexstreaming.kinemaster.network.m mVar3 = (com.nexstreaming.kinemaster.network.m) it3.next();
                    if (mVar3.getSubcategoryAliasName().equals(FontAssetNotFixSubCategoryAlias.CHS.subCategoryAlias)) {
                        arrayList.add(mVar3);
                        arrayList2.remove(mVar3);
                        break;
                    }
                }
            }
        }
        for (FontAssetFixSubCategoryAlias fontAssetFixSubCategoryAlias : FontAssetFixSubCategoryAlias.values()) {
            for (com.nexstreaming.kinemaster.network.m mVar4 : arrayList2) {
                if (fontAssetFixSubCategoryAlias.subCategoryAlias.equals(mVar4.getSubcategoryAliasName())) {
                    arrayList.add(mVar4);
                    arrayList3.add(mVar4);
                }
            }
        }
        if (arrayList3.size() > 0) {
            arrayList2.removeAll(arrayList3);
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public void a(InterfaceC1822k interfaceC1822k) {
        if (interfaceC1822k == null) {
            this.i.setVisibility(4);
        } else {
            this.f23524f = KineMasterApplication.m().q().a(interfaceC1822k).onResultAvailable(new Wa(this)).onFailure((Task.OnFailListener) new Va(this));
        }
    }

    public void a(InterfaceC1821j interfaceC1821j) {
        if (getActivity() instanceof StoreActivity) {
            ((StoreActivity) getActivity()).a(interfaceC1821j);
        }
    }

    public void a(com.nexstreaming.kinemaster.network.m mVar) {
        if (getActivity() instanceof StoreActivity) {
            ((StoreActivity) getActivity()).a(mVar);
        }
    }
}
