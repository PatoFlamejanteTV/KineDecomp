package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.SupportActivity;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaControllerCompatApi23;
import android.support.v4.media.session.MediaControllerCompatApi24;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    private final MediaControllerImpl f1434a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaSessionCompat.Token f1435b;

    /* renamed from: c, reason: collision with root package name */
    private final HashSet<Callback> f1436c = new HashSet<>();

    /* loaded from: classes.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        private final Object f1437a;

        /* renamed from: b, reason: collision with root package name */
        MessageHandler f1438b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1439c;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class MessageHandler extends Handler {

            /* renamed from: a, reason: collision with root package name */
            boolean f1440a;

            MessageHandler(Looper looper) {
                super(looper);
                this.f1440a = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f1440a) {
                    switch (message.what) {
                        case 1:
                            Callback.this.onSessionEvent((String) message.obj, message.getData());
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Callback.this.onExtrasChanged((Bundle) message.obj);
                            return;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            return;
                        case 9:
                            Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 10:
                        default:
                            return;
                        case 11:
                            Callback.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            Callback.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            Callback.this.onSessionReady();
                            return;
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        private static class StubApi21 implements MediaControllerCompatApi21.Callback {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<Callback> f1442a;

            StubApi21(Callback callback) {
                this.f1442a = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
                Callback callback = this.f1442a.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(i, i2, i3, i4, i5));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onExtrasChanged(Bundle bundle) {
                Callback callback = this.f1442a.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(Object obj) {
                Callback callback = this.f1442a.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(Object obj) {
                Callback callback = this.f1442a.get();
                if (callback == null || callback.f1439c) {
                    return;
                }
                callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueChanged(List<?> list) {
                Callback callback = this.f1442a.get();
                if (callback != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = this.f1442a.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                Callback callback = this.f1442a.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                Callback callback = this.f1442a.get();
                if (callback != null) {
                    if (!callback.f1439c || Build.VERSION.SDK_INT >= 23) {
                        callback.onSessionEvent(str, bundle);
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        private static class StubCompat extends IMediaControllerCallback.Stub {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<Callback> f1443a;

            StubCompat(Callback callback) {
                this.f1443a = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(12, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = this.f1443a.get();
                if (callback != null) {
                    callback.a(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, null);
                }
            }
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1437a = MediaControllerCompatApi21.createCallback(new StubApi21(this));
            } else {
                this.f1437a = new StubCompat(this);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            onSessionDestroyed();
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i) {
        }

        void a(Handler handler) {
            if (handler == null) {
                MessageHandler messageHandler = this.f1438b;
                if (messageHandler != null) {
                    messageHandler.f1440a = false;
                    messageHandler.removeCallbacksAndMessages(null);
                    this.f1438b = null;
                    return;
                }
                return;
            }
            this.f1438b = new MessageHandler(handler.getLooper());
            this.f1438b.f1440a = true;
        }

        void a(int i, Object obj, Bundle bundle) {
            MessageHandler messageHandler = this.f1438b;
            if (messageHandler != null) {
                Message obtainMessage = messageHandler.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class MediaControllerExtraData extends SupportActivity.ExtraData {

        /* renamed from: a, reason: collision with root package name */
        private final MediaControllerCompat f1444a;

        MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
            this.f1444a = mediaControllerCompat;
        }

        MediaControllerCompat a() {
            return this.f1444a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i);

        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 implements MediaControllerImpl {

        /* renamed from: a, reason: collision with root package name */
        protected final Object f1445a;

        /* renamed from: c, reason: collision with root package name */
        private IMediaSession f1447c;

        /* renamed from: b, reason: collision with root package name */
        private final List<Callback> f1446b = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private HashMap<Callback, ExtraCallback> f1448d = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f1449a;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21, Handler handler) {
                super(handler);
                this.f1449a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f1449a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                mediaControllerImplApi21.f1447c = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                mediaControllerImplApi21.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat mediaSessionCompat) {
            this.f1445a = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat.getSessionToken().getToken());
            this.f1447c = mediaSessionCompat.getSessionToken().getExtraBinder();
            if (this.f1447c == null) {
                b();
            }
        }

        private void b() {
            sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this, new Handler()));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
                sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int i, int i2) {
            MediaControllerCompatApi21.adjustVolume(this.f1445a, i, i2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.f1445a, keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.f1445a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.f1445a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return this.f1445a;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            Object metadata = MediaControllerCompatApi21.getMetadata(this.f1445a);
            if (metadata != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.f1445a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.f1445a);
            if (playbackInfo != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo));
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            IMediaSession iMediaSession = this.f1447c;
            if (iMediaSession != null) {
                try {
                    return iMediaSession.getPlaybackState();
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e2);
                }
            }
            Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.f1445a);
            if (playbackState != null) {
                return PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> queue = MediaControllerCompatApi21.getQueue(this.f1445a);
            if (queue != null) {
                return MediaSessionCompat.QueueItem.fromQueueItemList(queue);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.f1445a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            IMediaSession iMediaSession;
            if (Build.VERSION.SDK_INT < 22 && (iMediaSession = this.f1447c) != null) {
                try {
                    return iMediaSession.getRatingType();
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in getRatingType.", e2);
                }
            }
            return MediaControllerCompatApi21.getRatingType(this.f1445a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            IMediaSession iMediaSession = this.f1447c;
            if (iMediaSession == null) {
                return -1;
            }
            try {
                return iMediaSession.getRepeatMode();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e2);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.f1445a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            IMediaSession iMediaSession = this.f1447c;
            if (iMediaSession == null) {
                return -1;
            }
            try {
                return iMediaSession.getShuffleMode();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e2);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.f1445a);
            if (transportControls != null) {
                return new TransportControlsApi21(transportControls);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            IMediaSession iMediaSession = this.f1447c;
            if (iMediaSession == null) {
                return false;
            }
            try {
                return iMediaSession.isCaptioningEnabled();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e2);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return this.f1447c != null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(Callback callback, Handler handler) {
            MediaControllerCompatApi21.registerCallback(this.f1445a, callback.f1437a, handler);
            if (this.f1447c != null) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.f1448d.put(callback, extraCallback);
                callback.f1439c = true;
                try {
                    this.f1447c.registerCallbackListener(extraCallback);
                    return;
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                    return;
                }
            }
            synchronized (this.f1446b) {
                callback.f1439c = false;
                this.f1446b.add(callback);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
                sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.sendCommand(this.f1445a, str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i, int i2) {
            MediaControllerCompatApi21.setVolumeTo(this.f1445a, i, i2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.unregisterCallback(this.f1445a, callback.f1437a);
            if (this.f1447c != null) {
                try {
                    ExtraCallback remove = this.f1448d.remove(callback);
                    if (remove != null) {
                        callback.f1439c = false;
                        this.f1447c.unregisterCallbackListener(remove);
                        return;
                    }
                    return;
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e2);
                    return;
                }
            }
            synchronized (this.f1446b) {
                this.f1446b.remove(callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f1447c == null) {
                return;
            }
            synchronized (this.f1446b) {
                for (Callback callback : this.f1446b) {
                    ExtraCallback extraCallback = new ExtraCallback(callback);
                    this.f1448d.put(callback, extraCallback);
                    callback.f1439c = true;
                    try {
                        this.f1447c.registerCallbackListener(extraCallback);
                        callback.onSessionReady();
                    } catch (RemoteException e2) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                    }
                }
                this.f1446b.clear();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
                bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", i);
                sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.f1445a = MediaControllerCompatApi21.fromToken(context, token.getToken());
            if (this.f1445a != null) {
                this.f1447c = token.getExtraBinder();
                if (this.f1447c == null) {
                    b();
                    return;
                }
                return;
            }
            throw new RemoteException();
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.f1445a);
            if (transportControls != null) {
                return new TransportControlsApi23(transportControls);
            }
            return null;
        }

        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.f1445a);
            if (transportControls != null) {
                return new TransportControlsApi24(transportControls);
            }
            return null;
        }

        public MediaControllerImplApi24(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;

        /* renamed from: a, reason: collision with root package name */
        private final int f1452a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1453b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1454c;

        /* renamed from: d, reason: collision with root package name */
        private final int f1455d;

        /* renamed from: e, reason: collision with root package name */
        private final int f1456e;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.f1452a = i;
            this.f1453b = i2;
            this.f1454c = i3;
            this.f1455d = i4;
            this.f1456e = i5;
        }

        public int getAudioStream() {
            return this.f1453b;
        }

        public int getCurrentVolume() {
            return this.f1456e;
        }

        public int getMaxVolume() {
            return this.f1455d;
        }

        public int getPlaybackType() {
            return this.f1452a;
        }

        public int getVolumeControl() {
            return this.f1454c;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        TransportControls() {
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleMode(int i);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    /* loaded from: classes.dex */
    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.f1457a, uri, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            MediaControllerCompatApi24.TransportControls.prepare(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.f1457a, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.f1457a, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromUri(this.f1457a, uri, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class TransportControlsBase extends TransportControls {

        /* renamed from: a, reason: collision with root package name */
        private IMediaSession f1458a;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.f1458a = iMediaSession;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            try {
                this.f1458a.fastForward();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in fastForward.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            try {
                this.f1458a.pause();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in pause.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            try {
                this.f1458a.play();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in play.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.f1458a.playFromMediaId(str, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.f1458a.playFromSearch(str, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.f1458a.playFromUri(uri, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            try {
                this.f1458a.prepare();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in prepare.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            try {
                this.f1458a.prepareFromMediaId(str, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            try {
                this.f1458a.prepareFromSearch(str, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            try {
                this.f1458a.prepareFromUri(uri, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            try {
                this.f1458a.rewind();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in rewind.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            try {
                this.f1458a.seekTo(j);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in seekTo.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean z) {
            try {
                this.f1458a.setCaptioningEnabled(z);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            try {
                this.f1458a.rate(ratingCompat);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i) {
            try {
                this.f1458a.setRepeatMode(i);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i) {
            try {
                this.f1458a.setShuffleMode(i);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in setShuffleMode.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            try {
                this.f1458a.next();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            try {
                this.f1458a.previous();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            try {
                this.f1458a.skipToQueueItem(j);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            try {
                this.f1458a.stop();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in stop.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.b(str, bundle);
            try {
                this.f1458a.sendCustomAction(str, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            try {
                this.f1458a.rateWithExtras(ratingCompat, bundle);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", e2);
            }
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat != null) {
            this.f1435b = mediaSessionCompat.getSessionToken();
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                this.f1434a = new MediaControllerImplApi24(context, mediaSessionCompat);
                return;
            }
            if (i >= 23) {
                this.f1434a = new MediaControllerImplApi23(context, mediaSessionCompat);
                return;
            } else if (i >= 21) {
                this.f1434a = new MediaControllerImplApi21(context, mediaSessionCompat);
                return;
            } else {
                this.f1434a = new MediaControllerImplBase(this.f1435b);
                return;
            }
        }
        throw new IllegalArgumentException("session must not be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, Bundle bundle) {
        if (str == null) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1348483723) {
            if (hashCode == 503011406 && str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
                c2 = 1;
            }
        } else if (str.equals(MediaSessionCompat.ACTION_FOLLOW)) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1) {
            if (bundle == null || !bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
            }
        }
    }

    public static MediaControllerCompat getMediaController(Activity activity) {
        Object mediaController;
        if (activity instanceof SupportActivity) {
            MediaControllerExtraData mediaControllerExtraData = (MediaControllerExtraData) ((SupportActivity) activity).getExtraData(MediaControllerExtraData.class);
            if (mediaControllerExtraData != null) {
                return mediaControllerExtraData.a();
            }
            return null;
        }
        if (Build.VERSION.SDK_INT < 21 || (mediaController = MediaControllerCompatApi21.getMediaController(activity)) == null) {
            return null;
        }
        try {
            return new MediaControllerCompat(activity, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.getSessionToken(mediaController)));
        } catch (RemoteException e2) {
            Log.e("MediaControllerCompat", "Dead object in getMediaController.", e2);
            return null;
        }
    }

    public static void setMediaController(Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof SupportActivity) {
            ((SupportActivity) activity).putExtraData(new MediaControllerExtraData(mediaControllerCompat));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            MediaControllerCompatApi21.setMediaController(activity, mediaControllerCompat != null ? MediaControllerCompatApi21.fromToken(activity, mediaControllerCompat.getSessionToken().getToken()) : null);
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f1434a.addQueueItem(mediaDescriptionCompat);
    }

    public void adjustVolume(int i, int i2) {
        this.f1434a.adjustVolume(i, i2);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f1434a.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.f1434a.getExtras();
    }

    public long getFlags() {
        return this.f1434a.getFlags();
    }

    public MediaMetadataCompat getMetadata() {
        return this.f1434a.getMetadata();
    }

    public String getPackageName() {
        return this.f1434a.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.f1434a.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.f1434a.getPlaybackState();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.f1434a.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.f1434a.getQueueTitle();
    }

    public int getRatingType() {
        return this.f1434a.getRatingType();
    }

    public int getRepeatMode() {
        return this.f1434a.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        return this.f1434a.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.f1435b;
    }

    public int getShuffleMode() {
        return this.f1434a.getShuffleMode();
    }

    public TransportControls getTransportControls() {
        return this.f1434a.getTransportControls();
    }

    public boolean isCaptioningEnabled() {
        return this.f1434a.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.f1434a.isSessionReady();
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f1434a.removeQueueItem(mediaDescriptionCompat);
    }

    @Deprecated
    public void removeQueueItemAt(int i) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue == null || i < 0 || i >= queue.size() || (queueItem = queue.get(i)) == null) {
            return;
        }
        removeQueueItem(queueItem.getDescription());
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty(str)) {
            this.f1434a.sendCommand(str, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public void setVolumeTo(int i, int i2) {
        this.f1434a.setVolumeTo(i, i2);
    }

    public void unregisterCallback(Callback callback) {
        if (callback != null) {
            try {
                this.f1436c.remove(callback);
                this.f1434a.unregisterCallback(callback);
                return;
            } finally {
                callback.a((Handler) null);
            }
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        this.f1434a.addQueueItem(mediaDescriptionCompat, i);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback != null) {
            if (handler == null) {
                handler = new Handler();
            }
            callback.a(handler);
            this.f1434a.registerCallback(callback, handler);
            this.f1436c.add(callback);
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    /* loaded from: classes.dex */
    static class TransportControlsApi21 extends TransportControls {

        /* renamed from: a, reason: collision with root package name */
        protected final Object f1457a;

        public TransportControlsApi21(Object obj) {
            this.f1457a = obj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.f1457a, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.f1457a, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri != null && !Uri.EMPTY.equals(uri)) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
                bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
                sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
                return;
            }
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            sendCustomAction("android.support.v4.media.session.action.PREPARE", (Bundle) null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.f1457a, j);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.b(customAction.getAction(), bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f1457a, customAction.getAction(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", z);
            sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            MediaControllerCompatApi21.TransportControls.setRating(this.f1457a, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i);
            sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", i);
            sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.f1457a, j);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.f1457a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", ratingCompat);
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.SET_RATING", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.b(str, bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f1457a, str, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplBase implements MediaControllerImpl {

        /* renamed from: a, reason: collision with root package name */
        private IMediaSession f1450a;

        /* renamed from: b, reason: collision with root package name */
        private TransportControls f1451b;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.f1450a = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f1450a.getFlags() & 4) != 0) {
                    this.f1450a.addQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItem.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int i, int i2) {
            try {
                this.f1450a.adjustVolume(i, i2, null);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.f1450a.sendMediaButton(keyEvent);
                    return false;
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e2);
                    return false;
                }
            }
            throw new IllegalArgumentException("event may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            try {
                return this.f1450a.getExtras();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getExtras.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            try {
                return this.f1450a.getFlags();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getFlags.", e2);
                return 0L;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            try {
                return this.f1450a.getMetadata();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            try {
                return this.f1450a.getPackageName();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.f1450a.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.f1450a.getPlaybackState();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.f1450a.getQueue();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getQueue.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            try {
                return this.f1450a.getQueueTitle();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            try {
                return this.f1450a.getRatingType();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType.", e2);
                return 0;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            try {
                return this.f1450a.getRepeatMode();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e2);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            try {
                return this.f1450a.getLaunchPendingIntent();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            try {
                return this.f1450a.getShuffleMode();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e2);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            if (this.f1451b == null) {
                this.f1451b = new TransportControlsBase(this.f1450a);
            }
            return this.f1451b;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            try {
                return this.f1450a.isCaptioningEnabled();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e2);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return true;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback callback, Handler handler) {
            if (callback != null) {
                try {
                    this.f1450a.asBinder().linkToDeath(callback, 0);
                    this.f1450a.registerCallbackListener((IMediaControllerCallback) callback.f1437a);
                    return;
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                    callback.onSessionDestroyed();
                    return;
                }
            }
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f1450a.getFlags() & 4) != 0) {
                    this.f1450a.removeQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.f1450a.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i, int i2) {
            try {
                this.f1450a.setVolumeTo(i, i2, null);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", e2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback callback) {
            if (callback != null) {
                try {
                    this.f1450a.unregisterCallbackListener((IMediaControllerCallback) callback.f1437a);
                    this.f1450a.asBinder().unlinkToDeath(callback, 0);
                    return;
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e2);
                    return;
                }
            }
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            try {
                if ((this.f1450a.getFlags() & 4) != 0) {
                    this.f1450a.addQueueItemAt(mediaDescriptionCompat, i);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", e2);
            }
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token != null) {
            this.f1435b = token;
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                this.f1434a = new MediaControllerImplApi24(context, token);
                return;
            }
            if (i >= 23) {
                this.f1434a = new MediaControllerImplApi23(context, token);
                return;
            } else if (i >= 21) {
                this.f1434a = new MediaControllerImplApi21(context, token);
                return;
            } else {
                this.f1434a = new MediaControllerImplBase(this.f1435b);
                return;
            }
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public Object getMediaController() {
        return this.f1434a.getMediaController();
    }
}
