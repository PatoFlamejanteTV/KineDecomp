package android.support.v4.media;

import android.os.Build;
import android.support.v4.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* renamed from: a */
    private final int f1417a;

    /* renamed from: b */
    private final int f1418b;

    /* renamed from: c */
    private int f1419c;

    /* renamed from: d */
    private Callback f1420d;

    /* renamed from: e */
    private Object f1421e;

    /* renamed from: android.support.v4.media.VolumeProviderCompat$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements VolumeProviderCompatApi21.Delegate {
        AnonymousClass1() {
        }

        @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
        public void onAdjustVolume(int i) {
            VolumeProviderCompat.this.onAdjustVolume(i);
        }

        @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
        public void onSetVolumeTo(int i) {
            VolumeProviderCompat.this.onSetVolumeTo(i);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.f1417a = i;
        this.f1418b = i2;
        this.f1419c = i3;
    }

    public final int getCurrentVolume() {
        return this.f1419c;
    }

    public final int getMaxVolume() {
        return this.f1418b;
    }

    public final int getVolumeControl() {
        return this.f1417a;
    }

    public Object getVolumeProvider() {
        if (this.f1421e == null && Build.VERSION.SDK_INT >= 21) {
            this.f1421e = VolumeProviderCompatApi21.createVolumeProvider(this.f1417a, this.f1418b, this.f1419c, new VolumeProviderCompatApi21.Delegate() { // from class: android.support.v4.media.VolumeProviderCompat.1
                AnonymousClass1() {
                }

                @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
                public void onAdjustVolume(int i) {
                    VolumeProviderCompat.this.onAdjustVolume(i);
                }

                @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
                public void onSetVolumeTo(int i) {
                    VolumeProviderCompat.this.onSetVolumeTo(i);
                }
            });
        }
        return this.f1421e;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.f1420d = callback;
    }

    public final void setCurrentVolume(int i) {
        this.f1419c = i;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null && Build.VERSION.SDK_INT >= 21) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i);
        }
        Callback callback = this.f1420d;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
