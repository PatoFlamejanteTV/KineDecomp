package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.wire.HeaderDelimitedOutputStream;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexProjectHeader;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class sb extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    byte[] f20356a = null;

    /* renamed from: b, reason: collision with root package name */
    byte[] f20357b = null;

    /* renamed from: c, reason: collision with root package name */
    boolean f20358c;

    /* renamed from: d, reason: collision with root package name */
    boolean f20359d;

    /* renamed from: e, reason: collision with root package name */
    boolean f20360e;

    /* renamed from: f, reason: collision with root package name */
    Task.TaskError f20361f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ KMProto.KMProject f20362g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ ResultTask f20363h;
    final /* synthetic */ NexProjectHeader i;
    final /* synthetic */ int j;
    final /* synthetic */ boolean k;
    final /* synthetic */ String l;
    final /* synthetic */ NexProjectHeader m;
    final /* synthetic */ boolean n;
    final /* synthetic */ int o;
    final /* synthetic */ Task p;
    final /* synthetic */ VideoEditor q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sb(VideoEditor videoEditor, KMProto.KMProject kMProject, ResultTask resultTask, NexProjectHeader nexProjectHeader, int i, boolean z, String str, NexProjectHeader nexProjectHeader2, boolean z2, int i2, Task task) {
        boolean z3;
        this.q = videoEditor;
        this.f20362g = kMProject;
        this.f20363h = resultTask;
        this.i = nexProjectHeader;
        this.j = i;
        this.k = z;
        this.l = str;
        this.m = nexProjectHeader2;
        this.n = z2;
        this.o = i2;
        this.p = task;
        z3 = this.q.I;
        this.f20358c = z3;
        this.f20359d = true;
        this.f20360e = false;
        this.f20361f = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        AtomicInteger atomicInteger;
        File file;
        File file2;
        String[] strArr;
        File file3;
        File file4;
        int i;
        int i2;
        int i3;
        File file5;
        File file6;
        File file7;
        File file8;
        com.nexstreaming.app.general.util.u uVar;
        boolean z;
        boolean z2;
        File file9;
        File file10;
        File file11;
        this.f20356a = this.f20362g.toByteArray();
        this.f20363h.awaitTaskCompletion();
        this.i.jpegThumbnail = null;
        if (this.f20363h.didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
            Bitmap bitmap = (Bitmap) this.f20363h.getResult();
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.i.jpegThumbnail = byteArrayOutputStream.toByteArray();
            }
        } else {
            this.f20363h.didSignalEvent(Task.Event.FAIL);
        }
        this.f20357b = this.i.asProtoBuf().toByteArray();
        atomicInteger = this.q.A;
        if (atomicInteger.get() == this.j) {
            file = this.q.F;
            if (file != null) {
                file2 = this.q.F;
                String name = file2.getName();
                strArr = VideoEditor.f20260a;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    String str = strArr[i4];
                    if (name.endsWith(str)) {
                        name = name.substring(0, name.length() - str.length());
                        break;
                    }
                    i4++;
                }
                file3 = this.q.F;
                file3.exists();
                file4 = this.q.F;
                File file12 = new File(file4.getParentFile(), ".kinemaster_save.tmp");
                file12.delete();
                boolean z3 = file12.getParentFile().getFreeSpace() < ((long) (((this.f20357b.length + this.f20356a.length) + 32) + 65536));
                try {
                    HeaderDelimitedOutputStream headerDelimitedOutputStream = new HeaderDelimitedOutputStream(file12);
                    try {
                        headerDelimitedOutputStream.write(243);
                        headerDelimitedOutputStream.write(75);
                        headerDelimitedOutputStream.write(77);
                        headerDelimitedOutputStream.write(234);
                        headerDelimitedOutputStream.writeInt(1);
                        i = VideoEditor.f20261b;
                        headerDelimitedOutputStream.writeSection(i, this.f20357b);
                        i2 = VideoEditor.f20262c;
                        headerDelimitedOutputStream.writeSection(i2, this.f20356a);
                        i3 = VideoEditor.f20263d;
                        headerDelimitedOutputStream.writeSection(i3, null);
                        if (!this.k) {
                            file5 = this.q.F;
                            File file13 = new File(file5.getParent(), name + ".kmproject");
                            file6 = this.q.F;
                            if (file13.equals(file6)) {
                                file9 = this.q.F;
                                File file14 = new File(file9.getParent(), name + ".kmproject." + this.l + ".bak");
                                if (file14.exists()) {
                                    file14.delete();
                                }
                                file10 = this.q.F;
                                file10.renameTo(file14);
                                file11 = this.q.F;
                                file12.renameTo(file11);
                                this.f20360e = true;
                            } else {
                                file13.delete();
                                if (file12.renameTo(file13)) {
                                    StringBuilder sb = new StringBuilder();
                                    file7 = this.q.F;
                                    sb.append(file7.getAbsolutePath());
                                    sb.append(".bak");
                                    File file15 = new File(sb.toString());
                                    file8 = this.q.F;
                                    file8.renameTo(file15);
                                    this.q.F = file13;
                                    uVar = this.q.m;
                                    uVar.a((u.a) new rb(this));
                                }
                            }
                            z = this.q.I;
                            if (!z) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    z2 = this.q.L;
                                    jSONObject.put("Type", z2 ? "Empty" : "Assistant");
                                } catch (JSONException e2) {
                                    Log.e("VideoEditor", "MixPanel json err", e2);
                                }
                            }
                            this.q.I = true;
                        }
                    } finally {
                        C1702f.a(headerDelimitedOutputStream);
                    }
                } catch (IOException e3) {
                    if (EditorGlobal.p) {
                        Crashlytics.log("[VideoEditor] " + e3.getMessage());
                    }
                    if (z3) {
                        this.f20361f = NexEditor.b.vb;
                    } else {
                        String localizedMessage = e3.getLocalizedMessage();
                        if (localizedMessage == null || localizedMessage.length() < 1) {
                            localizedMessage = e3.getMessage();
                        }
                        if (localizedMessage == null || localizedMessage.length() < 1) {
                            localizedMessage = e3.getClass().getSimpleName();
                        }
                        this.f20361f = Task.makeTaskError(localizedMessage, e3);
                    }
                    e3.getMessage();
                    Log.d("VideoEditor", "save project failed", e3);
                    this.f20359d = false;
                    return null;
                }
            } else {
                this.f20359d = false;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r5) {
        int i;
        boolean z;
        boolean z2;
        com.nexstreaming.app.general.util.M m;
        if (this.f20360e) {
            NexProjectHeader nexProjectHeader = this.m;
            NexProjectHeader nexProjectHeader2 = this.i;
            nexProjectHeader.savedOnPlatform = nexProjectHeader2.savedOnPlatform;
            nexProjectHeader.savedWithKMVersion = nexProjectHeader2.savedWithKMVersion;
            nexProjectHeader.savedWithKMVersionName = nexProjectHeader2.savedWithKMVersionName;
        }
        VideoEditor.l(this.q);
        if (!this.n) {
            m = this.q.T;
            m.c(new VideoEditor.k(this.f20356a, this.o));
        }
        Task.TaskError taskError = this.f20361f;
        if (taskError != null) {
            this.q.a(taskError);
            this.p.sendFailure(this.f20361f);
        } else {
            this.p.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        }
        i = this.q.z;
        if (i < 1) {
            z = this.q.E;
            if (!z) {
                z2 = this.q.D;
                if (z2) {
                    this.q.D = false;
                    this.q.O();
                    return;
                }
                return;
            }
            this.q.E = false;
            this.q.G();
        }
    }
}
