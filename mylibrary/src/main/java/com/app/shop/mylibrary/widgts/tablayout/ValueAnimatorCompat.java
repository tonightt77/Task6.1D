package com.app.shop.mylibrary.widgts.tablayout;

import android.view.animation.Interpolator;

class ValueAnimatorCompat {

    interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimatorCompat animator);
    }

    interface AnimatorListener {
        void onAnimationStart(ValueAnimatorCompat animator);
        void onAnimationEnd(ValueAnimatorCompat animator);
        void onAnimationCancel(ValueAnimatorCompat animator);
    }

    static class AnimatorListenerAdapter implements AnimatorListener {
        @Override
        public void onAnimationStart(ValueAnimatorCompat animator) {
        }

        @Override
        public void onAnimationEnd(ValueAnimatorCompat animator) {
        }

        @Override
        public void onAnimationCancel(ValueAnimatorCompat animator) {
        }
    }

    interface Creator {
        ValueAnimatorCompat createAnimator();
    }

    static abstract class Impl {
        interface AnimatorUpdateListenerProxy {
            void onAnimationUpdate();
        }

        interface AnimatorListenerProxy {
            void onAnimationStart();
            void onAnimationEnd();
            void onAnimationCancel();
        }

        abstract void start();
        abstract boolean isRunning();
        abstract void setInterpolator(Interpolator interpolator);
        abstract void setListener(AnimatorListenerProxy listener);
        abstract void setUpdateListener(AnimatorUpdateListenerProxy updateListener);
        abstract void setIntValues(int from, int to);
        abstract int getAnimatedIntValue();
        abstract void setFloatValues(float from, float to);
        abstract float getAnimatedFloatValue();
        abstract void setDuration(int duration);
        abstract void cancel();
        abstract float getAnimatedFraction();
        abstract void end();
        abstract long getDuration();
    }

    private final Impl mImpl;

    ValueAnimatorCompat(Impl impl) {
        mImpl = impl;
    }

    public void start() {
        mImpl.start();
    }

    public boolean isRunning() {
        return mImpl.isRunning();
    }

    public void setInterpolator(Interpolator interpolator) {
        mImpl.setInterpolator(interpolator);
    }

    public void setUpdateListener(final AnimatorUpdateListener updateListener) {
        if (updateListener != null) {
            mImpl.setUpdateListener(new Impl.AnimatorUpdateListenerProxy() {
                @Override
                public void onAnimationUpdate() {
                    updateListener.onAnimationUpdate(ValueAnimatorCompat.this);
                }
            });
        } else {
            mImpl.setUpdateListener(null);
        }
    }

    public void setListener(final AnimatorListener listener) {
        if (listener != null) {
            mImpl.setListener(new Impl.AnimatorListenerProxy() {
                @Override
                public void onAnimationStart() {
                    listener.onAnimationStart(ValueAnimatorCompat.this);
                }

                @Override
                public void onAnimationEnd() {
                    listener.onAnimationEnd(ValueAnimatorCompat.this);
                }

                @Override
                public void onAnimationCancel() {
                    listener.onAnimationCancel(ValueAnimatorCompat.this);
                }
            });
        } else {
            mImpl.setListener(null);
        }
    }

    public void setIntValues(int from, int to) {
        mImpl.setIntValues(from, to);
    }

    public int getAnimatedIntValue() {
        return mImpl.getAnimatedIntValue();
    }

    public void setFloatValues(float from, float to) {
        mImpl.setFloatValues(from, to);
    }

    public float getAnimatedFloatValue() {
        return mImpl.getAnimatedFloatValue();
    }

    public void setDuration(int duration) {
        mImpl.setDuration(duration);
    }

    public void cancel() {
        mImpl.cancel();
    }

    public float getAnimatedFraction() {
        return mImpl.getAnimatedFraction();
    }

    public void end() {
        mImpl.end();
    }

    public long getDuration() {
        return mImpl.getDuration();
    }
}
