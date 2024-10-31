package com.nexstreaming.kinemaster.g;

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
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<i> f3388a = new ArrayList();
    private static Context b = null;
    private static i c = null;
    private static NexEditor.r d = new c();
    private static Task.OnTaskEventListener e = new f();
    private static Task.OnTaskEventListener f = new g();
    private static Task.OnFailListener g = new h();
    private static Map<File, WeakReference<i>> h = new HashMap();

    private static NexEditor i() {
        return EditorGlobal.a();
    }

    public static void a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
    }

    public static boolean a() {
        return c != null || f3388a.size() > 0;
    }

    private static i b(Context context, File file, File file2, NexExportProfile nexExportProfile) {
        return a(context, file, new File(file2.getAbsolutePath() + ".temp"), file2, nexExportProfile);
    }

    private static i a(Context context, File file, File file2, File file3, NexExportProfile nexExportProfile) {
        if (b == null) {
            b = context.getApplicationContext();
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
        if (nexExportProfile == null) {
            throw new InvalidParameterException("null export profile");
        }
        i iVar = new i(file, file2, file3, nexExportProfile);
        if (!file.exists()) {
            iVar.sendFailure(NexEditor.b.aV);
        } else if (file3.exists()) {
            iVar.sendFailure(NexEditor.b.aX);
        } else if (file2.exists()) {
            file2.delete();
            f3388a.add(iVar);
            j();
        } else {
            f3388a.add(iVar);
            j();
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        NexEditor i = i();
        i.a(d);
        if (!i.h() && !f3388a.isEmpty()) {
            i remove = f3388a.remove(0);
            long freeSpace = remove.c().getParentFile().getFreeSpace();
            i.a(b).onComplete(new e(remove, remove.d(), i, freeSpace));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(i iVar) {
        if (iVar != null) {
            if (iVar == c) {
                i().g();
                File c2 = c.c();
                if (c2.exists()) {
                    c2.delete();
                }
                iVar.signalEvent(Task.Event.CANCEL);
                return;
            }
            if (f3388a.remove(iVar)) {
                Log.d("Transcoder", "s_pendingTasks.remove(task)      Task.Event.CANCEL!!!!!!!!!!!!!!!!!!!!!!");
                iVar.signalEvent(Task.Event.CANCEL);
            }
        }
    }

    private static void k() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<File, WeakReference<i>> entry : h.entrySet()) {
            if (entry.getValue().get() == null) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            h.remove((File) it.next());
        }
    }

    public static i a(Context context, File file, File file2, NexExportProfile nexExportProfile) {
        i iVar;
        WeakReference<i> weakReference = h.get(file);
        if (weakReference == null || (iVar = weakReference.get()) == null || !iVar.isRunning()) {
            i b2 = b(context, file, file2, nexExportProfile);
            h.put(file, new WeakReference<>(b2));
            k();
            return b2;
        }
        return iVar;
    }

    public static boolean a(File file) {
        i iVar;
        WeakReference<i> weakReference = h.get(file);
        return (weakReference == null || (iVar = weakReference.get()) == null || !iVar.isRunning()) ? false : true;
    }
}
