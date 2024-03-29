package com.inspur.zqq.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	private static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		Thread thread1 = new Thread(()-> {
			lock.lock();
			try {
				//需要同步的代码块
				System.out.println("线程1加锁");
			}finally {
				//一定要在finally中解锁，否则可能死锁
				lock.unlock();
				System.out.println("线程1解锁");
			}
		});
		thread1.start();
		Thread thread2 = new Thread(() ->  {
			lock.lock();
			try {
				//要同步的代码块
				System.out.println("线程2加锁");
			}finally {
			System.out.println("线程2解锁");
			}
		});
		thread2.start();
	}
}
