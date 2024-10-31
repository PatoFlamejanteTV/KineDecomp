package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.store.view.AssetListViewPager;
import java.util.List;

/* compiled from: StoreFragment.java */
/* loaded from: classes2.dex */
public class ob extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private int f23596a;

    /* renamed from: b, reason: collision with root package name */
    private ListView f23597b;

    /* renamed from: c, reason: collision with root package name */
    private String f23598c;

    /* renamed from: d, reason: collision with root package name */
    private AssetListViewPager f23599d;

    /* renamed from: e, reason: collision with root package name */
    private gb f23600e;

    public static ob f(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("SPECIFIC_URL", str);
        ob obVar = new ob();
        obVar.setArguments(bundle);
        return obVar;
    }

    public void A() {
        if (getActivity() == null) {
            return;
        }
        ((StoreActivity) getActivity()).G().onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.qa
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                ob.this.a(resultTask, event, (List) obj);
            }
        }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ta
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                ob.this.a(task, event, taskError);
            }
        });
    }

    public /* synthetic */ void B() {
        this.f23599d.setCurrentItem(this.f23596a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0131 A[Catch: Exception -> 0x017e, TryCatch #1 {Exception -> 0x017e, blocks: (B:3:0x0004, B:5:0x001f, B:8:0x002f, B:10:0x0035, B:14:0x0047, B:12:0x004a, B:16:0x004d, B:18:0x0053, B:88:0x0067, B:21:0x0079, B:54:0x0083, B:57:0x0091, B:59:0x0097, B:61:0x00a3, B:64:0x00af, B:66:0x00b5, B:79:0x00d1, B:24:0x00d6, B:27:0x00df, B:29:0x00e5, B:33:0x00f1, B:31:0x00f4, B:34:0x0124, B:36:0x0131, B:37:0x0158, B:39:0x015c, B:45:0x00f7, B:47:0x00ff, B:49:0x0105, B:52:0x010f, B:91:0x0075), top: B:2:0x0004, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015c A[Catch: Exception -> 0x017e, TRY_LEAVE, TryCatch #1 {Exception -> 0x017e, blocks: (B:3:0x0004, B:5:0x001f, B:8:0x002f, B:10:0x0035, B:14:0x0047, B:12:0x004a, B:16:0x004d, B:18:0x0053, B:88:0x0067, B:21:0x0079, B:54:0x0083, B:57:0x0091, B:59:0x0097, B:61:0x00a3, B:64:0x00af, B:66:0x00b5, B:79:0x00d1, B:24:0x00d6, B:27:0x00df, B:29:0x00e5, B:33:0x00f1, B:31:0x00f4, B:34:0x0124, B:36:0x0131, B:37:0x0158, B:39:0x015c, B:45:0x00f7, B:47:0x00ff, B:49:0x0105, B:52:0x010f, B:91:0x0075), top: B:2:0x0004, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7 A[Catch: Exception -> 0x017e, TryCatch #1 {Exception -> 0x017e, blocks: (B:3:0x0004, B:5:0x001f, B:8:0x002f, B:10:0x0035, B:14:0x0047, B:12:0x004a, B:16:0x004d, B:18:0x0053, B:88:0x0067, B:21:0x0079, B:54:0x0083, B:57:0x0091, B:59:0x0097, B:61:0x00a3, B:64:0x00af, B:66:0x00b5, B:79:0x00d1, B:24:0x00d6, B:27:0x00df, B:29:0x00e5, B:33:0x00f1, B:31:0x00f4, B:34:0x0124, B:36:0x0131, B:37:0x0158, B:39:0x015c, B:45:0x00f7, B:47:0x00ff, B:49:0x0105, B:52:0x010f, B:91:0x0075), top: B:2:0x0004, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(com.nexstreaming.app.general.task.ResultTask r8, com.nexstreaming.app.general.task.Task.Event r9, java.util.List r10) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.store.controller.ob.a(com.nexstreaming.app.general.task.ResultTask, com.nexstreaming.app.general.task.Task$Event, java.util.List):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (this.f23600e == null && (context instanceof gb)) {
            this.f23600e = (gb) context;
        }
        super.onAttach(context);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f23598c = getArguments().getString("SPECIFIC_URL");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.asset_store_frag, viewGroup, false);
        this.f23599d = (AssetListViewPager) inflate.findViewById(R.id.assetCategoryViewPager);
        this.f23597b = (ListView) inflate.findViewById(R.id.assetCategoryList);
        this.f23597b.setAdapter((ListAdapter) new pb(getActivity()));
        this.f23597b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.sa
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ob.this.a(adapterView, view, i, j);
            }
        });
        com.nexstreaming.kinemaster.ui.store.view.a a2 = com.nexstreaming.kinemaster.ui.store.view.a.a();
        com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
        a2.a("main_category_view", this.f23597b);
        this.f23597b.setOnKeyListener(new View.OnKeyListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.pa
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return ob.this.a(view, i, keyEvent);
            }
        });
        return inflate;
    }

    public AssetListViewPager z() {
        return this.f23599d;
    }

    public /* synthetic */ void a(ResultTask resultTask, Task.Event event, InterfaceC1821j interfaceC1821j) {
        if (getActivity() == null || !(getActivity() instanceof StoreActivity)) {
            return;
        }
        ((StoreActivity) getActivity()).a(interfaceC1821j);
    }

    public /* synthetic */ void a(Task task, Task.Event event, Task.TaskError taskError) {
        gb gbVar;
        if (!c.d.b.m.i.f(getActivity()) || (gbVar = this.f23600e) == null) {
            return;
        }
        gbVar.a(taskError);
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        ListAdapter adapter = this.f23597b.getAdapter();
        if (adapter instanceof pb) {
            pb pbVar = (pb) adapter;
            if (i != pbVar.b()) {
                pbVar.a(i);
                AssetListViewPager assetListViewPager = this.f23599d;
                if (assetListViewPager != null) {
                    assetListViewPager.setCurrentItem(i);
                }
                this.f23596a = i;
                com.nexstreaming.kinemaster.ui.store.view.a.a().a(i);
                if (getActivity() instanceof StoreActivity) {
                    ((StoreActivity) getActivity()).a(pbVar.getItem(i));
                }
            }
        }
        com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_STOP_PLAYER", null));
    }

    public /* synthetic */ boolean a(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i != 21) {
            if (i != 22) {
                if (i != 61) {
                    return false;
                }
                this.f23599d.requestFocus();
                return true;
            }
            this.f23599d.requestFocus();
        }
        return true;
    }
}
