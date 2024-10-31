package com.nextreaming.nexvideoeditor;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class NexThemeView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    private static String f24628a = "VideoEditor_ThemeView";

    /* renamed from: b, reason: collision with root package name */
    private NexEditor f24629b;

    /* renamed from: c, reason: collision with root package name */
    private float f24630c;

    /* renamed from: d, reason: collision with root package name */
    private RenderType f24631d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f24632e;

    /* renamed from: f, reason: collision with root package name */
    private Queue<Object> f24633f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f24634g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f24635h;
    private boolean i;
    private int j;
    private int k;
    private a l;
    private SurfaceTexture m;
    private Surface n;
    private List<Runnable> o;
    private b p;

    /* loaded from: classes3.dex */
    private enum RenderType {
        None,
        Native,
        Clear
    }

    /* loaded from: classes3.dex */
    public static abstract class a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, Object obj, int i2, int i3, int i4);
    }

    public NexThemeView(Context context) {
        super(context);
        this.f24629b = null;
        this.f24630c = EditorGlobal.l();
        this.f24631d = RenderType.None;
        this.f24632e = false;
        this.f24633f = new LinkedList();
        this.f24634g = new Handler();
        this.f24635h = false;
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.o = new ArrayList();
        a(false, 0, 1);
    }

    private void a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != this.m) {
            this.m = surfaceTexture;
            SurfaceTexture surfaceTexture2 = this.m;
            if (surfaceTexture2 != null) {
                this.n = new Surface(surfaceTexture2);
            } else {
                this.n = null;
            }
        }
    }

    public float getAspectRatio() {
        return this.f24630c;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.f24630c = EditorGlobal.l();
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (mode == 1073741824) {
                size2 = (int) Math.min(size2, size / this.f24630c);
                size = (int) (size2 * this.f24630c);
            } else if (mode2 == 1073741824) {
                size = (int) Math.min(size, size2 * this.f24630c);
                size2 = (int) (size / this.f24630c);
            } else {
                float f2 = size;
                float f3 = size2;
                float f4 = this.f24630c;
                if (f2 > f3 * f4) {
                    size = (int) (f3 * f4);
                } else {
                    size2 = (int) (f2 / f4);
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture);
        this.j = i;
        this.k = i2;
        String str = f24628a;
        StringBuilder sb = new StringBuilder();
        sb.append("onSurfaceTextureAvailable ");
        sb.append(a());
        sb.append(this.f24629b == null ? "(editor is null)" : "(editor is SET)");
        Log.d(str, sb.toString());
        NexEditor nexEditor = this.f24629b;
        if (nexEditor != null) {
            nexEditor.a(this.n);
            this.f24629b.m();
            Iterator<Runnable> it = this.o.iterator();
            while (it.hasNext()) {
                post(it.next());
            }
            this.o.clear();
        }
        b bVar = this.p;
        if (bVar != null) {
            bVar.a(1, null, i, i2, 0);
        }
        this.i = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        String str = f24628a;
        StringBuilder sb = new StringBuilder();
        sb.append("onSurfaceTextureDestroyed ");
        sb.append(a());
        sb.append(this.f24629b == null ? "(editor is null)" : "(editor is SET)");
        Log.d(str, sb.toString());
        NexEditor nexEditor = this.f24629b;
        if (nexEditor != null) {
            nexEditor.a((Surface) null);
        }
        this.m = null;
        this.n.release();
        this.n = null;
        b bVar = this.p;
        if (bVar != null) {
            bVar.a(3, null, 0, 0, 0);
        }
        this.i = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture);
        this.j = i;
        this.k = i2;
        String str = f24628a;
        StringBuilder sb = new StringBuilder();
        sb.append("onSurfaceTextureSizeChanged ");
        sb.append(a());
        sb.append(this.f24629b == null ? "(editor is null)" : "(editor is SET)");
        Log.d(str, sb.toString());
        NexEditor nexEditor = this.f24629b;
        if (nexEditor != null) {
            nexEditor.a(this.n);
            this.f24629b.m();
        }
        b bVar = this.p;
        if (bVar != null) {
            bVar.a(2, null, i, i2, 0);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setAspectRatio(float f2) {
        this.f24630c = f2;
    }

    public void setBlackOut(boolean z) {
        this.f24635h = z;
    }

    public void setNotify(b bVar) {
        this.p = bVar;
    }

    private String a() {
        return "[0x" + Integer.toHexString(System.identityHashCode(this)) + " " + getWidth() + FragmentC2201x.f23219a + getHeight() + "] ";
    }

    public void a(Runnable runnable) {
        this.o.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(NexEditor nexEditor) {
        Surface surface;
        this.f24629b = nexEditor;
        NexEditor nexEditor2 = this.f24629b;
        if (nexEditor2 == null || (surface = this.n) == null) {
            return;
        }
        nexEditor2.a(surface);
    }

    private void a(boolean z, int i, int i2) {
        setSurfaceTextureListener(this);
    }

    public NexThemeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24629b = null;
        this.f24630c = EditorGlobal.l();
        this.f24631d = RenderType.None;
        this.f24632e = false;
        this.f24633f = new LinkedList();
        this.f24634g = new Handler();
        this.f24635h = false;
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.o = new ArrayList();
        a(false, 0, 0);
    }

    public NexThemeView(Context context, boolean z, int i, int i2) {
        super(context);
        this.f24629b = null;
        this.f24630c = EditorGlobal.l();
        this.f24631d = RenderType.None;
        this.f24632e = false;
        this.f24633f = new LinkedList();
        this.f24634g = new Handler();
        this.f24635h = false;
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.o = new ArrayList();
        a(z, i, i2);
    }
}
