package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.c.n;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.a.l;
import com.bumptech.glide.load.b.B;
import com.bumptech.glide.load.b.C;
import com.bumptech.glide.load.b.C0706a;
import com.bumptech.glide.load.b.C0708c;
import com.bumptech.glide.load.b.C0710e;
import com.bumptech.glide.load.b.D;
import com.bumptech.glide.load.b.E;
import com.bumptech.glide.load.b.a.a;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.c;
import com.bumptech.glide.load.b.a.d;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.b.g;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.b.z;
import com.bumptech.glide.load.c.a.a;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.bitmap.A;
import com.bumptech.glide.load.resource.bitmap.C0720a;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.load.resource.bitmap.x;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f8408a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f8409b;

    /* renamed from: c, reason: collision with root package name */
    private final s f8410c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f8411d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b.i f8412e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.d.a f8413f;

    /* renamed from: g, reason: collision with root package name */
    private final e f8414g;

    /* renamed from: h, reason: collision with root package name */
    private final Registry f8415h;
    private final com.bumptech.glide.load.engine.a.b i;
    private final n j;
    private final com.bumptech.glide.c.d k;
    private final List<j> l = new ArrayList();
    private MemoryCategory m = MemoryCategory.NORMAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, s sVar, com.bumptech.glide.load.engine.b.i iVar, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar, n nVar, com.bumptech.glide.c.d dVar, int i, com.bumptech.glide.request.f fVar, Map<Class<?>, k<?, ?>> map, List<com.bumptech.glide.request.e<Object>> list, boolean z) {
        this.f8410c = sVar;
        this.f8411d = eVar;
        this.i = bVar;
        this.f8412e = iVar;
        this.j = nVar;
        this.k = dVar;
        this.f8413f = new com.bumptech.glide.load.engine.d.a(iVar, eVar, (DecodeFormat) fVar.i().a(m.f9028a));
        Resources resources = context.getResources();
        this.f8415h = new Registry();
        this.f8415h.a((ImageHeaderParser) new com.bumptech.glide.load.resource.bitmap.k());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f8415h.a((ImageHeaderParser) new q());
        }
        List<ImageHeaderParser> a2 = this.f8415h.a();
        m mVar = new m(a2, resources.getDisplayMetrics(), eVar, bVar);
        com.bumptech.glide.load.c.d.a aVar = new com.bumptech.glide.load.c.d.a(context, a2, eVar, bVar);
        com.bumptech.glide.load.h<ParcelFileDescriptor, Bitmap> b2 = A.b(eVar);
        com.bumptech.glide.load.resource.bitmap.g gVar = new com.bumptech.glide.load.resource.bitmap.g(mVar);
        v vVar = new v(mVar, bVar);
        com.bumptech.glide.load.c.b.d dVar2 = new com.bumptech.glide.load.c.b.d(context);
        z.c cVar = new z.c(resources);
        z.d dVar3 = new z.d(resources);
        z.b bVar2 = new z.b(resources);
        z.a aVar2 = new z.a(resources);
        com.bumptech.glide.load.resource.bitmap.c cVar2 = new com.bumptech.glide.load.resource.bitmap.c(bVar);
        com.bumptech.glide.load.c.e.a aVar3 = new com.bumptech.glide.load.c.e.a();
        com.bumptech.glide.load.c.e.d dVar4 = new com.bumptech.glide.load.c.e.d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry = this.f8415h;
        registry.a(ByteBuffer.class, new C0710e());
        registry.a(InputStream.class, new com.bumptech.glide.load.b.A(bVar));
        registry.a("Bitmap", ByteBuffer.class, Bitmap.class, gVar);
        registry.a("Bitmap", InputStream.class, Bitmap.class, vVar);
        registry.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b2);
        registry.a("Bitmap", AssetFileDescriptor.class, Bitmap.class, A.a(eVar));
        registry.a(Bitmap.class, Bitmap.class, C.a.a());
        registry.a("Bitmap", Bitmap.class, Bitmap.class, new x());
        registry.a(Bitmap.class, (com.bumptech.glide.load.i) cVar2);
        registry.a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C0720a(resources, gVar));
        registry.a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C0720a(resources, vVar));
        registry.a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C0720a(resources, b2));
        registry.a(BitmapDrawable.class, (com.bumptech.glide.load.i) new com.bumptech.glide.load.resource.bitmap.b(eVar, cVar2));
        registry.a("Gif", InputStream.class, com.bumptech.glide.load.c.d.c.class, new com.bumptech.glide.load.c.d.j(a2, aVar, bVar));
        registry.a("Gif", ByteBuffer.class, com.bumptech.glide.load.c.d.c.class, aVar);
        registry.a(com.bumptech.glide.load.c.d.c.class, (com.bumptech.glide.load.i) new com.bumptech.glide.load.c.d.d());
        registry.a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, C.a.a());
        registry.a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.load.c.d.h(eVar));
        registry.a(Uri.class, Drawable.class, dVar2);
        registry.a(Uri.class, Bitmap.class, new u(dVar2, eVar));
        registry.a((e.a<?>) new a.C0053a());
        registry.a(File.class, ByteBuffer.class, new f.b());
        registry.a(File.class, InputStream.class, new i.e());
        registry.a(File.class, File.class, new com.bumptech.glide.load.c.c.a());
        registry.a(File.class, ParcelFileDescriptor.class, new i.b());
        registry.a(File.class, File.class, C.a.a());
        registry.a((e.a<?>) new l.a(bVar));
        registry.a(Integer.TYPE, InputStream.class, cVar);
        registry.a(Integer.TYPE, ParcelFileDescriptor.class, bVar2);
        registry.a(Integer.class, InputStream.class, cVar);
        registry.a(Integer.class, ParcelFileDescriptor.class, bVar2);
        registry.a(Integer.class, Uri.class, dVar3);
        registry.a(Integer.TYPE, AssetFileDescriptor.class, aVar2);
        registry.a(Integer.class, AssetFileDescriptor.class, aVar2);
        registry.a(Integer.TYPE, Uri.class, dVar3);
        registry.a(String.class, InputStream.class, new g.c());
        registry.a(Uri.class, InputStream.class, new g.c());
        registry.a(String.class, InputStream.class, new B.c());
        registry.a(String.class, ParcelFileDescriptor.class, new B.b());
        registry.a(String.class, AssetFileDescriptor.class, new B.a());
        registry.a(Uri.class, InputStream.class, new b.a());
        registry.a(Uri.class, InputStream.class, new C0706a.c(context.getAssets()));
        registry.a(Uri.class, ParcelFileDescriptor.class, new C0706a.b(context.getAssets()));
        registry.a(Uri.class, InputStream.class, new c.a(context));
        registry.a(Uri.class, InputStream.class, new d.a(context));
        registry.a(Uri.class, InputStream.class, new D.d(contentResolver));
        registry.a(Uri.class, ParcelFileDescriptor.class, new D.b(contentResolver));
        registry.a(Uri.class, AssetFileDescriptor.class, new D.a(contentResolver));
        registry.a(Uri.class, InputStream.class, new E.a());
        registry.a(URL.class, InputStream.class, new e.a());
        registry.a(Uri.class, File.class, new q.a(context));
        registry.a(com.bumptech.glide.load.b.l.class, InputStream.class, new a.C0050a());
        registry.a(byte[].class, ByteBuffer.class, new C0708c.a());
        registry.a(byte[].class, InputStream.class, new C0708c.d());
        registry.a(Uri.class, Uri.class, C.a.a());
        registry.a(Drawable.class, Drawable.class, C.a.a());
        registry.a(Drawable.class, Drawable.class, new com.bumptech.glide.load.c.b.e());
        registry.a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.c.e.b(resources));
        registry.a(Bitmap.class, byte[].class, aVar3);
        registry.a(Drawable.class, byte[].class, new com.bumptech.glide.load.c.e.c(eVar, aVar3, dVar4));
        registry.a(com.bumptech.glide.load.c.d.c.class, byte[].class, dVar4);
        this.f8414g = new e(context, bVar, this.f8415h, new com.bumptech.glide.request.a.f(), fVar, map, list, sVar, z, i);
    }

    public static c a(Context context) {
        if (f8408a == null) {
            synchronized (c.class) {
                if (f8408a == null) {
                    c(context);
                }
            }
        }
        return f8408a;
    }

    private static void c(Context context) {
        if (!f8409b) {
            f8409b = true;
            e(context);
            f8409b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    private static void e(Context context) {
        a(context, new d());
    }

    private static a i() {
        try {
            return (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e2) {
            a(e2);
            throw null;
        } catch (InstantiationException e3) {
            a(e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            a(e4);
            throw null;
        } catch (InvocationTargetException e5) {
            a(e5);
            throw null;
        }
    }

    public com.bumptech.glide.load.engine.a.b b() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.c.d d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e f() {
        return this.f8414g;
    }

    public Registry g() {
        return this.f8415h;
    }

    public n h() {
        return this.j;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        a();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }

    public static j b(Context context) {
        return d(context).a(context);
    }

    private static n d(Context context) {
        com.bumptech.glide.g.l.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h();
    }

    public Context e() {
        return this.f8414g.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        synchronized (this.l) {
            if (this.l.contains(jVar)) {
                this.l.remove(jVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public com.bumptech.glide.load.engine.a.e c() {
        return this.f8411d;
    }

    private static void a(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        a i = i();
        List<com.bumptech.glide.d.c> emptyList = Collections.emptyList();
        if (i == null || i.a()) {
            emptyList = new com.bumptech.glide.d.e(applicationContext).a();
        }
        if (i != null && !i.b().isEmpty()) {
            Set<Class<?>> b2 = i.b();
            Iterator<com.bumptech.glide.d.c> it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.d.c next = it.next();
                if (b2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.d.c> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.a(i != null ? i.c() : null);
        Iterator<com.bumptech.glide.d.c> it3 = emptyList.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, dVar);
        }
        if (i != null) {
            i.a(applicationContext, dVar);
        }
        c a2 = dVar.a(applicationContext);
        Iterator<com.bumptech.glide.d.c> it4 = emptyList.iterator();
        while (it4.hasNext()) {
            it4.next().a(applicationContext, a2, a2.f8415h);
        }
        if (i != null) {
            i.a(applicationContext, a2, a2.f8415h);
        }
        applicationContext.registerComponentCallbacks(a2);
        f8408a = a2;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void a() {
        com.bumptech.glide.g.n.a();
        this.f8412e.a();
        this.f8411d.a();
        this.i.a();
    }

    public void a(int i) {
        com.bumptech.glide.g.n.a();
        this.f8412e.a(i);
        this.f8411d.a(i);
        this.i.a(i);
    }

    public static j a(FragmentActivity fragmentActivity) {
        return d(fragmentActivity).a(fragmentActivity);
    }

    public static j a(Fragment fragment) {
        return d(fragment.getActivity()).a(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.bumptech.glide.request.a.i<?> iVar) {
        synchronized (this.l) {
            Iterator<j> it = this.l.iterator();
            while (it.hasNext()) {
                if (it.next().b(iVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        synchronized (this.l) {
            if (!this.l.contains(jVar)) {
                this.l.add(jVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
