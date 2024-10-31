package com.nextreaming.nexvideoeditor;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class NexThemeView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    private static String f4804a = "VideoEditor_ThemeView";
    private NexEditor b;
    private float c;
    private RenderType d;
    private boolean e;
    private Queue<Object> f;
    private Handler g;
    private boolean h;
    private int i;
    private int j;
    private a k;
    private SurfaceTexture l;
    private Surface m;
    private List<Runnable> n;

    /* loaded from: classes.dex */
    private enum RenderType {
        None,
        Native,
        Clear
    }

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    private void a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != this.l) {
            this.l = surfaceTexture;
            if (this.l != null) {
                this.m = new Surface(this.l);
            } else {
                this.m = null;
            }
        }
    }

    private String a() {
        return "[0x" + Integer.toHexString(System.identityHashCode(this)) + " " + getWidth() + "x" + getHeight() + "] ";
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture);
        Log.d(f4804a, "onSurfaceTextureAvailable " + a() + (this.b == null ? "(editor is null)" : "(editor is SET)"));
        if (this.b != null) {
            this.b.a(this.m);
            this.b.o();
            Iterator<Runnable> it = this.n.iterator();
            while (it.hasNext()) {
                post(it.next());
            }
            this.n.clear();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture);
        Log.d(f4804a, "onSurfaceTextureSizeChanged " + a() + (this.b == null ? "(editor is null)" : "(editor is SET)"));
        if (this.b != null) {
            this.b.a(this.m);
            this.b.o();
        }
    }

    public void a(Runnable runnable) {
        this.n.add(runnable);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.d(f4804a, "onSurfaceTextureDestroyed " + a() + (this.b == null ? "(editor is null)" : "(editor is SET)"));
        if (this.b != null) {
            this.b.a((Surface) null);
        }
        this.m = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setBlackOut(boolean z) {
        this.h = z;
    }

    public NexThemeView(Context context) {
        super(context);
        this.b = null;
        this.c = 1.7777778f;
        this.d = RenderType.None;
        this.e = false;
        this.f = new LinkedList();
        this.g = new Handler();
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.n = new ArrayList();
        a(false, 0, 1);
    }

    public NexThemeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = 1.7777778f;
        this.d = RenderType.None;
        this.e = false;
        this.f = new LinkedList();
        this.g = new Handler();
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.n = new ArrayList();
        a(false, 0, 0);
    }

    public NexThemeView(Context context, boolean z, int i, int i2) {
        super(context);
        this.b = null;
        this.c = 1.7777778f;
        this.d = RenderType.None;
        this.e = false;
        this.f = new LinkedList();
        this.g = new Handler();
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.n = new ArrayList();
        a(z, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(NexEditor nexEditor) {
        this.b = nexEditor;
        if (this.b != null && this.m != null) {
            this.b.a(this.m);
        }
    }

    public void setAspectRatio(float f) {
        this.c = f;
    }

    public float getAspectRatio() {
        return this.c;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i) != 1073741824 && this.c > 0.0f) {
            if (size2 * this.c > size) {
                size2 = (int) (size / this.c);
            } else {
                size = (int) (size2 * this.c);
            }
        }
        setMeasuredDimension(size, size2);
    }

    private void a(boolean z, int i, int i2) {
        setSurfaceTextureListener(this);
    }
}
