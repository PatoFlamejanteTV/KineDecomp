package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.engine.E;
import java.io.IOException;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class A<T> implements com.bumptech.glide.load.h<T, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.f<Long> f8990a = com.bumptech.glide.load.f.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new y());

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.f<Integer> f8991b = com.bumptech.glide.load.f.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new z());

    /* renamed from: c, reason: collision with root package name */
    private static final b f8992c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final c<T> f8993d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f8994e;

    /* renamed from: f, reason: collision with root package name */
    private final b f8995f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(y yVar) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.A.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.A.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    A(com.bumptech.glide.load.engine.a.e eVar, c<T> cVar) {
        this(eVar, cVar, f8992c);
    }

    public static com.bumptech.glide.load.h<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.engine.a.e eVar) {
        return new A(eVar, new a(null));
    }

    public static com.bumptech.glide.load.h<ParcelFileDescriptor, Bitmap> b(com.bumptech.glide.load.engine.a.e eVar) {
        return new A(eVar, new d());
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(T t, com.bumptech.glide.load.g gVar) {
        return true;
    }

    A(com.bumptech.glide.load.engine.a.e eVar, c<T> cVar, b bVar) {
        this.f8994e = eVar;
        this.f8993d = cVar;
        this.f8995f = bVar;
    }

    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b2 = downsampleStrategy.b(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * b2), Math.round(b2 * parseInt2));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.h
    public E<Bitmap> a(T t, int i, int i2, com.bumptech.glide.load.g gVar) throws IOException {
        long longValue = ((Long) gVar.a(f8990a)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) gVar.a(f8991b);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) gVar.a(DownsampleStrategy.f9003h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f9002g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a2 = this.f8995f.a();
        try {
            try {
                this.f8993d.a(a2, t);
                Bitmap a3 = a(a2, longValue, num.intValue(), i, i2, downsampleStrategy2);
                a2.release();
                return com.bumptech.glide.load.resource.bitmap.d.a(a3, this.f8994e);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap b2 = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f9001f) ? null : b(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return b2 == null ? a(mediaMetadataRetriever, j, i) : b2;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }
}
