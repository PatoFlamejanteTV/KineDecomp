package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@NoAutoExceptionHandling
@SuppressLint({"EmptyCatchBlock", "CatchGeneralException", "WrongCall"})
/* renamed from: com.facebook.ads.redexgen.X.Im, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0471Im extends LinearLayout {
    public static final AtomicBoolean A00 = new AtomicBoolean();
    public static final AtomicReference<InterfaceC0408Fx> A01 = new AtomicReference<>();

    private final void A00() {
        super.onAttachedToWindow();
    }

    private final void A01() {
        super.onDetachedFromWindow();
    }

    private final void A02() {
        super.onFinishInflate();
    }

    private final void A03(int i) {
        super.onWindowVisibilityChanged(i);
    }

    private final void A04(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private final void A05(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private final void A06(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void A07(Throwable th) {
        C0479Iu.A00().A5N(3305, th);
        InterfaceC0408Fx interfaceC0408Fx = A01.get();
        if (interfaceC0408Fx != null) {
            interfaceC0408Fx.A88(th, this);
        }
    }

    private final void A08(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private final void A09(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private final void A0A(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    public static void A0B(boolean z, InterfaceC0408Fx interfaceC0408Fx) {
        A00.set(z);
        A01.set(interfaceC0408Fx);
    }

    private final boolean A0C() {
        return super.performClick();
    }

    private final boolean A0D(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    private final boolean A0E(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    private final boolean A0F(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private final boolean A0G(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A00();
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onAttachedToWindow();
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A01();
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onDetachedFromWindow();
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas canvas) {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        canvas = canvas;
                        c0471Im.A06(canvas);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onDraw(canvas);
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A02();
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onFinishInflate();
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        rect = rect;
                        c0471Im.A0A(z, i, rect);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onFocusChanged(z, i, rect);
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        C0471Im c0471Im = this;
        boolean z = false;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        keyEvent = keyEvent;
                        z = c0471Im.A0D(i, keyEvent);
                        c = 6;
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 7;
                            break;
                        } else {
                            c = 5;
                            break;
                        }
                    }
                case 5:
                    c0471Im = c0471Im;
                    keyEvent = keyEvent;
                    th = th;
                    c0471Im.A07(th);
                    z = super.onKeyDown(i, keyEvent);
                    c = 6;
                    break;
                case 6:
                    return z;
                case 7:
                    throw th;
            }
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        C0471Im c0471Im = this;
        boolean z = false;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        keyEvent = keyEvent;
                        z = c0471Im.A0E(i, keyEvent);
                        c = 6;
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 7;
                            break;
                        } else {
                            c = 5;
                            break;
                        }
                    }
                case 5:
                    c0471Im = c0471Im;
                    keyEvent = keyEvent;
                    th = th;
                    c0471Im.A07(th);
                    z = super.onKeyUp(i, keyEvent);
                    c = 6;
                    break;
                case 6:
                    return z;
                case 7:
                    throw th;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A09(z, i, i2, i3, i4);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onLayout(z, i, i2, i3, i4);
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A04(i, i2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onMeasure(i, i2);
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A05(i, i2, i3, i4);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onSizeChanged(i, i2, i3, i4);
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0471Im c0471Im = this;
        boolean z = false;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        motionEvent = motionEvent;
                        z = c0471Im.A0F(motionEvent);
                        c = 6;
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 7;
                            break;
                        } else {
                            c = 5;
                            break;
                        }
                    }
                case 5:
                    c0471Im = c0471Im;
                    motionEvent = motionEvent;
                    th = th;
                    c0471Im.A07(th);
                    z = super.onTouchEvent(motionEvent);
                    c = 6;
                    break;
                case 6:
                    return z;
                case 7:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        C0471Im c0471Im = this;
        boolean z = false;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        motionEvent = motionEvent;
                        z = c0471Im.A0G(motionEvent);
                        c = 6;
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 7;
                            break;
                        } else {
                            c = 5;
                            break;
                        }
                    }
                case 5:
                    c0471Im = c0471Im;
                    motionEvent = motionEvent;
                    th = th;
                    c0471Im.A07(th);
                    z = super.onTrackballEvent(motionEvent);
                    c = 6;
                    break;
                case 6:
                    return z;
                case 7:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A08(z);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onWindowFocusChanged(z);
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        C0471Im c0471Im = this;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        c0471Im.A03(i);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 6;
                            break;
                        } else {
                            c = 4;
                            break;
                        }
                    }
                case 4:
                    C0471Im c0471Im2 = c0471Im;
                    c0471Im2.A07(th);
                    super.onWindowVisibilityChanged(i);
                    return;
                case 6:
                    throw th;
            }
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        C0471Im c0471Im = this;
        boolean z = false;
        Throwable th = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0471Im = c0471Im;
                        z = c0471Im.A0C();
                        c = 6;
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!A00.get()) {
                            c = 7;
                            break;
                        } else {
                            c = 5;
                            break;
                        }
                    }
                case 5:
                    c0471Im = c0471Im;
                    th = th;
                    c0471Im.A07(th);
                    z = super.performClick();
                    c = 6;
                    break;
                case 6:
                    return z;
                case 7:
                    throw th;
            }
        }
    }
}