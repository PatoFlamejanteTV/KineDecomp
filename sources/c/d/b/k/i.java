package c.d.b.k;

import android.content.Context;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static List<j> f3830a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static Context f3831b = null;

    /* renamed from: c, reason: collision with root package name */
    private static j f3832c = null;

    /* renamed from: d, reason: collision with root package name */
    private static NexEditor.s f3833d = new d();

    /* renamed from: e, reason: collision with root package name */
    private static Task.OnTaskEventListener f3834e = new f();

    /* renamed from: f, reason: collision with root package name */
    private static Task.OnTaskEventListener f3835f = new g();

    /* renamed from: g, reason: collision with root package name */
    private static Task.OnFailListener f3836g = new h();

    /* renamed from: h, reason: collision with root package name */
    private static Map<File, WeakReference<j>> f3837h = new HashMap();

    public static boolean h() {
        return f3832c != null || f3830a.size() > 0;
    }

    private static NexEditor i() {
        return EditorGlobal.i();
    }

    private static void j() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<File, WeakReference<j>> entry : f3837h.entrySet()) {
            if (entry.getValue().get() == null) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f3837h.remove((File) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        NexEditor i = i();
        i.a(f3833d);
        if (i.l() || f3830a.isEmpty()) {
            return;
        }
        j remove = f3830a.remove(0);
        long freeSpace = remove.f().getParentFile().getFreeSpace();
        i.a(f3831b).onComplete(new e(remove, remove.c(), i, freeSpace));
    }

    private static j b(Context context, File file, File file2, NexExportProfile nexExportProfile) {
        return a(context, file, new File(file2.getAbsolutePath() + ".temp"), file2, nexExportProfile);
    }

    public static void a(Context context) {
        if (f3831b == null) {
            f3831b = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(j jVar) {
        if (jVar == null) {
            return;
        }
        if (jVar == f3832c) {
            i().t();
            File f2 = f3832c.f();
            if (f2.exists()) {
                f2.delete();
            }
            jVar.signalEvent(Task.Event.CANCEL);
            return;
        }
        if (f3830a.remove(jVar)) {
            Log.d("Transcoder", "s_pendingTasks.remove(task)      Task.Event.CANCEL!!!!!!!!!!!!!!!!!!!!!!");
            jVar.signalEvent(Task.Event.CANCEL);
        }
    }

    private static j a(Context context, File file, File file2, File file3, NexExportProfile nexExportProfile) {
        if (f3831b == null) {
            f3831b = context.getApplicationContext();
        }
        if (file == null) {
            throw new InvalidParameterException("null source path");
        }
        if (file3 == null) {
            throw new InvalidParameterException("null destination path");
        }
        if (file2 == null) {
            throw new InvalidParameterException("null temp path");
        }
        if (nexExportProfile != null) {
            j jVar = new j(file, file2, file3, nexExportProfile);
            if (!file.exists()) {
                jVar.sendFailure(NexEditor.b.Wa);
            } else if (file3.exists()) {
                jVar.sendFailure(NexEditor.b.Ya);
            } else if (file2.exists()) {
                file2.delete();
                f3830a.add(jVar);
                k();
            } else {
                f3830a.add(jVar);
                k();
            }
            return jVar;
        }
        throw new InvalidParameterException("null export profile");
    }

    public static j a(Context context, File file, File file2, NexExportProfile nexExportProfile) {
        j jVar;
        WeakReference<j> weakReference = f3837h.get(file);
        if (weakReference != null && (jVar = weakReference.get()) != null && jVar.isRunning()) {
            return jVar;
        }
        j b2 = b(context, file, file2, nexExportProfile);
        f3837h.put(file, new WeakReference<>(b2));
        j();
        return b2;
    }

    public static boolean a(File file) {
        j jVar;
        WeakReference<j> weakReference = f3837h.get(file);
        return (weakReference == null || (jVar = weakReference.get()) == null || !jVar.isRunning()) ? false : true;
    }
}
