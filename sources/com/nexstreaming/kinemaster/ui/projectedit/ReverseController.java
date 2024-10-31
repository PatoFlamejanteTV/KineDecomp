package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* compiled from: ReverseController.kt */
/* loaded from: classes2.dex */
public final class ReverseController implements com.nexstreaming.kinemaster.ui.a.l {

    /* renamed from: c */
    private com.nexstreaming.kinemaster.ui.a.p f22058c;

    /* renamed from: d */
    private long f22059d;

    /* renamed from: e */
    private final Hg f22060e;

    /* renamed from: f */
    private final Context f22061f;

    /* renamed from: g */
    private final String f22062g;

    /* renamed from: h */
    private final String f22063h;
    private final String i;
    private final int j;
    private final int k;
    private final long l;
    private final c m;

    /* renamed from: b */
    public static final b f22057b = new b(null);

    /* renamed from: a */
    private static final String f22056a = f22056a;

    /* renamed from: a */
    private static final String f22056a = f22056a;

    /* compiled from: ReverseController.kt */
    /* loaded from: classes2.dex */
    public enum ReverseResult {
        RESULT_OK,
        RESULT_CANCEL,
        RESULT_UNSUPPORT_DURATION,
        RESULT_CLIP_INFO_ERROR,
        RESULT_NO_SPACE,
        RESULT_ERROR_ENGINE_BUSY,
        RESULT_ERROR_UNKNOWN;

        public final boolean isSuccess() {
            return this == RESULT_OK;
        }
    }

    /* compiled from: ReverseController.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public final ReverseController a(Context context, String str, String str2, String str3, int i, int i2, long j, c cVar) {
            kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
            kotlin.jvm.internal.h.b(str, "srcPath");
            kotlin.jvm.internal.h.b(str2, "dstPath");
            kotlin.jvm.internal.h.b(str3, "tmpPath");
            kotlin.jvm.internal.h.b(cVar, "listener");
            return new ReverseController(context, str, str2, str3, i, i2, j, cVar);
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ReverseController.kt */
    /* loaded from: classes2.dex */
    public interface c {
        void a(ReverseResult reverseResult, File file);
    }

    public ReverseController(Context context, String str, String str2, String str3, int i, int i2, long j, c cVar) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, "srcPath");
        kotlin.jvm.internal.h.b(str2, "dstPath");
        kotlin.jvm.internal.h.b(str3, "tmpPath");
        kotlin.jvm.internal.h.b(cVar, "onReverseListener");
        this.f22061f = context;
        this.f22062g = str;
        this.f22063h = str2;
        this.i = str3;
        this.j = i;
        this.k = i2;
        this.l = j;
        this.m = cVar;
        this.f22060e = new Hg(this);
    }

    public final NexEditor i() {
        NexEditor i = EditorGlobal.i();
        kotlin.jvm.internal.h.a((Object) i, "EditorGlobal.getNexEditor()");
        return i;
    }

    public final c e() {
        return this.m;
    }

    public final String f() {
        return this.f22062g;
    }

    public final int g() {
        return this.j;
    }

    public final String h() {
        return this.i;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.l
    public void start() {
        com.nexstreaming.kinemaster.ui.a.p pVar = this.f22058c;
        if (pVar != null) {
            String string = this.f22061f.getString(R.string.reverse_dialog_message_prepare);
            kotlin.jvm.internal.h.a((Object) string, "context.getString(R.stri…e_dialog_message_prepare)");
            pVar.e(string);
            this.f22059d = System.currentTimeMillis();
            new a(this.f22062g, this.j, this.k, new Ig(this)).execute(new Void[0]);
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.l
    public void stop() {
        i().reverseStop();
    }

    public final String b() {
        return this.f22063h;
    }

    public final int c() {
        return this.k;
    }

    public final long d() {
        return this.l;
    }

    public final Context a() {
        return this.f22061f;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.l
    public void a(com.nexstreaming.kinemaster.ui.a.p pVar) {
        kotlin.jvm.internal.h.b(pVar, "nfsdi");
        this.f22058c = pVar;
    }

    /* compiled from: ReverseController.kt */
    /* loaded from: classes2.dex */
    public static final class a extends AsyncTask<Void, Float, NexClipInfo> {

        /* renamed from: a */
        private int f22064a;

        /* renamed from: b */
        private final String f22065b;

        /* renamed from: c */
        private final int f22066c;

        /* renamed from: d */
        private final int f22067d;

        /* renamed from: e */
        private final InterfaceC0115a f22068e;

        /* compiled from: ReverseController.kt */
        /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ReverseController$a$a */
        /* loaded from: classes2.dex */
        public interface InterfaceC0115a {
            void a(NexClipInfo nexClipInfo, int i);
        }

        public a(String str, int i, int i2, InterfaceC0115a interfaceC0115a) {
            kotlin.jvm.internal.h.b(str, "srcPath");
            kotlin.jvm.internal.h.b(interfaceC0115a, "listener");
            this.f22065b = str;
            this.f22066c = i;
            this.f22067d = i2;
            this.f22068e = interfaceC0115a;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public NexClipInfo doInBackground(Void... voidArr) {
            int[] iArr;
            int i;
            kotlin.jvm.internal.h.b(voidArr, NativeProtocol.WEB_DIALOG_PARAMS);
            if (this.f22067d - this.f22066c < 1000) {
                return null;
            }
            NexClipInfo nexClipInfo = new NexClipInfo();
            int i2 = 0;
            NexEditor.b a2 = EditorGlobal.i().a(this.f22065b, nexClipInfo, true, 0);
            kotlin.jvm.internal.h.a((Object) a2, "result");
            if (a2.c() || (iArr = nexClipInfo.mSeekTable) == null) {
                return null;
            }
            if (iArr.length == 1) {
                i = nexClipInfo.mVideoDuration;
            } else {
                i = 0;
                while (true) {
                    int[] iArr2 = nexClipInfo.mSeekTable;
                    if (i2 >= iArr2.length - 1) {
                        break;
                    }
                    int i3 = iArr2[i2];
                    int i4 = i2 + 1;
                    int i5 = iArr2[i4];
                    if (i5 >= this.f22066c) {
                        int i6 = i5 - i3;
                        if (i <= i6) {
                            i = i6;
                        }
                        if (i3 > this.f22067d) {
                            break;
                        }
                    }
                    i2 = i4;
                }
                if (i == 0) {
                    i = nexClipInfo.mVideoDuration - nexClipInfo.mSeekTable[i2];
                }
            }
            int i7 = nexClipInfo.mFPS;
            if (i7 == 0) {
                i7 = 1;
            }
            double d2 = (i / i7) * nexClipInfo.mVideoWidth * nexClipInfo.mVideoHeight;
            Double.isNaN(d2);
            this.f22064a = (int) (d2 * 1.5d * 1.2d);
            return nexClipInfo;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(NexClipInfo nexClipInfo) {
            super.onPostExecute(nexClipInfo);
            this.f22068e.a(nexClipInfo, this.f22064a);
        }
    }
}
