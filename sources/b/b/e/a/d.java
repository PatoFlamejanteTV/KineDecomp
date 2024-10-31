package b.b.e.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import b.b.e.a.b;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class d extends j implements b.b.e.a.b {

    /* renamed from: b */
    private a f3302b;

    /* renamed from: c */
    private Context f3303c;

    /* renamed from: d */
    private ArgbEvaluator f3304d;

    /* renamed from: e */
    private Animator.AnimatorListener f3305e;

    /* renamed from: f */
    private ArrayList<b.a> f3306f;

    /* renamed from: g */
    final Drawable.Callback f3307g;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a */
        int f3308a;

        /* renamed from: b */
        k f3309b;

        /* renamed from: c */
        AnimatorSet f3310c;

        /* renamed from: d */
        private ArrayList<Animator> f3311d;

        /* renamed from: e */
        ArrayMap<Animator, String> f3312e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f3308a = aVar.f3308a;
                k kVar = aVar.f3309b;
                if (kVar != null) {
                    Drawable.ConstantState constantState = kVar.getConstantState();
                    if (resources != null) {
                        this.f3309b = (k) constantState.newDrawable(resources);
                    } else {
                        this.f3309b = (k) constantState.newDrawable();
                    }
                    k kVar2 = this.f3309b;
                    kVar2.mutate();
                    this.f3309b = kVar2;
                    this.f3309b.setCallback(callback);
                    this.f3309b.setBounds(aVar.f3309b.getBounds());
                    this.f3309b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.f3311d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f3311d = new ArrayList<>(size);
                    this.f3312e = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f3311d.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.f3312e.get(animator);
                        clone.setTarget(this.f3309b.a(str));
                        this.f3311d.add(clone);
                        this.f3312e.put(clone, str);
                    }
                    a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3308a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void a() {
            if (this.f3310c == null) {
                this.f3310c = new AnimatorSet();
            }
            this.f3310c.playTogether(this.f3311d);
        }
    }

    d() {
        this(null, null, null);
    }

    public static d a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        d dVar = new d(context);
        dVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return dVar;
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.applyTheme(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return DrawableCompat.canApplyTheme(drawable);
        }
        return false;
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f3302b.f3309b.draw(canvas);
        if (this.f3302b.f3310c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.f3302b.f3309b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3302b.f3308a;
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f3318a;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(drawable.getConstantState());
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f3302b.f3309b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f3302b.f3309b.getIntrinsicWidth();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f3302b.f3309b.getOpacity();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, b.b.e.a.a.f3297e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        k a2 = k.a(resources, resourceId, theme);
                        a2.a(false);
                        a2.setCallback(this.f3307g);
                        k kVar = this.f3302b.f3309b;
                        if (kVar != null) {
                            kVar.setCallback(null);
                        }
                        this.f3302b.f3309b = a2;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, b.b.e.a.a.f3298f);
                    String string = obtainAttributes2.getString(0);
                    int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f3303c;
                        if (context != null) {
                            a(string, g.a(context, resourceId2));
                        } else {
                            obtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f3302b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.f3302b.f3309b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f3302b.f3310c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f3302b.f3309b.isStateful();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f3302b.f3309b.setBounds(rect);
        }
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f3302b.f3309b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f3302b.f3309b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f3302b.f3309b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f3302b.f3309b.setAutoMirrored(z);
        }
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
        } else {
            this.f3302b.f3309b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        } else {
            this.f3302b.f3309b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        } else {
            this.f3302b.f3309b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f3302b.f3309b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f3302b.f3310c.isStarted()) {
                return;
            }
            this.f3302b.f3310c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f3302b.f3310c.end();
        }
    }

    private d(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3302b.f3309b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class b extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f3313a;

        public b(Drawable.ConstantState constantState) {
            this.f3313a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3313a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3313a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            d dVar = new d();
            dVar.f3318a = this.f3313a.newDrawable();
            dVar.f3318a.setCallback(dVar.f3307g);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            d dVar = new d();
            dVar.f3318a = this.f3313a.newDrawable(resources);
            dVar.f3318a.setCallback(dVar.f3307g);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            dVar.f3318a = this.f3313a.newDrawable(resources, theme);
            dVar.f3318a.setCallback(dVar.f3307g);
            return dVar;
        }
    }

    private d(Context context, a aVar, Resources resources) {
        this.f3304d = null;
        this.f3305e = null;
        this.f3306f = null;
        this.f3307g = new c(this);
        this.f3303c = context;
        if (aVar != null) {
            this.f3302b = aVar;
        } else {
            this.f3302b = new a(context, aVar, this.f3307g, resources);
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f3304d == null) {
                    this.f3304d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f3304d);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f3302b.f3309b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.f3302b.f3311d == null) {
            this.f3302b.f3311d = new ArrayList();
            this.f3302b.f3312e = new ArrayMap<>();
        }
        this.f3302b.f3311d.add(animator);
        this.f3302b.f3312e.put(animator, str);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
