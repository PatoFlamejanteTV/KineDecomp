package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.Context;
import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BasicMediaStoreItem.java */
/* loaded from: classes.dex */
public class a implements MediaStoreItem {
    private static Map<String, WeakReference<a>> D = new HashMap();
    private static int E = 0;
    private ResultTask<MediaStoreItem.MediaSupportType> B;
    private WeakReference<MediaStoreItem> C;

    /* renamed from: a */
    private final MediaItemType f3557a;
    private final MSID b;
    private InterfaceC0071a x;
    private b y;
    private int c = 0;
    private String d = null;
    private Date e = null;
    private Date f = null;
    private Date g = null;
    private long h = 0;
    private long i = 0;
    private long j = -1;
    private String k = null;
    private long l = -1;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = 0;
    private int q = -1;
    private int r = -1;
    private boolean s = false;
    private MediaStoreItem.MediaSupportType t = MediaStoreItem.MediaSupportType.Unknown;
    private boolean u = false;
    private boolean v = false;
    private Map<String, Bundle> w = null;
    private int z = 0;
    private int A = 0;
    private boolean F = false;

    /* compiled from: BasicMediaStoreItem.java */
    /* renamed from: com.nexstreaming.kinemaster.mediastore.v2.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
        void a(a aVar);
    }

    /* compiled from: BasicMediaStoreItem.java */
    /* loaded from: classes.dex */
    public interface b {
        ResultTask<MediaStoreItem.MediaSupportType> a(a aVar);
    }

    private void g(int i) {
        if ((this.z & i) == 0) {
            if (this.x != null && !this.F) {
                this.F = true;
                this.x.a(this);
                this.F = false;
            }
            if ((this.z & i) == 0) {
                int i2 = i & (this.z ^ (-1));
                String str = (i2 & 1) != 0 ? "SUPPORT_TYPE," : "";
                if ((i2 & 2) != 0) {
                    str = str + "SET_DIMENSIONS,";
                }
                if ((i2 & 4) != 0) {
                    str = str + "SET_SIZE,";
                }
                if ((i2 & 8) != 0) {
                    str = str + "SET_DURATION,";
                }
                if ((i2 & 16) != 0) {
                    str = str + "SET_NUM_VIDEO_ITEMS,";
                }
                if ((i2 & 32) != 0) {
                    str = str + "SET_NUM_IMAGE_ITEMS,";
                }
                if ((i2 & 64) != 0) {
                    str = str + "SET_PATH,";
                }
                if ((i2 & 128) != 0) {
                    str = str + "SET_FPS,";
                }
                if ((i2 & 256) != 0) {
                    str = str + "SET_HAS_AUDIO,";
                }
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
                throw new MediaStore.UnavailableDataException(str);
            }
        }
    }

    public MediaStoreItem a() {
        MediaStoreItem mediaStoreItem = this.C == null ? null : this.C.get();
        if (mediaStoreItem == null) {
            k kVar = new k(this);
            this.C = new WeakReference<>(kVar);
            return kVar;
        }
        return mediaStoreItem;
    }

    public void a(InterfaceC0071a interfaceC0071a) {
        this.x = interfaceC0071a;
    }

    public void a(b bVar) {
        this.y = bVar;
    }

    public static a a(MediaItemType mediaItemType, String str, String str2) {
        return a(mediaItemType, new MSID(str, str2));
    }

    public static a a(MediaItemType mediaItemType, MSID msid) {
        a aVar;
        if (mediaItemType == null) {
            throw new NullPointerException("type requried");
        }
        if (msid == null) {
            throw new NullPointerException("id requried");
        }
        WeakReference<a> weakReference = D.get(msid);
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            u();
            aVar = new a(mediaItemType, msid);
            synchronized (D) {
                D.put(msid.toString(), new WeakReference<>(aVar));
            }
        }
        return aVar;
    }

    private static void u() {
        HashSet hashSet;
        int i = E + 1;
        E = i;
        if (i >= 30) {
            E = 0;
            HashSet hashSet2 = null;
            synchronized (D) {
                for (Map.Entry<String, WeakReference<a>> entry : D.entrySet()) {
                    if (entry.getValue() == null || entry.getValue().get() == null) {
                        HashSet hashSet3 = hashSet2 == null ? new HashSet() : hashSet2;
                        hashSet3.add(entry.getKey());
                        hashSet = hashSet3;
                    } else {
                        hashSet = hashSet2;
                    }
                    hashSet2 = hashSet;
                }
                if (hashSet2 != null) {
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        D.remove((String) it.next());
                    }
                }
            }
        }
    }

    public a(MediaItemType mediaItemType, MSID msid) {
        this.f3557a = mediaItemType;
        this.b = msid;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MediaItemType b() {
        return this.f3557a;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MSID c() {
        return this.b;
    }

    public void a(String str) {
        this.d = str;
        this.c = 0;
    }

    public void a(int i) {
        this.d = null;
        this.c = i;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String a(Context context) {
        if (this.d != null) {
            return this.d;
        }
        if (this.c == 0 || context == null) {
            return null;
        }
        return context.getResources().getText(this.c).toString();
    }

    public void a(long j) {
        this.e = new Date(j);
        this.h = j;
    }

    public void b(long j) {
        this.g = new Date(j);
        this.j = j;
    }

    public void b(int i) {
        this.q = i;
        this.z |= 16;
    }

    public void c(int i) {
        this.r = i;
        this.z |= 32;
    }

    public int d() {
        g(16);
        return this.q;
    }

    public int e() {
        g(32);
        return this.r;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public Date f() {
        if (this.f3557a == MediaItemType.FOLDER && this.g == null) {
            throw new UnsupportedOperationException();
        }
        return this.g;
    }

    public long g() {
        return this.j;
    }

    public void b(String str) {
        this.k = str;
        this.z |= 64;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String h() {
        g(64);
        return this.k;
    }

    public void c(long j) {
        this.z |= 4;
        this.l = j;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public long i() {
        g(4);
        return this.l;
    }

    public void a(int i, int i2) {
        this.z |= 2;
        this.m = i;
        this.n = i2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int j() {
        g(2);
        return this.m;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int k() {
        g(2);
        return this.n;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int l() {
        return this.p;
    }

    public void d(int i) {
        this.p = i;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int m() {
        g(8);
        return this.o;
    }

    public void e(int i) {
        this.o = i;
        this.z |= 8;
    }

    public void a(boolean z) {
        this.u = z;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean n() {
        if (!this.u && !new File(h()).exists()) {
            this.u = true;
        }
        return this.u;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String o() {
        return this.b.getNamespace();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public synchronized Bundle a(Class<?> cls) {
        Bundle bundle;
        String name = cls.getName();
        if (this.w == null) {
            this.w = new HashMap();
        }
        bundle = this.w.get(name);
        if (bundle == null) {
            bundle = new Bundle();
            this.w.put(name, bundle);
        }
        return bundle;
    }

    public synchronized Bundle b(Class<?> cls) {
        Bundle bundle;
        String name = cls.getName();
        if (this.w == null) {
            this.w = new HashMap();
        }
        bundle = new Bundle();
        this.w.put(name, bundle);
        return bundle;
    }

    public void a(MediaStoreItem.MediaSupportType mediaSupportType) {
        this.t = mediaSupportType;
        this.z |= 1;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MediaStoreItem.MediaSupportType p() {
        g(1);
        return this.t;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public ResultTask<MediaStoreItem.MediaSupportType> q() {
        if (this.B != null && this.B.isRunning()) {
            return this.B;
        }
        if (this.y != null) {
            this.B = this.y.a(this);
            return this.B;
        }
        return ResultTask.completedResultTask(p());
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean r() {
        return this.v;
    }

    public void b(boolean z) {
        this.v = z;
    }

    public void f(int i) {
        this.A = i;
        this.z |= 128;
    }

    public void c(boolean z) {
        this.s = z;
        this.z |= 256;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int s() {
        g(128);
        return this.A;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean t() {
        g(256);
        return this.s;
    }
}
