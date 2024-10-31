package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.QueryParams;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.F;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
public final class S implements InterfaceC1827e {

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC1828f f21668c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC1825c f21669d;

    /* renamed from: f, reason: collision with root package name */
    private ResultTask<?> f21671f;

    /* renamed from: g, reason: collision with root package name */
    private GoogleSignInClient f21672g;

    /* renamed from: a, reason: collision with root package name */
    private final MediaStore f21666a = KineMasterApplication.f24058f.c().p();

    /* renamed from: b, reason: collision with root package name */
    private final com.nexstreaming.kinemaster.mediastore.e f21667b = KineMasterApplication.f24058f.c().k();

    /* renamed from: e, reason: collision with root package name */
    private final Stack<com.nexstreaming.kinemaster.mediastore.item.c> f21670e = new Stack<>();

    private final com.nexstreaming.kinemaster.mediastore.item.c i(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        InterfaceC1825c interfaceC1825c;
        InterfaceC1825c interfaceC1825c2 = this.f21669d;
        Boolean valueOf = interfaceC1825c2 != null ? Boolean.valueOf(interfaceC1825c2.c(cVar)) : null;
        if (valueOf == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (valueOf.booleanValue()) {
            InterfaceC1825c interfaceC1825c3 = this.f21669d;
            if (interfaceC1825c3 != null) {
                return interfaceC1825c3.a(cVar);
            }
            return null;
        }
        InterfaceC1825c interfaceC1825c4 = this.f21669d;
        Boolean valueOf2 = interfaceC1825c4 != null ? Boolean.valueOf(interfaceC1825c4.d(cVar)) : null;
        if (valueOf2 == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (!valueOf2.booleanValue() || (interfaceC1825c = this.f21669d) == null) {
            return null;
        }
        return interfaceC1825c.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        if (cVar != null) {
            InterfaceC1828f interfaceC1828f = this.f21668c;
            if (interfaceC1828f != null) {
                com.nexstreaming.kinemaster.mediastore.e eVar = this.f21667b;
                Boolean valueOf = eVar != null ? Boolean.valueOf(eVar.c(cVar.getId())) : null;
                if (valueOf == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                boolean booleanValue = valueOf.booleanValue();
                InterfaceC1825c interfaceC1825c = this.f21669d;
                Boolean valueOf2 = interfaceC1825c != null ? Boolean.valueOf(interfaceC1825c.d(cVar)) : null;
                if (valueOf2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                boolean booleanValue2 = valueOf2.booleanValue();
                InterfaceC1825c interfaceC1825c2 = this.f21669d;
                Boolean valueOf3 = interfaceC1825c2 != null ? Boolean.valueOf(interfaceC1825c2.c(cVar)) : null;
                if (valueOf3 != null) {
                    interfaceC1828f.a(cVar, booleanValue, booleanValue2, valueOf3.booleanValue());
                    return;
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            return;
        }
        InterfaceC1828f interfaceC1828f2 = this.f21668c;
        if (interfaceC1828f2 != null) {
            interfaceC1828f2.n();
        }
    }

    private final boolean k(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        return kotlin.jvm.internal.h.a(cVar.getId(), MediaStore.f20847a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        if (cVar.g().needsTranscode()) {
            InterfaceC1828f interfaceC1828f = this.f21668c;
            if (interfaceC1828f != null) {
                interfaceC1828f.d(cVar);
                return;
            }
            return;
        }
        if (cVar.g().isNotSupported()) {
            InterfaceC1828f interfaceC1828f2 = this.f21668c;
            if (interfaceC1828f2 != null) {
                interfaceC1828f2.a(cVar.g().getNotSupportedReason(KineMasterApplication.f24058f.c()));
                return;
            }
            return;
        }
        if (MediaInfo.b(cVar.getPath())) {
            InterfaceC1828f interfaceC1828f3 = this.f21668c;
            if (interfaceC1828f3 != null) {
                interfaceC1828f3.c(cVar);
                return;
            }
            return;
        }
        InterfaceC1828f interfaceC1828f4 = this.f21668c;
        if (interfaceC1828f4 != null) {
            interfaceC1828f4.b(cVar);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void c() {
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.n();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public boolean d() {
        ResultTask<?> resultTask;
        synchronized (this) {
            if (!this.f21670e.isEmpty()) {
                this.f21670e.pop();
            }
            kotlin.k kVar = kotlin.k.f28545a;
        }
        if (this.f21670e.isEmpty()) {
            return false;
        }
        if (this.f21670e.size() == 1) {
            InterfaceC1828f interfaceC1828f = this.f21668c;
            if (interfaceC1828f != null) {
                interfaceC1828f.t();
            }
        } else {
            InterfaceC1828f interfaceC1828f2 = this.f21668c;
            if (interfaceC1828f2 != null) {
                interfaceC1828f2.b(this.f21670e.peek().c());
            }
        }
        ResultTask<?> resultTask2 = this.f21671f;
        if (resultTask2 != null) {
            resultTask2.setCancellable(true);
        }
        ResultTask<?> resultTask3 = this.f21671f;
        if (resultTask3 != null) {
            Boolean valueOf = resultTask3 != null ? Boolean.valueOf(resultTask3.isRunning()) : null;
            if (valueOf == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (valueOf.booleanValue() && (resultTask = this.f21671f) != null) {
                resultTask.cancel();
            }
        }
        a(MediaViewerMode.ALL, this.f21670e.peek().getId());
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void e(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        MediaStore mediaStore = this.f21666a;
        Boolean valueOf = mediaStore != null ? Boolean.valueOf(mediaStore.e(cVar)) : null;
        if (valueOf == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (valueOf.booleanValue()) {
            this.f21666a.a(cVar);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void f(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.b(cVar);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void g(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        Task b2;
        Task onProgress;
        Task onComplete;
        kotlin.jvm.internal.h.b(cVar, "item");
        MediaStore mediaStore = this.f21666a;
        if (mediaStore == null || (b2 = mediaStore.b(cVar)) == null || (onProgress = b2.onProgress(new K(this))) == null || (onComplete = onProgress.onComplete(new L(this, cVar))) == null) {
            return;
        }
        onComplete.onFailure(new M(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.h();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void b(MediaViewerMode mediaViewerMode) {
        kotlin.jvm.internal.h.b(mediaViewerMode, "mode");
        a(mediaViewerMode, this.f21670e.peek().getId());
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void c(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        com.nexstreaming.kinemaster.mediastore.item.c i = i(cVar);
        MediaStoreItemId id = cVar.getId();
        com.nexstreaming.kinemaster.mediastore.e eVar = this.f21667b;
        Boolean valueOf = eVar != null ? Boolean.valueOf(eVar.c(id)) : null;
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.f21667b.b(id);
                InterfaceC1828f interfaceC1828f = this.f21668c;
                if (interfaceC1828f != null) {
                    interfaceC1828f.e();
                }
                MediaStore mediaStore = this.f21666a;
                if ((mediaStore != null ? mediaStore.c(this.f21670e.peek()) : null) instanceof com.nexstreaming.kinemaster.mediastore.provider.t) {
                    a(MediaViewerMode.ALL, this.f21670e.peek().getId()).onComplete((Task.OnTaskEventListener) new N(this, i));
                    return;
                }
            } else {
                this.f21667b.a(id);
                InterfaceC1828f interfaceC1828f2 = this.f21668c;
                if (interfaceC1828f2 != null) {
                    interfaceC1828f2.j();
                }
            }
            a(MediaViewerMode.ALL, this.f21670e.peek().getId());
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public boolean b() {
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f == null) {
            return true;
        }
        interfaceC1828f.n();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.h();
        }
        g();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a(InterfaceC1828f interfaceC1828f) {
        kotlin.jvm.internal.h.b(interfaceC1828f, "view");
        this.f21668c = interfaceC1828f;
        InterfaceC1828f interfaceC1828f2 = this.f21668c;
        if (interfaceC1828f2 != null) {
            interfaceC1828f2.l();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        InterfaceC1828f interfaceC1828f;
        kotlin.jvm.internal.h.b(cVar, "item");
        InterfaceC1825c interfaceC1825c = this.f21669d;
        com.nexstreaming.kinemaster.mediastore.item.c a2 = interfaceC1825c != null ? interfaceC1825c.a(cVar) : null;
        if (a2 == null || (interfaceC1828f = this.f21668c) == null) {
            return;
        }
        com.nexstreaming.kinemaster.mediastore.e eVar = this.f21667b;
        Boolean valueOf = eVar != null ? Boolean.valueOf(eVar.c(a2.getId())) : null;
        if (valueOf == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        boolean booleanValue = valueOf.booleanValue();
        InterfaceC1825c interfaceC1825c2 = this.f21669d;
        Boolean valueOf2 = interfaceC1825c2 != null ? Boolean.valueOf(interfaceC1825c2.d(a2)) : null;
        if (valueOf2 == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        boolean booleanValue2 = valueOf2.booleanValue();
        InterfaceC1825c interfaceC1825c3 = this.f21669d;
        Boolean valueOf3 = interfaceC1825c3 != null ? Boolean.valueOf(interfaceC1825c3.c(a2)) : null;
        if (valueOf3 != null) {
            interfaceC1828f.a(a2, booleanValue, booleanValue2, valueOf3.booleanValue());
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    private final void g() {
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.l(R.string.cloud_connect_fail);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a(InterfaceC1825c interfaceC1825c) {
        kotlin.jvm.internal.h.b(interfaceC1825c, "adapterModel");
        this.f21669d = interfaceC1825c;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void b(int i) {
        boolean a2;
        InterfaceC1828f interfaceC1828f;
        InterfaceC1825c interfaceC1825c = this.f21669d;
        com.nexstreaming.kinemaster.mediastore.item.c item = interfaceC1825c != null ? interfaceC1825c.getItem(i) : null;
        if (item != null) {
            if (item.getType() != MediaItemType.FOLDER && item.getType() != MediaItemType.SPECIAL) {
                InterfaceC1828f interfaceC1828f2 = this.f21668c;
                if (interfaceC1828f2 != null) {
                    com.nexstreaming.kinemaster.mediastore.e eVar = this.f21667b;
                    Boolean valueOf = eVar != null ? Boolean.valueOf(eVar.c(item.getId())) : null;
                    if (valueOf == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    boolean booleanValue = valueOf.booleanValue();
                    InterfaceC1825c interfaceC1825c2 = this.f21669d;
                    Boolean valueOf2 = interfaceC1825c2 != null ? Boolean.valueOf(interfaceC1825c2.d(item)) : null;
                    if (valueOf2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    boolean booleanValue2 = valueOf2.booleanValue();
                    InterfaceC1825c interfaceC1825c3 = this.f21669d;
                    Boolean valueOf3 = interfaceC1825c3 != null ? Boolean.valueOf(interfaceC1825c3.c(item)) : null;
                    if (valueOf3 != null) {
                        interfaceC1828f2.a(item, booleanValue, booleanValue2, valueOf3.booleanValue());
                        return;
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                return;
            }
            MediaStore mediaStore = this.f21666a;
            com.nexstreaming.kinemaster.mediastore.provider.F c2 = mediaStore != null ? mediaStore.c(item) : null;
            if (c2 instanceof F.b) {
                String mediaStoreItemId = item.getId().toString();
                kotlin.jvm.internal.h.a((Object) mediaStoreItemId, "item.getId().toString()");
                a2 = kotlin.text.v.a(mediaStoreItemId, "root", false, 2, null);
                if (!a2 || (interfaceC1828f = this.f21668c) == null) {
                    return;
                }
                interfaceC1828f.a((F.b) c2);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a(MediaViewerMode mediaViewerMode) {
        kotlin.jvm.internal.h.b(mediaViewerMode, "mode");
        MediaStore mediaStore = this.f21666a;
        if (mediaStore != null) {
            com.nexstreaming.kinemaster.mediastore.item.c a2 = mediaStore.a();
            synchronized (this) {
                this.f21670e.push(a2);
            }
            a(mediaViewerMode, a2.getId());
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a() {
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(MediaViewerMode mediaViewerMode) {
        int i = G.f21650a[mediaViewerMode.ordinal()];
        if (i == 1) {
            InterfaceC1828f interfaceC1828f = this.f21668c;
            if (interfaceC1828f != null) {
                interfaceC1828f.l(R.string.empty_image_folder);
                return;
            }
            return;
        }
        if (i != 2) {
            InterfaceC1828f interfaceC1828f2 = this.f21668c;
            if (interfaceC1828f2 != null) {
                interfaceC1828f2.l(R.string.empty_folder);
                return;
            }
            return;
        }
        InterfaceC1828f interfaceC1828f3 = this.f21668c;
        if (interfaceC1828f3 != null) {
            interfaceC1828f3.l(R.string.empty_video_folder);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a(Activity activity, Intent intent) {
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.g();
        }
        GoogleSignIn.a(intent).a(new O(this, activity)).a(new P(this)).a(new Q(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void d(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        if (cVar.h()) {
            InterfaceC1828f interfaceC1828f = this.f21668c;
            if (interfaceC1828f != null) {
                interfaceC1828f.a(cVar);
                return;
            }
            return;
        }
        InterfaceC1828f interfaceC1828f2 = this.f21668c;
        if (interfaceC1828f2 != null) {
            interfaceC1828f2.e(cVar);
        }
        h(cVar);
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a(F.b bVar) {
        kotlin.jvm.internal.h.b(bVar, com.umeng.analytics.pro.b.L);
        MediaStore mediaStore = this.f21666a;
        if (mediaStore != null) {
            mediaStore.a(bVar);
        }
        a(MediaViewerMode.ALL, this.f21670e.peek().getId());
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        InterfaceC1828f interfaceC1828f;
        kotlin.jvm.internal.h.b(cVar, "item");
        InterfaceC1825c interfaceC1825c = this.f21669d;
        com.nexstreaming.kinemaster.mediastore.item.c b2 = interfaceC1825c != null ? interfaceC1825c.b(cVar) : null;
        if (b2 == null || (interfaceC1828f = this.f21668c) == null) {
            return;
        }
        com.nexstreaming.kinemaster.mediastore.e eVar = this.f21667b;
        Boolean valueOf = eVar != null ? Boolean.valueOf(eVar.c(b2.getId())) : null;
        if (valueOf == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        boolean booleanValue = valueOf.booleanValue();
        InterfaceC1825c interfaceC1825c2 = this.f21669d;
        Boolean valueOf2 = interfaceC1825c2 != null ? Boolean.valueOf(interfaceC1825c2.d(b2)) : null;
        if (valueOf2 == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        boolean booleanValue2 = valueOf2.booleanValue();
        InterfaceC1825c interfaceC1825c3 = this.f21669d;
        Boolean valueOf3 = interfaceC1825c3 != null ? Boolean.valueOf(interfaceC1825c3.c(b2)) : null;
        if (valueOf3 != null) {
            interfaceC1828f.a(b2, booleanValue, booleanValue2, valueOf3.booleanValue());
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResultTask<?> a(MediaViewerMode mediaViewerMode, MediaStoreItemId mediaStoreItemId) {
        ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> a2;
        ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> onUpdateOrResultAvailable;
        ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> onFailure;
        InterfaceC1828f interfaceC1828f = this.f21668c;
        if (interfaceC1828f != null) {
            interfaceC1828f.g();
        }
        MediaItemType[] mediaMode = mediaViewerMode.getMediaMode();
        QueryParams queryParams = new QueryParams((MediaItemType[]) Arrays.copyOf(mediaMode, mediaMode.length));
        MediaStore mediaStore = this.f21666a;
        ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> onComplete = (mediaStore == null || (a2 = mediaStore.a(mediaStoreItemId, queryParams)) == null || (onUpdateOrResultAvailable = a2.onUpdateOrResultAvailable(new H(this, mediaViewerMode))) == null || (onFailure = onUpdateOrResultAvailable.onFailure((Task.OnFailListener) new I(this))) == null) ? null : onFailure.onComplete((Task.OnTaskEventListener) new J(this));
        if (onComplete != null) {
            return onComplete;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1827e
    public void a(int i) {
        InterfaceC1825c interfaceC1825c = this.f21669d;
        if (interfaceC1825c == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        com.nexstreaming.kinemaster.mediastore.item.c item = interfaceC1825c.getItem(i);
        if (item != null) {
            int i2 = G.f21651b[item.getType().ordinal()];
            if (i2 == 1) {
                if (this.f21670e.contains(item)) {
                    return;
                }
                synchronized (this) {
                    this.f21670e.push(item);
                }
                InterfaceC1828f interfaceC1828f = this.f21668c;
                if (interfaceC1828f != null) {
                    interfaceC1828f.b(item.c());
                    a(MediaViewerMode.ALL, item.getId());
                    return;
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            if (i2 != 2 && i2 != 3) {
                if (i2 == 4 && k(item)) {
                    InterfaceC1828f interfaceC1828f2 = this.f21668c;
                    if (interfaceC1828f2 != null) {
                        interfaceC1828f2.g();
                        InterfaceC1828f interfaceC1828f3 = this.f21668c;
                        if (interfaceC1828f3 != null) {
                            this.f21672g = interfaceC1828f3.u();
                            return;
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                return;
            }
            if (item.h()) {
                InterfaceC1828f interfaceC1828f4 = this.f21668c;
                if (interfaceC1828f4 != null) {
                    interfaceC1828f4.a(item);
                    return;
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            h(item);
        }
    }
}
