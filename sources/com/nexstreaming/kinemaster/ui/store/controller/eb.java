package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.nexasset.assetpackage.db.AssetPackageRecord;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.store.controller.eb;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: MyAssetFragment.java */
/* loaded from: classes2.dex */
public class eb extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private static final String f23547a = "eb";

    /* renamed from: b, reason: collision with root package name */
    private ListView f23548b;

    /* renamed from: c, reason: collision with root package name */
    private GridView f23549c;

    /* renamed from: d, reason: collision with root package name */
    private c.d.a.a.d.a.d f23550d;

    /* renamed from: e, reason: collision with root package name */
    private a f23551e;

    /* renamed from: f, reason: collision with root package name */
    private bb f23552f;

    /* renamed from: g, reason: collision with root package name */
    private View f23553g;

    /* renamed from: h, reason: collision with root package name */
    private File f23554h;
    final View.OnClickListener j = new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.P
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            eb.this.a(view);
        }
    };
    private com.nexstreaming.app.general.nexasset.assetpackage.h i = com.nexstreaming.app.general.nexasset.assetpackage.h.a(getActivity());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MyAssetFragment.java */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<com.nexstreaming.kinemaster.ui.store.model.b> f23555a;

        /* renamed from: b, reason: collision with root package name */
        private View.OnClickListener f23556b;

        /* synthetic */ a(eb ebVar, ArrayList arrayList, View.OnClickListener onClickListener, cb cbVar) {
            this(arrayList, onClickListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b(int i) {
            if (this.f23555a != null && i < this.f23555a.size()) {
                com.nexstreaming.kinemaster.ui.store.model.b bVar = this.f23555a.get(i);
                bVar.a(false);
                if (eb.this.A() != null && !eb.this.A().b(bVar.a())) {
                    this.f23555a.remove(i);
                }
                notifyDataSetInvalidated();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f23555a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f23555a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(R.layout.my_asset_item, viewGroup, false);
            }
            final com.nexstreaming.kinemaster.ui.store.model.b bVar = this.f23555a.get(i);
            ImageView imageView = (ImageView) view.findViewById(R.id.assetThumbnailView);
            if (TextUtils.isEmpty(bVar.getThumbPath())) {
                com.bumptech.glide.c.b(imageView.getContext()).a(bVar.getThumbUrl()).a(imageView);
            } else {
                com.bumptech.glide.c.b(imageView.getContext()).a(bVar.getThumbPath()).a(imageView);
            }
            TextView textView = (TextView) view.findViewById(R.id.assetTitle);
            final String a2 = com.nexstreaming.app.general.util.J.a(eb.this.getActivity(), bVar.getAssetName());
            textView.setText(a2);
            TextView textView2 = (TextView) view.findViewById(R.id.fileSizeText);
            if (bVar.c()) {
                com.nexstreaming.app.general.nexasset.assetpackage.r a3 = eb.this.f23550d.a(bVar.getAssetId());
                if (a3 != null) {
                    File file = new File(URI.create(a3.getPackageURI()).getPath());
                    textView2.setText(EditorGlobal.a(KineMasterApplication.f24056d, file.isDirectory() ? a(file) : file.length()));
                }
            } else {
                textView2.setText(EditorGlobal.a(KineMasterApplication.f24056d, bVar.getAssetSize()));
            }
            TextView textView3 = (TextView) view.findViewById(R.id.assetTypeText);
            String priceType = bVar.getPriceType();
            char c2 = 65535;
            int hashCode = priceType.hashCode();
            if (hashCode != 2198156) {
                if (hashCode != 2479852) {
                    if (hashCode == 1346201143 && priceType.equals("Premium")) {
                        c2 = 1;
                    }
                } else if (priceType.equals("Paid")) {
                    c2 = 2;
                }
            } else if (priceType.equals("Free")) {
                c2 = 0;
            }
            if (c2 == 0) {
                textView3.setText(R.string.sub_use_free);
            } else if (c2 == 1) {
                textView3.setText(R.string.asset_premium);
            } else if (c2 != 2) {
                textView3.setText(R.string.sub_use_free);
            } else {
                textView3.setText(R.string.sub_account_type_paid);
            }
            final Button button = (Button) view.findViewById(R.id.assetRemoveBtn);
            final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.assetDownloadProgress);
            if (bVar.c()) {
                Log.d(eb.f23547a, "installed: set remove listener");
                button.setVisibility(0);
                button.setEnabled(true);
                button.setOnClickListener(this.f23556b);
                button.setText(R.string.btn_remove);
                progressBar.setVisibility(4);
                progressBar.setMax(100);
                progressBar.setProgress(0);
            } else {
                Log.d(eb.f23547a, "uninstalled: set download listener");
                button.setVisibility(0);
                button.setEnabled(true);
                button.setText(R.string.check_before_download_download);
                progressBar.setVisibility(4);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.Q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        eb.a.this.a(button, progressBar, bVar, a2, view2);
                    }
                });
            }
            return view;
        }

        private a(ArrayList<com.nexstreaming.kinemaster.ui.store.model.b> arrayList, View.OnClickListener onClickListener) {
            this.f23555a = arrayList;
            this.f23556b = onClickListener;
        }

        public com.nexstreaming.kinemaster.ui.store.model.b a(int i) {
            return this.f23555a.get(i);
        }

        public int a(com.nexstreaming.app.general.nexasset.assetpackage.b bVar) {
            for (int i = 0; i < this.f23555a.size(); i++) {
                if (bVar.getAssetIdx() == this.f23555a.get(i).getAssetIdx()) {
                    return i;
                }
            }
            return -1;
        }

        public /* synthetic */ void a(final Button button, final ProgressBar progressBar, final com.nexstreaming.kinemaster.ui.store.model.b bVar, String str, View view) {
            button.setVisibility(4);
            progressBar.setVisibility(0);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            ((com.nextreaming.nexeditorui.I) eb.this.getActivity()).w().a(new com.nexstreaming.app.general.service.download.k(String.valueOf(bVar.getAssetIdx()), str, bVar.getThumbUrl(), bVar.getAssetUrl(), eb.this.f23550d.a(bVar.getAssetIdx()), bVar.getAssetSize())).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.S
                @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
                public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                    eb.a.this.a(button, progressBar, bVar, resultTask, event, (com.nexstreaming.app.general.service.download.k) obj);
                }
            }).onProgress(new Task.OnProgressListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.V
                @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
                public final void onProgress(Task task, Task.Event event, int i, int i2) {
                    eb.a.a(button, progressBar, task, event, i, i2);
                }
            }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.T
                @Override // com.nexstreaming.app.general.task.Task.OnFailListener
                public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                    eb.a.a(button, progressBar, task, event, taskError);
                }
            });
        }

        public /* synthetic */ void a(final Button button, final ProgressBar progressBar, final com.nexstreaming.kinemaster.ui.store.model.b bVar, ResultTask resultTask, Task.Event event, com.nexstreaming.app.general.service.download.k kVar) {
            Log.d(eb.f23547a, "onResultAvailable: " + kVar);
            button.setEnabled(false);
            button.setVisibility(0);
            button.setText(R.string.installing_assets);
            progressBar.setVisibility(4);
            progressBar.setMax(100);
            progressBar.setProgress(100);
            eb.this.f23550d.a(bVar.b()).onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.U
                @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
                public final void onTaskEvent(Task task, Task.Event event2) {
                    eb.a.this.a(button, progressBar, bVar, task, event2);
                }
            }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.W
                @Override // com.nexstreaming.app.general.task.Task.OnFailListener
                public final void onFail(Task task, Task.Event event2, Task.TaskError taskError) {
                    eb.a.a(button, progressBar, bVar, task, event2, taskError);
                }
            });
        }

        public /* synthetic */ void a(Button button, ProgressBar progressBar, com.nexstreaming.kinemaster.ui.store.model.b bVar, Task task, Task.Event event) {
            Log.d(eb.f23547a, "install success");
            button.setVisibility(0);
            button.setEnabled(true);
            button.setText(R.string.btn_remove);
            progressBar.setVisibility(4);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            bVar.a(true);
            button.setOnClickListener(this.f23556b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(Button button, ProgressBar progressBar, com.nexstreaming.kinemaster.ui.store.model.b bVar, Task task, Task.Event event, Task.TaskError taskError) {
            Log.d(eb.f23547a, "install failed: " + taskError);
            button.setVisibility(0);
            button.setEnabled(true);
            button.setText(R.string.check_before_download_download);
            progressBar.setVisibility(4);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            bVar.a(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(Button button, ProgressBar progressBar, Task task, Task.Event event, int i, int i2) {
            Log.d(eb.f23547a, "progress: " + i + "maxProgress: " + i2);
            button.setVisibility(4);
            button.setEnabled(false);
            button.setText(R.string.check_before_download_download);
            progressBar.setVisibility(0);
            progressBar.setMax(i2);
            progressBar.setProgress(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(Button button, ProgressBar progressBar, Task task, Task.Event event, Task.TaskError taskError) {
            Log.d(eb.f23547a, "onFail: " + taskError);
            button.setVisibility(0);
            button.setEnabled(true);
            button.setText(R.string.check_before_download_download);
            progressBar.setVisibility(4);
            progressBar.setMax(100);
            progressBar.setProgress(0);
        }

        private long a(File file) {
            long a2;
            long j = 0;
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    a2 = file2.length();
                } else {
                    a2 = a(file2);
                }
                j += a2;
            }
            return j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IABManager A() {
        if (getActivity() == null || !(getActivity() instanceof com.nextreaming.nexeditorui.I)) {
            return null;
        }
        return ((com.nextreaming.nexeditorui.I) getActivity()).y();
    }

    private List<com.nexstreaming.kinemaster.ui.store.model.d> B() {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends com.nexstreaming.app.general.nexasset.assetpackage.a> it = this.i.a().iterator();
        while (it.hasNext()) {
            arrayList.add(new com.nexstreaming.kinemaster.ui.store.model.d(it.next()));
        }
        if (A() != null) {
            List<InterfaceC1821j> p = A().p();
            for (int i = 0; i < p.size(); i++) {
                if (!a(arrayList, p.get(i))) {
                    arrayList.add(new com.nexstreaming.kinemaster.ui.store.model.d(p.get(i)));
                }
            }
        }
        return arrayList;
    }

    private ArrayList<com.nexstreaming.kinemaster.ui.store.model.b> m(int i) {
        com.nexstreaming.kinemaster.ui.store.model.d dVar = (com.nexstreaming.kinemaster.ui.store.model.d) this.f23552f.getItem(i);
        ArrayList<com.nexstreaming.kinemaster.ui.store.model.b> arrayList = new ArrayList<>();
        for (com.nexstreaming.app.general.nexasset.assetpackage.a aVar : this.i.a()) {
            if (dVar.getCategoryIdx() == aVar.getCategoryId()) {
                for (com.nexstreaming.app.general.nexasset.assetpackage.b bVar : this.i.a(aVar)) {
                    com.nexstreaming.kinemaster.ui.store.model.b bVar2 = new com.nexstreaming.kinemaster.ui.store.model.b();
                    bVar2.a(bVar.getAssetUrl());
                    bVar2.b(bVar.getAssetId());
                    bVar2.a(bVar.getAssetIdx());
                    bVar2.c(bVar.getPriceType());
                    bVar2.e(bVar.getThumbPath());
                    bVar2.a(bVar.getAssetName());
                    bVar2.a(true);
                    arrayList.add(bVar2);
                }
            }
        }
        arrayList.addAll(a(dVar));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i) {
        com.nexstreaming.kinemaster.ui.store.model.b a2 = this.f23551e.a(i);
        if (a2.c()) {
            String a3 = com.nexstreaming.app.general.util.J.a(getActivity(), a2.getAssetName());
            final AssetPackageRecord assetPackageRecord = (AssetPackageRecord) com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(a2.getAssetIdx());
            e.a aVar = new e.a(getActivity());
            aVar.c(a3);
            aVar.a(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ca
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            aVar.c(R.string.btn_remove, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.Y
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    eb.this.a(assetPackageRecord, dialogInterface, i2);
                }
            });
            final com.nexstreaming.kinemaster.ui.a.e a4 = aVar.a();
            if (this.f23554h != null) {
                try {
                    com.nexstreaming.kinemaster.ui.projectgallery.O.a(getActivity(), this.f23554h, a2.getAssetIdx()).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.Z
                        @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
                        public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                            eb.this.a(a4, resultTask, event, (Integer) obj);
                        }
                    }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ba
                        @Override // com.nexstreaming.app.general.task.Task.OnFailListener
                        public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                            eb.a(com.nexstreaming.kinemaster.ui.a.e.this, task, event, taskError);
                        }
                    });
                    return;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    a4.e(R.string.remove_asset_popup_msg);
                    a4.show();
                    return;
                }
            }
            a4.e(R.string.remove_asset_popup_msg);
            a4.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        com.nexstreaming.kinemaster.usage.analytics.b.a(eb.class.getName());
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("SELECTED_PROJECT")) != null) {
            this.f23554h = new File(string);
        }
        View inflate = layoutInflater.inflate(R.layout.my_asset_frag, (ViewGroup) null);
        this.f23553g = inflate.findViewById(R.id.emptyMsgHolder);
        this.f23548b = (ListView) inflate.findViewById(R.id.assetCategoryList);
        this.f23549c = (GridView) inflate.findViewById(R.id.myAssetList);
        this.f23550d = c.d.a.a.d.a.d.a(getActivity());
        List<com.nexstreaming.kinemaster.ui.store.model.d> B = B();
        if (B != null && B.size() > 0) {
            this.f23553g.setVisibility(8);
            this.f23552f = new bb(B, getActivity());
            this.f23548b.setAdapter((ListAdapter) this.f23552f);
            this.f23548b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.X
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    eb.this.a(adapterView, view, i, j);
                }
            });
            this.f23548b.setOnKeyListener(new cb(this));
            this.f23549c.setOnKeyListener(new db(this));
            ListView listView = this.f23548b;
            listView.performItemClick(listView.getChildAt(0), 0, this.f23548b.getAdapter().getItemId(0));
            this.f23548b.setSelection(0);
            this.f23548b.requestFocus();
        } else {
            this.f23553g.setVisibility(0);
        }
        return inflate;
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        this.f23552f.c(i);
        this.f23552f.b(i);
        this.f23548b.setSelection(i);
        this.f23551e = new a(this, m(i), this.j, null);
        this.f23549c.setAdapter((ListAdapter) this.f23551e);
        this.f23551e.notifyDataSetChanged();
    }

    public /* synthetic */ void a(View view) {
        n(this.f23549c.getPositionForView(view));
    }

    public /* synthetic */ void a(AssetPackageRecord assetPackageRecord, DialogInterface dialogInterface, int i) {
        a(assetPackageRecord);
        dialogInterface.dismiss();
    }

    public /* synthetic */ void a(com.nexstreaming.kinemaster.ui.a.e eVar, ResultTask resultTask, Task.Event event, Integer num) {
        if (num.intValue() > 0) {
            eVar.a(String.format(getResources().getString(R.string.remove_asset_dependency_popup_msg), num));
        } else {
            eVar.e(R.string.remove_asset_popup_msg);
        }
        eVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(com.nexstreaming.kinemaster.ui.a.e eVar, Task task, Task.Event event, Task.TaskError taskError) {
        eVar.e(R.string.remove_asset_popup_msg);
        eVar.show();
    }

    private ArrayList<com.nexstreaming.kinemaster.ui.store.model.b> a(com.nexstreaming.kinemaster.ui.store.model.d dVar) {
        ArrayList<com.nexstreaming.kinemaster.ui.store.model.b> arrayList = new ArrayList<>();
        if (A() != null) {
            List<InterfaceC1821j> p = A().p();
            for (int i = 0; i < p.size(); i++) {
                InterfaceC1821j interfaceC1821j = p.get(i);
                if (interfaceC1821j.r() == dVar.getCategoryIdx()) {
                    com.nexstreaming.kinemaster.ui.store.model.b bVar = new com.nexstreaming.kinemaster.ui.store.model.b();
                    bVar.a(interfaceC1821j);
                    bVar.a(interfaceC1821j.l());
                    bVar.b(interfaceC1821j.getAssetId());
                    bVar.a(interfaceC1821j.a());
                    bVar.c(interfaceC1821j.getPriceType());
                    bVar.b(interfaceC1821j.h());
                    bVar.f(interfaceC1821j.e());
                    bVar.a(interfaceC1821j.j());
                    bVar.d(interfaceC1821j.b());
                    bVar.a(false);
                    if (this.i.a(bVar.getAssetIdx()) == null) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(AssetPackageRecord assetPackageRecord) {
        int i;
        int a2 = this.f23552f.a();
        com.nexstreaming.kinemaster.ui.store.model.d dVar = (com.nexstreaming.kinemaster.ui.store.model.d) this.f23552f.getItem(a2);
        try {
            Log.d(f23547a, "1. uninstallAsset: ");
            i = this.f23550d.c(assetPackageRecord.getAssetIdx());
        } catch (Exception e2) {
            e.a aVar = new e.a(getActivity());
            aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.aa
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            aVar.c(R.string.asset_uninstall_failed);
            if (PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("asset_dev_mode", false)) {
                aVar.b(e2.getMessage());
            }
            aVar.a().show();
            i = 0;
        }
        if (i == 1) {
            Log.d(f23547a, "3. uninstallAsset: ");
            HashMap hashMap = new HashMap();
            hashMap.put("id", Integer.toString(assetPackageRecord.getAssetIdx()));
            hashMap.put("title", assetPackageRecord.getAssetName().get("en"));
            hashMap.put("category", (dVar == null || dVar.getCategoryAliasName() == null) ? "UnKnown" : dVar.getCategoryAliasName());
            hashMap.put("sub_category", (dVar == null || dVar.getSubCategories() == null || dVar.getSubCategories().get(0) == null || dVar.getSubCategories().get(0).getSubcategoryAliasName() == null) ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : dVar.getSubCategories().get(0).getSubcategoryAliasName());
            KMEvents.ASSET_MY_REMOVE.logEvent(hashMap);
            int a3 = this.f23551e.a(assetPackageRecord);
            if (a3 < 0) {
                return;
            }
            this.f23551e.b(a3);
            Log.d(f23547a, "4. uninstallAsset: ");
            Iterator<com.nexstreaming.kinemaster.ui.store.model.d> it = B().iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (dVar.getCategoryIdx() == it.next().getCategoryIdx()) {
                    Log.d(f23547a, "5.1 selectedCategoryPosition: " + a2);
                    this.f23551e = new a(this, m(a2), this.j, null);
                    this.f23549c.setAdapter((ListAdapter) this.f23551e);
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Log.d(f23547a, "6. uninstallAsset: ");
            this.f23552f.a(a2);
            if (this.f23552f.getCount() <= 0) {
                Log.d(f23547a, "7. uninstallAsset: ");
                this.f23553g.setVisibility(0);
            } else {
                Log.d(f23547a, "8. uninstallAsset: ");
                ListView listView = this.f23548b;
                listView.performItemClick(listView.getChildAt(0), 0, this.f23548b.getAdapter().getItemId(0));
                this.f23548b.setSelection(0);
            }
        }
    }

    private boolean a(List<com.nexstreaming.kinemaster.ui.store.model.d> list, InterfaceC1821j interfaceC1821j) {
        Iterator<com.nexstreaming.kinemaster.ui.store.model.d> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getCategoryIdx() == interfaceC1821j.r()) {
                return true;
            }
        }
        return false;
    }
}
