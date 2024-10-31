package android.support.v4.media;

import android.media.VolumeProvider;

/* loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.media.VolumeProviderCompatApi21$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 extends VolumeProvider {

        /* renamed from: a */
        final /* synthetic */ Delegate f1423a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, int i3, Delegate delegate) {
            super(i, i2, i3);
            delegate = delegate;
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i) {
            delegate.onAdjustVolume(i);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i) {
            delegate.onSetVolumeTo(i);
        }
    }

    /* loaded from: classes.dex */
    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i, int i2, int i3, Delegate delegate) {
        return new VolumeProvider(i, i2, i3) { // from class: android.support.v4.media.VolumeProviderCompatApi21.1

            /* renamed from: a */
            final /* synthetic */ Delegate f1423a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i4, int i22, int i32, Delegate delegate2) {
                super(i4, i22, i32);
                delegate = delegate2;
            }

            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i4) {
                delegate.onAdjustVolume(i4);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i4) {
                delegate.onSetVolumeTo(i4);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}
