package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.InputStream;

/* compiled from: ProjectLoadingTask.java */
/* loaded from: classes.dex */
public abstract class as extends AsyncTask<Void, Void, ar> {

    /* renamed from: a */
    private static final int f3320a = a('K', 'H', 'D', 'R');
    private static final int b = a('T', 'L', 'I', 'N');
    private static final int c = a('F', 'T', 'R', 'X');
    private final Context e;
    private final InputStream f;
    private final boolean g;
    private final EffectLibrary h;
    private Task.TaskError d = null;
    private boolean i = false;

    protected abstract void a(Task.TaskError taskError);

    protected abstract void a(NexTimeline nexTimeline);

    protected abstract void b(ar arVar);

    public as(Context context, InputStream inputStream, boolean z) {
        this.e = context;
        this.f = inputStream;
        this.g = z;
        this.h = EffectLibrary.a(context);
    }

    public void a(boolean z) {
        this.i = z;
    }

    private EffectLibrary a() {
        return this.h;
    }

    private Context b() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0098 A[Catch: all -> 0x028d, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x028d, blocks: (B:7:0x0023, B:149:0x0029, B:150:0x0034, B:152:0x0037, B:9:0x0068, B:11:0x006c, B:13:0x0073, B:17:0x007a, B:23:0x0092, B:26:0x0098, B:34:0x01bd, B:36:0x01c1, B:37:0x01c4, B:39:0x01d4, B:41:0x01dc, B:43:0x01e4, B:45:0x01e7, B:49:0x01eb, B:51:0x01ef, B:53:0x01fd, B:56:0x026f, B:58:0x0277, B:60:0x0219, B:61:0x0245, B:63:0x0287, B:64:0x0205, B:66:0x020b, B:67:0x024e, B:80:0x00c4, B:76:0x00d7, B:77:0x00da, B:87:0x00dc, B:93:0x00fa, B:95:0x00fe, B:97:0x0105, B:99:0x010c, B:101:0x0113, B:104:0x019f, B:111:0x011a, B:113:0x011e, B:116:0x0131, B:119:0x013e, B:121:0x0144, B:123:0x014c, B:126:0x0152, B:129:0x0166, B:132:0x016c, B:142:0x0181, B:160:0x004a), top: B:6:0x0023, inners: #10, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01bd A[Catch: all -> 0x028d, TRY_ENTER, TryCatch #7 {all -> 0x028d, blocks: (B:7:0x0023, B:149:0x0029, B:150:0x0034, B:152:0x0037, B:9:0x0068, B:11:0x006c, B:13:0x0073, B:17:0x007a, B:23:0x0092, B:26:0x0098, B:34:0x01bd, B:36:0x01c1, B:37:0x01c4, B:39:0x01d4, B:41:0x01dc, B:43:0x01e4, B:45:0x01e7, B:49:0x01eb, B:51:0x01ef, B:53:0x01fd, B:56:0x026f, B:58:0x0277, B:60:0x0219, B:61:0x0245, B:63:0x0287, B:64:0x0205, B:66:0x020b, B:67:0x024e, B:80:0x00c4, B:76:0x00d7, B:77:0x00da, B:87:0x00dc, B:93:0x00fa, B:95:0x00fe, B:97:0x0105, B:99:0x010c, B:101:0x0113, B:104:0x019f, B:111:0x011a, B:113:0x011e, B:116:0x0131, B:119:0x013e, B:121:0x0144, B:123:0x014c, B:126:0x0152, B:129:0x0166, B:132:0x016c, B:142:0x0181, B:160:0x004a), top: B:6:0x0023, inners: #10, #16, #17 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x029c -> B:110:0x0096). Please report as a decompilation issue!!! */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.nexstreaming.kinemaster.editorwrapper.ar doInBackground(java.lang.Void... r10) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.editorwrapper.as.doInBackground(java.lang.Void[]):com.nexstreaming.kinemaster.editorwrapper.ar");
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public final void onPostExecute(ar arVar) {
        if (arVar == null) {
            a(this.d);
        } else {
            b(arVar);
        }
    }

    private static final int a(char c2, char c3, char c4, char c5) {
        return ((c2 & 255) << 24) | ((c3 & 255) << 16) | ((c4 & 255) << 8) | (c5 & 255);
    }
}
