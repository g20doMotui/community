package com.easylib.base;

/**
 * 登记式单例
 */
public abstract class BaseSingleton<T> {

    private T mInstance;

    protected abstract T create();

    public final T get() {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = create();
                }
                return mInstance;
            }
        }
}

/*
使用方式
public class Demo {
    private static final BaseSingleton<Demo> single=new BaseSingleton<Demo>() {
        @Override
        protected Demo create() {
            return new Demo();
        }
    };
    public static Demo getInstance(){
        return single.get();
    }
    private Demo(){
        System.out.println("Demo created!");
    }
}*/
