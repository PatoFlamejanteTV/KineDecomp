package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f4126a;
    private File b;
    private KMIntentData c;
    private Task d;
    private Set<ProjectDependency> e;
    private com.nexstreaming.kinemaster.editorwrapper.ar f;
    private com.nexstreaming.kinemaster.ui.a.e h;
    private List<Task> i;
    private boolean g = false;
    private boolean j = false;
    private boolean k = false;

    public a(Context context, File file) {
        this.f4126a = context;
        this.b = file;
    }

    public a(Context context, KMIntentData kMIntentData) {
        this.f4126a = context;
        this.c = kMIntentData;
    }

    public com.nexstreaming.kinemaster.editorwrapper.ar a() {
        return this.f;
    }

    public Task b() {
        if (this.d != null) {
            return this.d;
        }
        this.d = new Task();
        d();
        return this.d;
    }

    private void d() {
        if (this.b != null) {
            try {
                b bVar = new b(this, this.f4126a, new FileInputStream(this.b), false);
                bVar.a(true);
                bVar.execute(new Void[0]);
                return;
            } catch (FileNotFoundException e) {
                Log.e("DependencyChecker", "File not found", e);
                a(Task.Event.FAIL, R.string.project_open_err, R.string.file_not_found);
                return;
            }
        }
        if (this.c != null) {
            EffectLibrary e2 = KineMasterApplication.a().e();
            HashSet hashSet = new HashSet();
            for (KMIntentData.VisualClip visualClip : this.c.project.visualClips) {
                if (visualClip.clipEffectId != null && e2.c(visualClip.clipEffectId) != null) {
                    Log.i("DependencyChecker", "startDependencyCheck() called with: visualClip.clipEffectId = " + visualClip.clipEffectId);
                    ProjectDependency b = ProjectDependency.b(visualClip.clipEffectId);
                    if (b != null) {
                        Log.d("DependencyChecker", "startDependencyCheck() called with: visualClip.clipEffectId check Ok");
                        hashSet.add(b);
                    }
                }
                if (visualClip.transitionEffectId != null && e2.c(visualClip.transitionEffectId) != null) {
                    Log.d("DependencyChecker", "startDependencyCheck() called with: visualClip.transitionEffectId = " + visualClip.transitionEffectId);
                    ProjectDependency b2 = ProjectDependency.b(visualClip.transitionEffectId);
                    if (b2 != null) {
                        Log.d("DependencyChecker", "startDependencyCheck() called with: visualClip.transitionEffectId check Ok");
                        hashSet.add(b2);
                    }
                }
            }
            a(hashSet);
        }
    }

    public void c() {
        if (!this.j && this.d != null) {
            this.j = true;
            if (this.i != null) {
                for (Task task : this.i) {
                    if (task.isCancellable()) {
                        task.cancel();
                    }
                }
            }
            if (this.h != null) {
                this.h.dismiss();
            }
            this.d.signalEvent(Task.Event.CANCEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Set<ProjectDependency> set) {
        if (set != null) {
            this.e = new HashSet();
            for (ProjectDependency projectDependency : set) {
                if (!projectDependency.a()) {
                    this.e.add(projectDependency);
                }
            }
            if (this.e.size() > 0) {
                f();
                return;
            } else {
                this.d.signalEvent(Task.Event.COMPLETE);
                return;
            }
        }
        this.d.signalEvent(Task.Event.FAIL);
    }

    private Resources e() {
        return this.f4126a.getResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Task.Event event, int i) {
        a(event, (String) null, e().getString(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Task.Event event, int i, int i2) {
        a(event, e().getString(i), e().getString(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Task.Event event, int i, Task.TaskError taskError) {
        a(event, e().getString(i), taskError.getLocalizedMessage(this.f4126a));
    }

    private void a(Task.Event event, String str, String str2) {
        new a.C0074a(this.f4126a).d(str).a(str2).a(true).a(R.string.button_ok, new h(this, event)).a(new g(this, event)).a().show();
    }

    private void f() {
        a.C0074a c0074a = new a.C0074a(this.f4126a);
        c0074a.a(R.string.theme_download_popup_message);
        c0074a.a(R.string.theme_download_item_install, new i(this));
        c0074a.b(R.string.button_cancel, new j(this));
        if (this.g) {
            c0074a.c(R.string.theme_open_basic_button, new k(this));
        }
        c0074a.a(new l(this));
        c0074a.a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.j) {
            this.h = new e.a(this.f4126a).a(R.string.downloading_theme).a(false).a(R.string.button_cancel, new m(this)).a();
            this.h.i(0);
            this.h.h(100);
            this.h.show();
            EffectLibrary e = KineMasterApplication.a().e();
            e.d().onResultAvailable(new c(this, e)).onFailure((Task.OnFailListener) new n(this));
        }
    }
}
