package com.nexstreaming.kinemaster.mediastore.item;

import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: BasicMediaStoreItem.kt */
/* loaded from: classes.dex */
public class b implements com.nexstreaming.kinemaster.mediastore.item.c {
    private static int m;
    private boolean A;
    private MediaSupportType B;
    private boolean C;
    private boolean D;
    private Map<String, Bundle> E;
    private a F;
    private InterfaceC0109b G;
    private int H;
    private int I;
    private ResultTask<MediaSupportType> J;
    private WeakReference<com.nexstreaming.kinemaster.mediastore.item.c> K;
    private boolean L;
    private final MediaItemType M;
    private final MediaStoreItemId N;
    private int o;
    private String p;
    private Date q;
    private long r;
    private String s;
    private long t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;
    public static final c n = new c(null);

    /* renamed from: a, reason: collision with root package name */
    public static final int f20910a = KineMasterApplication.f24058f.c().getResources().getDimensionPixelSize(R.dimen.mediabrowser_item_layout_width);

    /* renamed from: b, reason: collision with root package name */
    public static final int f20911b = KineMasterApplication.f24058f.c().getResources().getDimensionPixelSize(R.dimen.mediabrowser_item_layout_height);

    /* renamed from: c, reason: collision with root package name */
    private static final int f20912c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f20913d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f20914e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final int f20915f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static final int f20916g = 16;

    /* renamed from: h, reason: collision with root package name */
    private static final int f20917h = 32;
    private static final int i = 64;
    private static final int j = 128;
    private static final int k = 256;
    private static final HashMap<String, WeakReference<b>> l = new HashMap<>();

    /* compiled from: BasicMediaStoreItem.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: BasicMediaStoreItem.kt */
    /* renamed from: com.nexstreaming.kinemaster.mediastore.item.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109b {
        ResultTask<MediaSupportType> a(b bVar);
    }

    /* compiled from: BasicMediaStoreItem.kt */
    /* loaded from: classes.dex */
    public static final class c {
        private c() {
        }

        private final void b() {
            b.m++;
            if (b.m < 30) {
                return;
            }
            b.m = 0;
            synchronized (b.l) {
                HashSet hashSet = null;
                for (Map.Entry entry : b.l.entrySet()) {
                    String str = (String) entry.getKey();
                    WeakReference weakReference = (WeakReference) entry.getValue();
                    if (weakReference == null || weakReference.get() == null) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        if (hashSet == null) {
                            h.a();
                            throw null;
                        }
                        hashSet.add(str);
                    }
                }
                if (hashSet != null) {
                    if (hashSet != null) {
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            b.l.remove((String) it.next());
                        }
                    } else {
                        h.a();
                        throw null;
                    }
                }
                k kVar = k.f28545a;
            }
        }

        public final b a(MediaItemType mediaItemType, String str, String str2) {
            h.b(mediaItemType, "type");
            h.b(str, "namespace");
            h.b(str2, "id");
            return a(mediaItemType, new MediaStoreItemId(str, str2));
        }

        public /* synthetic */ c(f fVar) {
            this();
        }

        public final b a(MediaItemType mediaItemType, MediaStoreItemId mediaStoreItemId) {
            b bVar;
            if (mediaItemType == null) {
                throw new NullPointerException("type requried");
            }
            if (mediaStoreItemId != null) {
                WeakReference weakReference = (WeakReference) b.l.get(mediaStoreItemId.getId());
                if (weakReference != null && (bVar = (b) weakReference.get()) != null) {
                    return bVar;
                }
                b();
                b bVar2 = new b(mediaItemType, mediaStoreItemId);
                synchronized (b.l) {
                }
                return bVar2;
            }
            throw new NullPointerException("mediaStoreItemId requried");
        }

        public final void a() {
            HashMap hashMap = b.l;
            if (hashMap != null) {
                hashMap.clear();
            }
        }
    }

    public b(MediaItemType mediaItemType, MediaStoreItemId mediaStoreItemId) {
        h.b(mediaItemType, "mType");
        h.b(mediaStoreItemId, "mId");
        this.M = mediaItemType;
        this.N = mediaStoreItemId;
        this.r = -1L;
        this.t = -1L;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.y = -1;
        this.z = -1;
        this.B = MediaSupportType.Unknown;
    }

    public static final b a(MediaItemType mediaItemType, MediaStoreItemId mediaStoreItemId) {
        return n.a(mediaItemType, mediaStoreItemId);
    }

    public static final b a(MediaItemType mediaItemType, String str, String str2) {
        return n.a(mediaItemType, str, str2);
    }

    private final void h(int i2) {
        if ((this.H & i2) != 0) {
            return;
        }
        a aVar = this.F;
        if (aVar != null && !this.L) {
            this.L = true;
            if (aVar != null) {
                aVar.a(this);
                this.L = false;
            } else {
                h.a();
                throw null;
            }
        }
        int i3 = this.H;
        if ((i3 & i2) == 0) {
            int i4 = i2 & (i3 ^ (-1));
            String str = "";
            if ((f20912c & i4) != 0) {
                str = "SUPPORT_TYPE,";
            }
            if ((f20913d & i4) != 0) {
                str = str + "SET_DIMENSIONS,";
            }
            if ((f20914e & i4) != 0) {
                str = str + "SET_SIZE,";
            }
            if ((f20915f & i4) != 0) {
                str = str + "SET_DURATION,";
            }
            if ((f20916g & i4) != 0) {
                str = str + "SET_NUM_VIDEO_ITEMS,";
            }
            if ((f20917h & i4) != 0) {
                str = str + "SET_NUM_IMAGE_ITEMS,";
            }
            if ((i & i4) != 0) {
                str = str + "SET_PATH,";
            }
            if ((j & i4) != 0) {
                str = str + "SET_FPS,";
            }
            if ((i4 & k) != 0) {
                str = str + "SET_HAS_AUDIO,";
            }
            if (str.length() > 0) {
                int length = str.length() - 1;
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                str = str.substring(0, length);
                h.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            throw new MediaStore.UnavailableDataException(str);
        }
    }

    public static final void k() {
        n.a();
    }

    public final void b(int i2) {
        this.p = null;
        this.o = i2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String c() {
        String str = this.p;
        if (str != null) {
            return str;
        }
        if (this.o != 0) {
            return KineMasterApplication.f24058f.c().getResources().getText(this.o).toString();
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public Date d() {
        if (this.M == MediaItemType.FOLDER && this.q == null) {
            throw new UnsupportedOperationException();
        }
        return this.q;
    }

    public final void e(int i2) {
        this.z = i2;
        this.H |= f20917h;
    }

    public final void f(int i2) {
        this.y = i2;
        this.H |= f20916g;
    }

    public final void g(int i2) {
        this.x = i2;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getDuration() {
        h(f20915f);
        return this.w;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getHeight() {
        h(f20913d);
        return this.v;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaStoreItemId getId() {
        return this.N;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String getNamespace() {
        String namespace = this.N.getNamespace();
        h.a((Object) namespace, "mId.namespace");
        return namespace;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getOrientation() {
        return this.x;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String getPath() {
        try {
            h(i);
            return this.s;
        } catch (Exception unused) {
            return this.s;
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaItemType getType() {
        return this.M;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getWidth() {
        h(f20913d);
        return this.u;
    }

    public final long l() {
        return this.r;
    }

    public int m() {
        h(f20917h);
        return this.z;
    }

    public int n() {
        h(f20916g);
        return this.y;
    }

    public final com.nexstreaming.kinemaster.mediastore.item.c o() {
        WeakReference<com.nexstreaming.kinemaster.mediastore.item.c> weakReference = this.K;
        com.nexstreaming.kinemaster.mediastore.item.c cVar = null;
        if (weakReference != null) {
            if (weakReference == null) {
                h.a();
                throw null;
            }
            cVar = weakReference.get();
        }
        if (cVar != null) {
            return cVar;
        }
        e eVar = new e(this);
        this.K = new WeakReference<>(eVar);
        return eVar;
    }

    public final void a(a aVar) {
        h.b(aVar, "cb");
        this.F = aVar;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaSupportType g() {
        h(f20912c);
        return this.B;
    }

    public final void a(String str) {
        this.p = str;
        this.o = 0;
    }

    public final void b(String str) {
        this.s = str;
        this.H |= i;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public ResultTask<MediaSupportType> e() {
        ResultTask<MediaSupportType> resultTask = this.J;
        if (resultTask != null) {
            if (resultTask == null) {
                h.a();
                throw null;
            }
            if (resultTask.isRunning()) {
                return this.J;
            }
        }
        InterfaceC0109b interfaceC0109b = this.G;
        if (interfaceC0109b == null) {
            return ResultTask.completedResultTask(g());
        }
        if (interfaceC0109b != null) {
            this.J = interfaceC0109b.a(this);
            return this.J;
        }
        h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public boolean f() {
        h(k);
        return this.A;
    }

    public final void c(int i2) {
        this.w = i2;
        this.H |= f20915f;
    }

    public final void d(int i2) {
        this.I = i2;
        this.H |= j;
    }

    public final void a(long j2) {
        this.q = new Date(j2);
        this.r = j2;
    }

    public final void b(long j2) {
        this.H |= f20914e;
        this.t = j2;
    }

    public final void c(boolean z) {
        this.C = z;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public long a() {
        h(f20914e);
        return this.t;
    }

    public final synchronized Bundle b(Class<?> cls) {
        Bundle bundle;
        h.b(cls, "providerClass");
        String name = cls.getName();
        if (this.E == null) {
            this.E = new HashMap();
        }
        bundle = new Bundle();
        Map<String, Bundle> map = this.E;
        if (map == null) {
            h.a();
            throw null;
        }
        h.a((Object) name, "className");
        map.put(name, bundle);
        return bundle;
    }

    public final void a(int i2, int i3) {
        this.H |= f20913d;
        this.u = i2;
        this.v = i3;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public synchronized Bundle a(Class<?> cls) {
        Bundle bundle;
        h.b(cls, "providerClass");
        String name = cls.getName();
        if (this.E == null) {
            this.E = new HashMap();
        }
        Map<String, Bundle> map = this.E;
        if (map == null) {
            h.a();
            throw null;
        }
        bundle = map.get(name);
        if (bundle == null) {
            bundle = new Bundle();
            Map<String, Bundle> map2 = this.E;
            if (map2 == null) {
                h.a();
                throw null;
            }
            h.a((Object) name, "className");
            map2.put(name, bundle);
        }
        return bundle;
    }

    public final void b(boolean z) {
        this.A = z;
        this.H |= k;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int b() {
        h(j);
        return this.I;
    }

    public final void a(MediaSupportType mediaSupportType) {
        h.b(mediaSupportType, "supportType");
        this.B = mediaSupportType;
        this.H |= f20912c;
    }

    public final void a(boolean z) {
        this.D = z;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public boolean h() {
        if (!this.C && getPath() != null) {
            String path = getPath();
            if (path != null) {
                if (!new File(path).exists()) {
                    this.C = true;
                }
            } else {
                h.a();
                throw null;
            }
        }
        return this.C;
    }
}
