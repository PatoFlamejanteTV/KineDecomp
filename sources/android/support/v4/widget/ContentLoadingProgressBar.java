package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a */
    long f1942a;

    /* renamed from: b */
    boolean f1943b;

    /* renamed from: c */
    boolean f1944c;

    /* renamed from: d */
    boolean f1945d;

    /* renamed from: e */
    private final Runnable f1946e;

    /* renamed from: f */
    private final Runnable f1947f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.widget.ContentLoadingProgressBar$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f1943b = false;
            contentLoadingProgressBar.f1942a = -1L;
            contentLoadingProgressBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.widget.ContentLoadingProgressBar$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f1944c = false;
            if (contentLoadingProgressBar.f1945d) {
                return;
            }
            contentLoadingProgressBar.f1942a = System.currentTimeMillis();
            ContentLoadingProgressBar.this.setVisibility(0);
        }
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    private void a() {
        removeCallbacks(this.f1946e);
        removeCallbacks(this.f1947f);
    }

    public synchronized void hide() {
        this.f1945d = true;
        removeCallbacks(this.f1947f);
        this.f1944c = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f1942a;
        if (currentTimeMillis < 500 && this.f1942a != -1) {
            if (!this.f1943b) {
                postDelayed(this.f1946e, 500 - currentTimeMillis);
                this.f1943b = true;
            }
        }
        setVisibility(8);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public synchronized void show() {
        this.f1942a = -1L;
        this.f1945d = false;
        removeCallbacks(this.f1946e);
        this.f1943b = false;
        if (!this.f1944c) {
            postDelayed(this.f1947f, 500L);
            this.f1944c = true;
        }
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1942a = -1L;
        this.f1943b = false;
        this.f1944c = false;
        this.f1945d = false;
        this.f1946e = new Runnable() { // from class: android.support.v4.widget.ContentLoadingProgressBar.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.f1943b = false;
                contentLoadingProgressBar.f1942a = -1L;
                contentLoadingProgressBar.setVisibility(8);
            }
        };
        this.f1947f = new Runnable() { // from class: android.support.v4.widget.ContentLoadingProgressBar.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.f1944c = false;
                if (contentLoadingProgressBar.f1945d) {
                    return;
                }
                contentLoadingProgressBar.f1942a = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        };
    }
}
