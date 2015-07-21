package cn.sdu.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
	private ThreadPool() {
		// TODO Auto-generated constructor stub
	}
	
	public static void doJob(Thread thread){
		fixedThreadPool.execute(thread);
	}

}
