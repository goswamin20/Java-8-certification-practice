package java8practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierTest {
	public static void main(String[] args) {
	CyclicBarrier cb=new CyclicBarrier(3, new Action());
	System.out.println("Cyclic Barrie starting");
	new MyThread(cb, "A");
	new MyThread(cb, "B");
	new MyThread(cb, "C");
	new MyThread(cb, "X");
	new MyThread(cb, "Y");
	new MyThread(cb, "Z");
}
}
class MyThread implements Runnable{
	String name;
	CyclicBarrier c;
	public MyThread(CyclicBarrier c,String name){
		this.c=c;
		this.name=name;
		new Thread(this).start();
	}
	public void run() {
		System.out.println(name);
		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}