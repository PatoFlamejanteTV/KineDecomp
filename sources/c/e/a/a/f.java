package c.e.a.a;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
import c.e.a.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: ImageWorker.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a */
    private static final ThreadFactory f3901a = new c.e.a.a.e();

    /* renamed from: b */
    public static final Executor f3902b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    public static final Executor f3903c = Executors.newFixedThreadPool(2, f3901a);

    /* renamed from: d */
    public static final Executor f3904d = Executors.newFixedThreadPool(1, f3901a);

    /* renamed from: e */
    protected c.e.a.a.d f3905e;

    /* renamed from: f */
    protected d.a f3906f;
    protected Resources m;

    /* renamed from: g */
    protected boolean f3907g = false;

    /* renamed from: h */
    private boolean f3908h = false;
    protected boolean i = false;
    private final Object j = new Object();
    private final ReadWriteLock k = new ReentrantReadWriteLock();
    private final Hashtable<Integer, Bitmap> l = new Hashtable<>(2);
    private List<WeakReference<Object>> n = new ArrayList();

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public static class a extends BitmapDrawable {

        /* renamed from: a */
        private final WeakReference<b> f3909a;

        public a(Resources resources, Bitmap bitmap, b bVar) {
            super(resources, bitmap);
            this.f3909a = new WeakReference<>(bVar);
        }

        public b a() {
            return this.f3909a.get();
        }
    }

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public class b extends AsyncTask<Object, Void, Bitmap> {

        /* renamed from: a */
        private Object f3910a;

        /* renamed from: b */
        private final WeakReference<ImageView> f3911b;

        public b(ImageView imageView, Object obj) {
            this.f3911b = new WeakReference<>(imageView);
            this.f3910a = obj;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            if (isCancelled() || f.this.f3908h) {
                bitmap = null;
            }
            ImageView a2 = a();
            if (bitmap == null || a2 == null) {
                return;
            }
            f.this.a(a2, bitmap);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
            synchronized (f.this.j) {
                f.this.j.notifyAll();
            }
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            if (isCancelled()) {
                return null;
            }
            String valueOf = String.valueOf(this.f3910a);
            synchronized (f.this.j) {
                while (f.this.i && !isCancelled()) {
                    try {
                        f.this.j.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            Object obj = this.f3910a;
            if (obj instanceof d ? ((d) obj).a() : true) {
                f.this.k.readLock().lock();
                try {
                    if (f.this.f3905e != null && !isCancelled() && a() != null && !f.this.f3908h) {
                        bitmap = f.this.f3905e.a(valueOf);
                    }
                    f.this.k.readLock().unlock();
                } finally {
                }
            }
            if (bitmap == null && !isCancelled() && a() != null && !f.this.f3908h) {
                bitmap = f.this.a(this.f3910a);
            }
            f.this.k.readLock().lock();
            if (bitmap != null) {
                try {
                    if (f.this.f3905e != null) {
                        f.this.f3905e.a(valueOf, bitmap);
                    }
                } finally {
                }
            }
            return bitmap;
        }

        private ImageView a() {
            ImageView imageView = this.f3911b.get();
            if (this == f.b(imageView)) {
                return imageView;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public class c extends AsyncTask<Object, Void, Void> {
        protected c() {
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            int intValue = ((Integer) objArr[0]).intValue();
            if (intValue == 0) {
                f.this.a();
                return null;
            }
            if (intValue == 1) {
                f.this.d();
                return null;
            }
            if (intValue == 2) {
                f.this.c();
                return null;
            }
            if (intValue != 3) {
                return null;
            }
            f.this.b();
            return null;
        }
    }

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean a();
    }

    /* compiled from: ImageWorker.java */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        void a(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageWorker.java */
    /* renamed from: c.e.a.a.f$f */
    /* loaded from: classes.dex */
    public class AsyncTaskC0021f extends AsyncTask<Object, Void, Bitmap> {

        /* renamed from: a */
        private e f3914a;

        public AsyncTaskC0021f(e eVar) {
            this.f3914a = null;
            this.f3914a = eVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
            synchronized (f.this.j) {
                f.this.j.notifyAll();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            if (isCancelled() || f.this.f3908h) {
                bitmap = null;
                e eVar = this.f3914a;
                if (eVar != null) {
                    eVar.a();
                }
            }
            e eVar2 = this.f3914a;
            if (eVar2 != null) {
                eVar2.a(bitmap);
            }
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                String valueOf = String.valueOf(obj);
                synchronized (f.this.j) {
                    while (f.this.i && !isCancelled()) {
                        try {
                            f.this.j.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                if (obj instanceof d ? ((d) obj).a() : true) {
                    f.this.k.readLock().lock();
                    try {
                        if (f.this.f3905e != null && !isCancelled() && !f.this.f3908h) {
                            bitmap = f.this.f3905e.a(valueOf);
                        }
                        f.this.k.readLock().unlock();
                    } finally {
                    }
                }
                if (bitmap == null && !isCancelled() && !f.this.f3908h) {
                    bitmap = f.this.a(objArr[0]);
                }
                f.this.k.readLock().lock();
                if (bitmap != null) {
                    try {
                        if (f.this.f3905e != null) {
                            f.this.f3905e.a(valueOf, bitmap);
                        }
                    } finally {
                    }
                }
            }
            return bitmap;
        }
    }

    public f(Context context) {
        this.m = context.getResources();
    }

    protected abstract Bitmap a(Object obj);

    protected void d() {
        this.k.readLock().lock();
        try {
            if (this.f3905e != null) {
                this.f3905e.e();
            }
        } finally {
            this.k.readLock().unlock();
        }
    }

    public static b b(ImageView imageView) {
        if (imageView == null) {
            return null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof a) {
            return ((a) drawable).a();
        }
        return null;
    }

    protected void c() {
        this.k.readLock().lock();
        try {
            if (this.f3905e != null) {
                this.f3905e.d();
            }
        } finally {
            this.k.readLock().unlock();
        }
    }

    public void a(Object obj, ImageView imageView, int i) {
        if (i != 0 && !this.l.containsKey(Integer.valueOf(i))) {
            this.l.put(Integer.valueOf(i), BitmapFactory.decodeResource(this.m, i));
        }
        a(obj, imageView, this.l.get(Integer.valueOf(i)));
    }

    protected void b() {
        this.k.writeLock().lock();
        try {
            if (this.f3905e != null) {
                this.f3905e.c();
                this.f3905e = null;
            }
        } finally {
            this.k.writeLock().unlock();
        }
    }

    public void a(Object obj, e eVar) {
        new AsyncTaskC0021f(eVar).execute(obj);
    }

    public void a(Object obj, ImageView imageView, Bitmap bitmap) {
        if (obj == null) {
            return;
        }
        this.k.readLock().lock();
        try {
            Bitmap b2 = this.f3905e != null ? this.f3905e.b(String.valueOf(obj)) : null;
            if (b2 != null) {
                imageView.setImageBitmap(b2);
            } else if (a(obj, imageView)) {
                b bVar = new b(imageView, obj);
                imageView.setImageDrawable(new a(this.m, bitmap, bVar));
                bVar.executeOnExecutor(f3903c, new Object[0]);
            }
        } finally {
            this.k.readLock().unlock();
        }
    }

    public void a(FragmentManager fragmentManager, d.a aVar) {
        this.f3906f = aVar;
        a(c.e.a.a.d.a(fragmentManager, this.f3906f));
        new c().executeOnExecutor(f3902b, 1);
    }

    public void a(c.e.a.a.d dVar) {
        this.k.writeLock().lock();
        try {
            this.f3905e = dVar;
        } finally {
            this.k.writeLock().unlock();
        }
    }

    public static boolean a(Object obj, ImageView imageView) {
        b b2 = b(imageView);
        if (b2 != null) {
            Object obj2 = b2.f3910a;
            if (obj2 != null && obj2.equals(obj)) {
                return false;
            }
            b2.cancel(true);
        }
        return true;
    }

    public void a(ImageView imageView, Bitmap bitmap) {
        if (this.f3907g) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(R.color.transparent), new BitmapDrawable(this.m, bitmap)});
            imageView.setBackground(imageView.getDrawable());
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    protected void a() {
        this.k.readLock().lock();
        try {
            if (this.f3905e != null) {
                this.f3905e.b();
            }
        } finally {
            this.k.readLock().unlock();
        }
    }
}
