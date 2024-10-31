package com.nexstreaming.kinemaster.ui.store.controller;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.network.ViewType;
import com.nexstreaming.kinemaster.ui.store.model.SubCategory;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.List;

/* compiled from: AudioPageAssetListFragment.java */
/* loaded from: classes2.dex */
public class La extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f23461a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f23462b;

    /* renamed from: c, reason: collision with root package name */
    private io.reactivex.disposables.b f23463c;

    private void z() {
        com.nexstreaming.kinemaster.ui.f.a.b.a().b().a((io.reactivex.q<? super com.nexstreaming.kinemaster.ui.f.a.a>) new Ka(this));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(La.class.getName());
        SubCategory subCategory = (SubCategory) getArguments().getSerializable("KEY_SUB_CATEGORY");
        View inflate = layoutInflater.inflate(R.layout.fragment_audio_asset_list, viewGroup, false);
        this.f23461a = (ProgressBar) inflate.findViewById(R.id.progressBar);
        this.f23461a.setVisibility(0);
        this.f23462b = (RecyclerView) inflate.findViewById(R.id.assetListView);
        Drawable drawable = ContextCompat.getDrawable(KineMasterApplication.i(), R.drawable.divider_audio_list);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(KineMasterApplication.i(), new LinearLayoutManager(getContext()).getOrientation());
        dividerItemDecoration.setDrawable(drawable);
        this.f23462b.addItemDecoration(dividerItemDecoration);
        this.f23462b.setAdapter(new Ja(subCategory.getViewType() == ViewType.AUDIO_MUSERK, ((com.nextreaming.nexeditorui.I) getActivity()).w(), ((com.nextreaming.nexeditorui.I) getActivity()).y()));
        KineMasterApplication.m().q().a(subCategory).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.I
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                La.this.a(resultTask, event, (List) obj);
            }
        }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.H
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                La.this.a(task, event, taskError);
            }
        });
        z();
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        ((Ja) this.f23462b.getAdapter()).i();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        z();
        ((Ja) this.f23462b.getAdapter()).g();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f23463c.dispose();
        ((Ja) this.f23462b.getAdapter()).h();
    }

    public static La a(com.nexstreaming.kinemaster.network.m mVar) {
        La la = new La();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_SUB_CATEGORY", new SubCategory(mVar));
        la.setArguments(bundle);
        return la;
    }

    public /* synthetic */ void a(ResultTask resultTask, Task.Event event, List list) {
        if (getActivity() != null) {
            Ja ja = (Ja) this.f23462b.getAdapter();
            ja.b((List<InterfaceC1821j>) list);
            ja.notifyDataSetChanged();
            this.f23461a.setVisibility(8);
        }
    }

    public /* synthetic */ void a(Task task, Task.Event event, Task.TaskError taskError) {
        this.f23461a.setVisibility(8);
    }
}
