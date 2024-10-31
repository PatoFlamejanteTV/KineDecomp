package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemCategory;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.a.r;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class O {

    /* renamed from: a, reason: collision with root package name */
    private Context f22866a;

    /* renamed from: b, reason: collision with root package name */
    private File f22867b;

    /* renamed from: c, reason: collision with root package name */
    private KMIntentData f22868c;

    /* renamed from: e, reason: collision with root package name */
    private Task f22870e;

    /* renamed from: f, reason: collision with root package name */
    private List<ProjectDependency> f22871f;

    /* renamed from: g, reason: collision with root package name */
    private C1780za f22872g;
    private com.nexstreaming.kinemaster.ui.a.r i;
    private c.d.a.a.d.a.d j;
    private com.nexstreaming.app.general.service.download.i k;
    private boolean l;

    /* renamed from: h, reason: collision with root package name */
    private boolean f22873h = false;
    private boolean m = false;
    private BroadcastReceiver n = new C2154z(this);

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Task> f22869d = new HashMap();

    public O(Context context, com.nexstreaming.app.general.service.download.i iVar) {
        this.f22866a = context;
        this.j = c.d.a.a.d.a.d.a(context);
        this.k = iVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.nextreaming.kinemaster.asset.install.completed");
        intentFilter.addAction("com.nextreaming.kinemaster.asset.uninstall.completed");
        context.registerReceiver(this.n, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ProjectDependency b2;
        ProjectDependency b3;
        File file = this.f22867b;
        if (file != null) {
            try {
                E e2 = new E(this, this.f22866a, new FileInputStream(file), false);
                e2.a(true);
                e2.execute(new Void[0]);
                return;
            } catch (FileNotFoundException e3) {
                Log.e("DependencyChecker", "File not found", e3);
                a(Task.Event.FAIL, R.string.project_open_err, R.string.file_not_found);
                return;
            }
        }
        if (this.f22868c != null) {
            com.nexstreaming.app.general.nexasset.assetpackage.h e4 = com.nexstreaming.app.general.nexasset.assetpackage.h.e();
            HashSet hashSet = new HashSet();
            for (KMIntentData.VisualClip visualClip : this.f22868c.project.visualClips) {
                String str = visualClip.clipEffectId;
                if (str != null && e4.a(str, ItemCategory.effect) && (b3 = ProjectDependency.b(visualClip.clipEffectId)) != null) {
                    hashSet.add(b3);
                }
                String str2 = visualClip.transitionEffectId;
                if (str2 != null && e4.a(str2, ItemCategory.transition) && (b2 = ProjectDependency.b(visualClip.transitionEffectId)) != null) {
                    hashSet.add(b2);
                }
            }
            a(hashSet);
        }
    }

    private Task f() {
        File file = this.f22867b;
        if (file != null) {
            this.f22870e = this.f22869d.get(file.getAbsolutePath());
            Task task = this.f22870e;
            if (task != null && (task.isRunning() || this.f22870e.didSignalEvent(Task.Event.SUCCESS))) {
                return this.f22870e;
            }
            this.f22870e = new Task();
            this.f22869d.put(this.f22867b.getAbsolutePath(), this.f22870e);
        } else {
            this.f22870e = new Task();
        }
        j();
        return this.f22870e;
    }

    private Resources g() {
        return this.f22866a.getResources();
    }

    private boolean h() {
        try {
            return Locale.getDefault().getLanguage().equals("ko");
        } catch (Exception unused) {
            return false;
        }
    }

    private void i() {
        if (c.d.b.m.i.f(this.f22866a)) {
            KineMasterApplication.m().q().a(this.f22871f.get(0).a(), true).onResultAvailable(new C2137q(this)).onFailure((Task.OnFailListener) new N(this));
            return;
        }
        e.a aVar = new e.a(this.f22866a);
        aVar.c(R.string.asset_can_not_download_disconnected_network);
        aVar.c(R.string.button_ok, new DialogInterfaceOnClickListenerC2140s(this));
        aVar.a(R.string.button_cancel, new r(this));
        aVar.a().show();
    }

    public void b() {
        this.k = null;
        this.j = null;
        this.f22866a.unregisterReceiver(this.n);
    }

    public C1780za c() {
        return this.f22872g;
    }

    public boolean d() {
        String string;
        C1780za c1780za = this.f22872g;
        boolean z = false;
        if (c1780za != null && c1780za.a() != null) {
            ArrayList arrayList = new ArrayList();
            for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.f22872g.a().getPrimaryItems()) {
                if (!nexPrimaryTimelineItem.checkResourceState(this.f22866a)) {
                    arrayList.add(nexPrimaryTimelineItem);
                }
            }
            for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.f22872g.a().getSecondaryItems()) {
                if (!nexSecondaryTimelineItem.checkResourceState(this.f22866a)) {
                    arrayList.add(nexSecondaryTimelineItem);
                }
            }
            if (arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    NexTimelineItem nexTimelineItem = (NexTimelineItem) it.next();
                    if (nexTimelineItem.getFileCategory() != null) {
                        int i = F.f22831a[nexTimelineItem.getFileCategory().ordinal()];
                        if (i == 1) {
                            arrayList2.add(nexTimelineItem);
                        } else if (i == 2) {
                            arrayList3.add(nexTimelineItem);
                        } else if (i == 3) {
                            arrayList4.add(nexTimelineItem);
                        }
                    }
                }
                boolean h2 = h();
                if (arrayList2.size() > 0 && arrayList3.size() == 0 && arrayList4.size() == 0) {
                    if (h2) {
                        string = this.f22866a.getResources().getQuantityString(R.plurals.missing_image_from_project, arrayList2.size(), Integer.valueOf(arrayList2.size()));
                    } else {
                        string = this.f22866a.getResources().getQuantityString(R.plurals.missing_image_from_project, arrayList2.size(), a(((NexTimelineItem) arrayList2.get(0)).getAbsStartTime()));
                    }
                } else if (arrayList2.size() == 0 && arrayList3.size() > 0 && arrayList4.size() == 0) {
                    if (h2) {
                        string = this.f22866a.getResources().getQuantityString(R.plurals.missing_video_from_project, arrayList3.size(), Integer.valueOf(arrayList3.size()));
                    } else {
                        string = this.f22866a.getResources().getQuantityString(R.plurals.missing_video_from_project, arrayList3.size(), a(((NexTimelineItem) arrayList3.get(0)).getAbsStartTime()));
                    }
                } else if (arrayList2.size() != 0 || arrayList3.size() != 0 || arrayList4.size() <= 0) {
                    string = this.f22866a.getResources().getString(R.string.missing_few_medias_from_project, Integer.valueOf(arrayList.size()));
                } else if (h2) {
                    string = this.f22866a.getResources().getQuantityString(R.plurals.missing_audio_from_project, arrayList4.size(), Integer.valueOf(arrayList4.size()));
                } else {
                    string = this.f22866a.getResources().getQuantityString(R.plurals.missing_audio_from_project, arrayList4.size(), a(((NexTimelineItem) arrayList4.get(0)).getAbsStartTime()));
                }
                if (this.l) {
                    String str = string + this.f22866a.getResources().getQuantityString(R.plurals.missing_media_exporting_message, arrayList.size());
                    e.a aVar = new e.a(this.f22866a);
                    aVar.a(str);
                    aVar.c(R.string.encoding_warn_missingrsrc_exportanyway, new I(this));
                    aVar.a(R.string.button_cancel, new H(this));
                    aVar.a(new G(this));
                    aVar.a().show();
                } else {
                    e.a aVar2 = new e.a(this.f22866a);
                    aVar2.a(string);
                    aVar2.c(R.string.button_ok, new K(this));
                    aVar2.a(new J(this));
                    aVar2.a().show();
                }
                z = true;
            }
            Log.d("DependencyChecker", "checkMissingResources() returned:  timelineItems " + arrayList.size());
        }
        return z;
    }

    public boolean e() {
        Task task = this.f22870e;
        return task != null && task.isRunning();
    }

    public Task a(File file, String str, boolean z) {
        this.f22867b = file;
        this.l = z;
        return f();
    }

    public Task a(KMIntentData kMIntentData, String str) {
        this.f22868c = kMIntentData;
        return f();
    }

    public void a() {
        if (this.f22870e == null) {
            return;
        }
        this.m = false;
        this.k.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Set<ProjectDependency> set) {
        if (set != null) {
            this.f22871f = new ArrayList();
            for (ProjectDependency projectDependency : set) {
                if (!projectDependency.b()) {
                    this.f22871f.add(projectDependency);
                }
            }
            if (this.f22871f.size() > 0) {
                i();
                return;
            }
            this.m = false;
            com.nexstreaming.kinemaster.ui.a.r rVar = this.i;
            if (rVar != null && rVar.isShowing()) {
                this.i.dismiss();
            }
            if (!d()) {
                this.f22870e.signalEvent(Task.Event.COMPLETE);
                return;
            } else {
                this.f22869d.remove(this.f22867b.getAbsolutePath());
                return;
            }
        }
        this.m = false;
        this.f22870e.signalEvent(Task.Event.FAIL);
    }

    private String a(int i) {
        long j = i;
        return String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Task.Event event, int i) {
        a(event, (String) null, g().getString(i));
    }

    private void a(Task.Event event, int i, int i2) {
        a(event, g().getString(i), g().getString(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Task.Event event, int i, Task.TaskError taskError) {
        a(event, g().getString(i), taskError.getLocalizedMessage(this.f22866a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Task.Event event, String str, String str2) {
        e.a aVar = new e.a(this.f22866a);
        aVar.c(str);
        aVar.a(str2);
        aVar.a(true);
        aVar.c(R.string.button_ok, new M(this, event));
        aVar.a(new L(this, event));
        aVar.a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j != null) {
            String a2 = com.nexstreaming.app.general.util.J.a(this.f22866a, interfaceC1821j.j(), interfaceC1821j.f());
            if (TextUtils.isEmpty(a2)) {
                a2 = interfaceC1821j.getCategoryAliasName();
            }
            if (this.i == null) {
                r.a aVar = new r.a(this.f22866a);
                aVar.b(R.string.downloading_theme);
                aVar.a(false);
                aVar.a(R.string.button_cancel, new DialogInterfaceOnClickListenerC2142t(this));
                this.i = aVar.a();
            }
            this.i.setTitle(a2);
            if (this.f22871f.size() > 0) {
                this.i.i(100);
                this.i.j(0);
                if (!this.i.isShowing()) {
                    this.i.show();
                }
                this.m = true;
                this.k.a(new com.nexstreaming.app.general.service.download.k(String.valueOf(interfaceC1821j.a()), com.nexstreaming.app.general.util.J.a(this.f22866a, interfaceC1821j.j(), interfaceC1821j.f()), interfaceC1821j.p(), interfaceC1821j.l(), this.j.a(interfaceC1821j.a()), interfaceC1821j.h())).onResultAvailable(new C2152y(this, interfaceC1821j)).onFailure((Task.OnFailListener) new C2146v(this)).onProgress((Task.OnProgressListener) new C2144u(this));
                return;
            }
            this.m = false;
            com.nexstreaming.kinemaster.ui.a.r rVar = this.i;
            if (rVar != null && rVar.isShowing()) {
                this.i.dismiss();
            }
            this.f22870e.signalEvent(Task.Event.COMPLETE);
            return;
        }
        a(Task.Event.COMPLETE, R.string.asset_not_available_popup);
    }

    public static ResultTask<Integer> a(Context context, File file, int i) throws FileNotFoundException {
        ResultTask<Integer> resultTask = new ResultTask<>();
        if (file != null) {
            try {
                B b2 = new B(context, new FileInputStream(file), false, i, resultTask);
                b2.a(true);
                b2.execute(new Void[0]);
            } catch (FileNotFoundException e2) {
                Log.e("DependencyChecker", "File not found", e2);
                throw new FileNotFoundException(e2.getMessage());
            }
        }
        return resultTask;
    }

    public static ResultTask<Boolean> a(Context context, File file) throws FileNotFoundException {
        ResultTask<Boolean> resultTask = new ResultTask<>();
        if (file != null) {
            try {
                D d2 = new D(context, new FileInputStream(file), false, resultTask);
                d2.a(true);
                d2.execute(new Void[0]);
            } catch (FileNotFoundException e2) {
                Log.e("DependencyChecker", "File not found", e2);
                throw new FileNotFoundException(e2.getMessage());
            }
        }
        return resultTask;
    }
}
