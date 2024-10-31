package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class MediaSessionCompatApi21 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSetRating(Object obj, Bundle bundle);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSession.Callback {

        /* renamed from: a */
        protected final T f1502a;

        public CallbackProxy(T t) {
            this.f1502a = t;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f1502a.onCommand(str, bundle, resultReceiver);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String str, Bundle bundle) {
            this.f1502a.onCustomAction(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.f1502a.onFastForward();
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            return this.f1502a.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.f1502a.onPause();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.f1502a.onPlay();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            this.f1502a.onPlayFromMediaId(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            this.f1502a.onPlayFromSearch(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.f1502a.onRewind();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            this.f1502a.onSeekTo(j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            this.f1502a.onSetRating(rating);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.f1502a.onSkipToNext();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.f1502a.onSkipToPrevious();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j) {
            this.f1502a.onSkipToQueueItem(j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.f1502a.onStop();
        }
    }

    /* loaded from: classes.dex */
    static class QueueItem {
        QueueItem() {
        }

        public static Object createItem(Object obj, long j) {
            return new MediaSession.QueueItem((MediaDescription) obj, j);
        }

        public static Object getDescription(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        public static long getQueueId(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }

    MediaSessionCompatApi21() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static Object createSession(Context context, String str) {
        return new MediaSession(context, str);
    }

    public static Parcelable getSessionToken(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    public static boolean hasCallback(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mCallback");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj) != null;
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.w("MediaSessionCompatApi21", "Failed to get mCallback object.");
        }
        return false;
    }

    public static boolean isActive(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    public static void release(Object obj) {
        ((MediaSession) obj).release();
    }

    public static void sendSessionEvent(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void setActive(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    public static void setCallback(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
    }

    public static void setExtras(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    public static void setFlags(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    public static void setMediaButtonReceiver(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    public static void setMetadata(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    public static void setPlaybackState(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    public static void setPlaybackToLocal(Object obj, int i) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    public static void setPlaybackToRemote(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    public static void setQueue(Object obj, List<Object> list) {
        if (list == null) {
            ((MediaSession) obj).setQueue(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MediaSession.QueueItem) it.next());
        }
        ((MediaSession) obj).setQueue(arrayList);
    }

    public static void setQueueTitle(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    public static void setSessionActivity(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    public static Object verifySession(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object verifyToken(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}