package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nexstreaming.kinemaster.wire.HeaderDelimitedOutputStream;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexProjectHeader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class cl extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    byte[] f3365a = null;
    byte[] b = null;
    boolean c;
    boolean d;
    final /* synthetic */ KMProto.KMProject e;
    final /* synthetic */ ResultTask f;
    final /* synthetic */ NexProjectHeader g;
    final /* synthetic */ int h;
    final /* synthetic */ boolean i;
    final /* synthetic */ boolean j;
    final /* synthetic */ int k;
    final /* synthetic */ Task l;
    final /* synthetic */ VideoEditor m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(VideoEditor videoEditor, KMProto.KMProject kMProject, ResultTask resultTask, NexProjectHeader nexProjectHeader, int i, boolean z, boolean z2, int i2, Task task) {
        boolean z3;
        this.m = videoEditor;
        this.e = kMProject;
        this.f = resultTask;
        this.g = nexProjectHeader;
        this.h = i;
        this.i = z;
        this.j = z2;
        this.k = i2;
        this.l = task;
        z3 = this.m.H;
        this.c = z3;
        this.d = true;
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
        com.nexstreaming.app.general.util.m mVar;
        boolean z;
        Context P;
        Context P2;
        boolean z2;
        File file9;
        File file10;
        this.f3365a = this.e.toByteArray();
        this.f.awaitTaskCompletion();
        this.g.jpegThumbnail = null;
        if (this.f.didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
            Bitmap bitmap = (Bitmap) this.f.getResult();
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.g.jpegThumbnail = byteArrayOutputStream.toByteArray();
            }
        } else if (this.f.didSignalEvent(Task.Event.FAIL)) {
        }
        this.b = this.g.asProtoBuf().toByteArray();
        atomicInteger = this.m.z;
        if (atomicInteger.get() == this.h) {
            file = this.m.E;
            if (file != null) {
                file2 = this.m.E;
                String name = file2.getName();
                strArr = VideoEditor.q;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    String str = strArr[i4];
                    if (!name.endsWith(str)) {
                        i4++;
                    } else {
                        name = name.substring(0, name.length() - str.length());
                        break;
                    }
                }
                file3 = this.m.E;
                file3.exists();
                file4 = this.m.E;
                File file11 = new File(file4.getParentFile(), ".kinemaster_save.tmp");
                file11.delete();
                try {
                    HeaderDelimitedOutputStream headerDelimitedOutputStream = new HeaderDelimitedOutputStream(file11);
                    try {
                        headerDelimitedOutputStream.write(243);
                        headerDelimitedOutputStream.write(75);
                        headerDelimitedOutputStream.write(77);
                        headerDelimitedOutputStream.write(234);
                        headerDelimitedOutputStream.writeInt(1);
                        i = VideoEditor.r;
                        headerDelimitedOutputStream.writeSection(i, this.b);
                        i2 = VideoEditor.s;
                        headerDelimitedOutputStream.writeSection(i2, this.f3365a);
                        i3 = VideoEditor.t;
                        headerDelimitedOutputStream.writeSection(i3, null);
                        if (!this.i) {
                            file5 = this.m.E;
                            File file12 = new File(file5.getParent(), name + ".kmproject");
                            file6 = this.m.E;
                            if (file12.equals(file6)) {
                                file9 = this.m.E;
                                file9.delete();
                                file10 = this.m.E;
                                file11.renameTo(file10);
                            } else {
                                if (file12.delete()) {
                                }
                                if (file11.renameTo(file12)) {
                                    StringBuilder sb = new StringBuilder();
                                    file7 = this.m.E;
                                    File file13 = new File(sb.append(file7.getAbsolutePath()).append(".bak").toString());
                                    file8 = this.m.E;
                                    if (file8.renameTo(file13)) {
                                    }
                                    this.m.E = file12;
                                    mVar = this.m.j;
                                    mVar.a((m.a) new cm(this));
                                }
                            }
                            z = this.m.H;
                            if (!z) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    z2 = this.m.K;
                                    jSONObject.put("Type", z2 ? "Empty" : "Assistant");
                                } catch (JSONException e) {
                                    Log.e("VideoEditor", "MixPanel json err", e);
                                }
                                P = this.m.P();
                                KMUsage.getMixpanelInstanceFromContext(P).a("Add Project", jSONObject);
                                P2 = this.m.P();
                                KMUsage.getMixpanelPeople(P2).a("Project Count", 1.0d);
                            }
                            this.m.H = true;
                        }
                    } finally {
                        headerDelimitedOutputStream.close();
                    }
                } catch (IOException e2) {
                    Log.d("VideoEditor", "save project failed", e2);
                    this.d = false;
                }
            } else {
                this.d = false;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r7) {
        int i;
        boolean z;
        boolean z2;
        com.nexstreaming.app.general.util.y yVar;
        VideoEditor.c cVar;
        VideoEditor.c cVar2;
        if (!this.c && !this.i) {
            cVar = this.m.N;
            if (cVar != null) {
                cVar2 = this.m.N;
                cVar2.a(this.d);
                this.m.N = null;
            }
        }
        VideoEditor.p(this.m);
        if (!this.j) {
            yVar = this.m.O;
            yVar.c(new VideoEditor.k(this.f3365a, this.k));
        }
        this.l.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        i = this.m.y;
        if (i < 1) {
            z = this.m.D;
            if (z) {
                this.m.D = false;
                this.m.j();
                return;
            }
            z2 = this.m.C;
            if (z2) {
                this.m.C = false;
                this.m.i();
            }
        }
    }
}
