package com.grf.pattern.singleleton;

//饿汉式
public class Singleton {
	private Singleton() {
	}

	private final static Singleton sin1 = new Singleton();

	//可通过Singleton.getSingleton获得单例对象sin1
	//缺点在于无法控制sin1对象生成的时机，可能浪费内存空间
	private static Singleton getSingleton() {
		return sin1;
	}
}
