package com.nexstreaming.kinemaster.mediastore;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteMediaInfo.java */
/* loaded from: classes.dex */
public class i extends AsyncTask<Void, Void, Task.TaskError> {

    /* renamed from: a, reason: collision with root package name */
    RemoteMediaInfo f20895a;

    /* renamed from: b, reason: collision with root package name */
    boolean f20896b = false;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f20897c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Map f20898d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ResultTask f20899e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Map map, ResultTask resultTask) {
        this.f20897c = str;
        this.f20898d = map;
        this.f20899e = resultTask;
    }

    boolean a(ByteBuffer byteBuffer) {
        if (byteBuffer.limit() > 7) {
            if (byteBuffer.get(0) == 0 && byteBuffer.get(1) == 0 && byteBuffer.get(2) == 0 && byteBuffer.get(3) == 1 && (byteBuffer.get(4) & 31) == 7) {
                this.f20895a.f20880e = byteBuffer.get(5);
                this.f20895a.f20881f = byteBuffer.get(7);
                this.f20896b = true;
                return true;
            }
            if (byteBuffer.get(0) == 0 && byteBuffer.get(1) == 0 && byteBuffer.get(2) == 1 && (byteBuffer.get(3) & 31) == 7) {
                this.f20895a.f20880e = byteBuffer.get(4);
                this.f20895a.f20881f = byteBuffer.get(6);
                this.f20896b = true;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02f1, code lost:            if (r0.equals("video/avc") == false) goto L85;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0261 A[LOOP:5: B:68:0x025d->B:70:0x0261, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0253 A[EDGE_INSN: B:83:0x0253->B:67:0x0253 BREAK  A[LOOP:4: B:58:0x0204->B:81:0x0204], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [boolean] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.nexstreaming.app.general.task.Task.TaskError doInBackground(java.lang.Void... r24) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediastore.i.doInBackground(java.lang.Void[]):com.nexstreaming.app.general.task.Task$TaskError");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Task.TaskError taskError) {
        if (taskError != null) {
            this.f20899e.sendFailure(taskError);
        } else {
            this.f20899e.sendResult(this.f20895a);
        }
        super.onPostExecute(taskError);
    }
}
