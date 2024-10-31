package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.InputStream;

/* compiled from: ProjectLoadingTask.java */
/* loaded from: classes.dex */
public abstract class Aa extends AsyncTask<Void, Void, C1780za> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f20173a = a('K', 'H', 'D', 'R');

    /* renamed from: b, reason: collision with root package name */
    private static final int f20174b = a('T', 'L', 'I', 'N');

    /* renamed from: c, reason: collision with root package name */
    private static final int f20175c = a('F', 'T', 'R', 'X');

    /* renamed from: e, reason: collision with root package name */
    private final Context f20177e;

    /* renamed from: f, reason: collision with root package name */
    private final InputStream f20178f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f20179g;

    /* renamed from: d, reason: collision with root package name */
    private Task.TaskError f20176d = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f20180h = false;

    public Aa(Context context, InputStream inputStream, boolean z) {
        this.f20177e = context;
        this.f20178f = inputStream;
        this.f20179g = z;
    }

    private static final int a(char c2, char c3, char c4, char c5) {
        return ((c2 & 255) << 24) | ((c3 & 255) << 16) | ((c4 & 255) << 8) | (c5 & 255);
    }

    protected abstract void a(Task.TaskError taskError);

    protected abstract void a(NexTimeline nexTimeline);

    public void a(boolean z) {
        this.f20180h = z;
    }

    protected abstract void b(C1780za c1780za);

    private Context a() {
        return this.f20177e;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:123:0x0170
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0174 A[Catch: all -> 0x022c, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x022c, blocks: (B:6:0x002a, B:163:0x0033, B:164:0x003e, B:166:0x0041, B:9:0x0062, B:12:0x0069, B:14:0x006f, B:18:0x0075, B:24:0x008f, B:26:0x0174, B:34:0x018a, B:36:0x018e, B:37:0x0191, B:39:0x019b, B:41:0x01a3, B:43:0x01ab, B:45:0x01ae, B:49:0x01b1, B:51:0x01b5, B:53:0x01be, B:56:0x01cf, B:61:0x01e3, B:62:0x020d, B:64:0x01da, B:65:0x01c6, B:68:0x0213, B:88:0x00ae, B:89:0x00b1, B:79:0x00a2, B:91:0x00b3, B:98:0x00c5, B:100:0x00c9, B:102:0x00cf, B:104:0x00d5, B:106:0x00dc, B:109:0x00e4, B:117:0x00fa, B:119:0x00fe, B:124:0x0111, B:127:0x011e, B:129:0x0124, B:131:0x012d, B:146:0x0133, B:135:0x0144, B:140:0x014a, B:154:0x015e, B:175:0x0053), top: B:5:0x002a, inners: #2, #3, #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018a A[Catch: all -> 0x022c, TRY_ENTER, TryCatch #5 {all -> 0x022c, blocks: (B:6:0x002a, B:163:0x0033, B:164:0x003e, B:166:0x0041, B:9:0x0062, B:12:0x0069, B:14:0x006f, B:18:0x0075, B:24:0x008f, B:26:0x0174, B:34:0x018a, B:36:0x018e, B:37:0x0191, B:39:0x019b, B:41:0x01a3, B:43:0x01ab, B:45:0x01ae, B:49:0x01b1, B:51:0x01b5, B:53:0x01be, B:56:0x01cf, B:61:0x01e3, B:62:0x020d, B:64:0x01da, B:65:0x01c6, B:68:0x0213, B:88:0x00ae, B:89:0x00b1, B:79:0x00a2, B:91:0x00b3, B:98:0x00c5, B:100:0x00c9, B:102:0x00cf, B:104:0x00d5, B:106:0x00dc, B:109:0x00e4, B:117:0x00fa, B:119:0x00fe, B:124:0x0111, B:127:0x011e, B:129:0x0124, B:131:0x012d, B:146:0x0133, B:135:0x0144, B:140:0x014a, B:154:0x015e, B:175:0x0053), top: B:5:0x002a, inners: #2, #3, #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e3 A[Catch: all -> 0x022c, TryCatch #5 {all -> 0x022c, blocks: (B:6:0x002a, B:163:0x0033, B:164:0x003e, B:166:0x0041, B:9:0x0062, B:12:0x0069, B:14:0x006f, B:18:0x0075, B:24:0x008f, B:26:0x0174, B:34:0x018a, B:36:0x018e, B:37:0x0191, B:39:0x019b, B:41:0x01a3, B:43:0x01ab, B:45:0x01ae, B:49:0x01b1, B:51:0x01b5, B:53:0x01be, B:56:0x01cf, B:61:0x01e3, B:62:0x020d, B:64:0x01da, B:65:0x01c6, B:68:0x0213, B:88:0x00ae, B:89:0x00b1, B:79:0x00a2, B:91:0x00b3, B:98:0x00c5, B:100:0x00c9, B:102:0x00cf, B:104:0x00d5, B:106:0x00dc, B:109:0x00e4, B:117:0x00fa, B:119:0x00fe, B:124:0x0111, B:127:0x011e, B:129:0x0124, B:131:0x012d, B:146:0x0133, B:135:0x0144, B:140:0x014a, B:154:0x015e, B:175:0x0053), top: B:5:0x002a, inners: #2, #3, #16 }] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.nexstreaming.kinemaster.editorwrapper.C1780za doInBackground(java.lang.Void... r14) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.editorwrapper.Aa.doInBackground(java.lang.Void[]):com.nexstreaming.kinemaster.editorwrapper.za");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onPostExecute(C1780za c1780za) {
        if (c1780za == null) {
            a(this.f20176d);
        } else {
            b(c1780za);
        }
    }
}
