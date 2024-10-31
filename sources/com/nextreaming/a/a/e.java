package com.nextreaming.a.a;

import android.R;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.nextreaming.a.a.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: ImageWorker.java */
/* loaded from: classes.dex */
public abstract class e {
    protected com.nextreaming.a.a.c d;
    protected c.a e;
    protected Resources h;
    private static final ThreadFactory m = new com.nextreaming.a.a.f();
    public static final Executor i = Executors.newSingleThreadExecutor();
    public static final Executor j = Executors.newFixedThreadPool(2, m);
    public static final Executor k = Executors.newFixedThreadPool(1, m);
    protected boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4456a = false;
    protected boolean g = false;
    private final Object b = new Object();
    private final ReadWriteLock c = new ReentrantReadWriteLock();
    private final Hashtable<Integer, Bitmap> l = new Hashtable<>(2);
    private List<WeakReference<h>> n = new ArrayList();

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean a();
    }

    /* compiled from: ImageWorker.java */
    /* renamed from: com.nextreaming.a.a.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082e {
        void a(Bitmap bitmap);
    }

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public interface g {
    }

    protected abstract Bitmap a(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context) {
        this.h = context.getResources();
    }

    public void a(Object obj, ImageView imageView, int i2) {
        if (i2 != 0 && !this.l.containsKey(Integer.valueOf(i2))) {
            this.l.put(Integer.valueOf(i2), BitmapFactory.decodeResource(this.h, i2));
        }
        a(obj, imageView, this.l.get(Integer.valueOf(i2)));
    }

    public void a(Object obj, InterfaceC0082e interfaceC0082e) {
        new f(interfaceC0082e).execute(obj);
    }

    public void a(Object obj, ImageView imageView, Bitmap bitmap) {
        if (obj != null) {
            Bitmap bitmap2 = null;
            this.c.readLock().lock();
            try {
                if (this.d != null) {
                    bitmap2 = this.d.a(String.valueOf(obj));
                }
                if (bitmap2 != null) {
                    imageView.setImageBitmap(bitmap2);
                } else if (a(obj, imageView)) {
                    b bVar = new b(imageView, obj);
                    imageView.setImageDrawable(new a(this.h, bitmap, bVar));
                    bVar.executeOnExecutor(j, new Object[0]);
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void a() {
        Iterator<WeakReference<h>> it = this.n.iterator();
        while (it.hasNext()) {
            h hVar = it.next().get();
            if (hVar != null) {
                hVar.cancel(true);
            }
        }
        this.n = new ArrayList();
    }

    public void b(Object obj) {
        if (obj != null) {
            this.c.readLock().lock();
            try {
                if (this.d != null) {
                    if (this.d.a(String.valueOf(obj)) == null) {
                        this.c.readLock().unlock();
                        h hVar = new h();
                        if (this.n.size() > 64) {
                            ArrayList arrayList = new ArrayList();
                            for (WeakReference<h> weakReference : this.n) {
                                if (weakReference.get() != null) {
                                    arrayList.add(weakReference);
                                }
                            }
                            this.n = arrayList;
                        }
                        this.n.add(new WeakReference<>(hVar));
                        hVar.executeOnExecutor(k, obj);
                    }
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void a(FragmentManager fragmentManager, c.a aVar) {
        this.e = aVar;
        a(com.nextreaming.a.a.c.a(fragmentManager, this.e));
        new c().executeOnExecutor(i, 1);
    }

    public void a(com.nextreaming.a.a.c cVar) {
        this.c.writeLock().lock();
        try {
            this.d = cVar;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    public static boolean a(Object obj, ImageView imageView) {
        b b2 = b(imageView);
        if (b2 == null) {
            return true;
        }
        Object obj2 = b2.b;
        if (obj2 == null || !obj2.equals(obj)) {
            b2.cancel(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b b(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof a) {
                return ((a) drawable).a();
            }
        }
        return null;
    }

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    private class f extends AsyncTask<Object, Void, Bitmap> {
        private InterfaceC0082e b;

        public f(InterfaceC0082e interfaceC0082e) {
            this.b = null;
            this.b = interfaceC0082e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Object... objArr) {
            boolean z;
            Bitmap bitmap;
            e.b("ImageWorker", "doInBackground - starting work");
            Bitmap bitmap2 = null;
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                String valueOf = String.valueOf(obj);
                synchronized (e.this.b) {
                    while (e.this.g && !isCancelled()) {
                        try {
                            e.this.b.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
                if (obj instanceof g) {
                    z = false;
                } else if (!(obj instanceof d)) {
                    z = true;
                } else {
                    z = ((d) obj).a();
                }
                if (z) {
                    e.this.c.readLock().lock();
                    try {
                        if (e.this.d == null || isCancelled() || e.this.f4456a) {
                            bitmap = null;
                        } else {
                            bitmap = e.this.d.b(valueOf);
                        }
                    } finally {
                    }
                } else {
                    bitmap = null;
                }
                if (bitmap == null && !isCancelled() && !e.this.f4456a) {
                    bitmap = e.this.a(objArr[0]);
                }
                e.this.c.readLock().lock();
                if (bitmap != null) {
                    try {
                        if (e.this.d != null) {
                            e.this.d.a(valueOf, bitmap);
                        }
                    } finally {
                    }
                }
                e.this.c.readLock().unlock();
                bitmap2 = bitmap;
            }
            e.b("ImageWorker", "doInBackground - finished work");
            return bitmap2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            if (isCancelled() || e.this.f4456a) {
                bitmap = null;
            }
            if (this.b != null) {
                this.b.a(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
            synchronized (e.this.b) {
                e.this.b.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public class b extends AsyncTask<Object, Void, Bitmap> {
        private Object b;
        private final WeakReference<ImageView> c;

        public b(ImageView imageView, Object obj) {
            this.c = new WeakReference<>(imageView);
            this.b = obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap;
            e.b("ImageWorker", "doInBackground - starting work " + this.b);
            if (isCancelled()) {
                return null;
            }
            String valueOf = String.valueOf(this.b);
            synchronized (e.this.b) {
                while (e.this.g && !isCancelled()) {
                    try {
                        e.this.b.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            boolean z = true;
            if (this.b instanceof g) {
                z = false;
            } else if (this.b instanceof d) {
                z = ((d) this.b).a();
            }
            if (z) {
                e.this.c.readLock().lock();
                try {
                    bitmap = (e.this.d == null || isCancelled() || a() == null || e.this.f4456a) ? null : e.this.d.b(valueOf);
                } finally {
                }
            } else {
                bitmap = null;
            }
            if (bitmap == null && !isCancelled() && a() != null && !e.this.f4456a) {
                bitmap = e.this.a(this.b);
            }
            e.this.c.readLock().lock();
            if (bitmap != null) {
                try {
                    if (e.this.d != null) {
                        e.this.d.a(valueOf, bitmap);
                    }
                } finally {
                }
            }
            e.this.c.readLock().unlock();
            e.b("ImageWorker", "doInBackground - finished work " + this.b);
            return bitmap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            if (isCancelled() || e.this.f4456a) {
                bitmap = null;
            }
            ImageView a2 = a();
            if (bitmap != null && a2 != null) {
                e.b("ImageWorker", "onPostExecute - setting bitmap");
                e.this.a(a2, bitmap);
                e.b("ImageWorker", "onPostExecute - done setting bitmap");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
            synchronized (e.this.b) {
                e.this.b.notifyAll();
            }
        }

        private ImageView a() {
            ImageView imageView = this.c.get();
            if (this != e.b(imageView)) {
                e.b("ImageWorker", "getAttachedImageView() - imageView null");
                return null;
            }
            return imageView;
        }
    }

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    private class h extends AsyncTask<Object, Void, Bitmap> {
        private Object b;

        public h() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap;
            e.b("ImageWorker", "PrecacheWorkerTask doInBackground - starting work");
            this.b = objArr[0];
            String valueOf = String.valueOf(this.b);
            synchronized (e.this.b) {
                while (e.this.g && !isCancelled()) {
                    try {
                        e.this.b.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            boolean z = true;
            if (this.b instanceof g) {
                z = false;
            } else if (this.b instanceof d) {
                z = ((d) this.b).a();
            }
            if (z) {
                e.this.c.readLock().lock();
                try {
                    if (e.this.d == null || isCancelled() || e.this.f4456a) {
                        bitmap = null;
                    } else {
                        bitmap = e.this.d.b(valueOf);
                    }
                } finally {
                }
            } else {
                bitmap = null;
            }
            if (bitmap == null && !isCancelled() && !e.this.f4456a) {
                bitmap = e.this.a(objArr[0]);
            }
            e.this.c.readLock().lock();
            if (bitmap != null) {
                try {
                    if (e.this.d != null) {
                        e.this.d.a(valueOf, bitmap);
                    }
                } finally {
                }
            }
            e.this.c.readLock().unlock();
            e.b("ImageWorker", "doInBackground - finished work");
            return bitmap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
            synchronized (e.this.b) {
                e.this.b.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public static class a extends BitmapDrawable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f4457a;

        public a(Resources resources, Bitmap bitmap, b bVar) {
            super(resources, bitmap);
            this.f4457a = new WeakReference<>(bVar);
        }

        public b a() {
            return this.f4457a.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, Bitmap bitmap) {
        if (this.f) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(R.color.transparent), new BitmapDrawable(this.h, bitmap)});
            imageView.setBackground(imageView.getDrawable());
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    protected class c extends AsyncTask<Object, Void, Void> {
        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) {
            switch (((Integer) objArr[0]).intValue()) {
                case 0:
                    e.this.c();
                    return null;
                case 1:
                    e.this.b();
                    return null;
                case 2:
                    e.this.d();
                    return null;
                case 3:
                    e.this.e();
                    return null;
                default:
                    return null;
            }
        }
    }

    protected void b() {
        this.c.readLock().lock();
        try {
            if (this.d != null) {
                this.d.a();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    protected void c() {
        this.c.readLock().lock();
        try {
            if (this.d != null) {
                this.d.b();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    protected void d() {
        this.c.readLock().lock();
        try {
            if (this.d != null) {
                this.d.c();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    protected void e() {
        this.c.writeLock().lock();
        try {
            if (this.d != null) {
                this.d.d();
                this.d = null;
            }
        } finally {
            this.c.writeLock().unlock();
        }
    }

    public void f() {
        new c().executeOnExecutor(i, 0);
    }

    public void g() {
        new c().executeOnExecutor(i, 3);
    }
}
