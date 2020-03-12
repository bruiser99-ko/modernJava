package thisisjava.chapter12.ex03;

public class Ex03 {
	public static void main(String[] args) {
		Thread thread = new StateThread(new TargetThread());
		thread.start();
	}
}

class TargetThread extends Thread {
	@Override
	public void run() {
		long sum = 0;
		for(int i=0; i<Integer.MAX_VALUE; i++) {sum += i;}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		for(int i=0; i<Integer.MAX_VALUE; i++) {sum += i;}
	}
}

class StateThread extends Thread {
	private Thread target;
	
	public StateThread(Thread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true) {
			Thread.State state = target.getState();
			System.out.println("타겟상태: " + state);
			if(state == Thread.State.NEW) {
				target.start();
			}
			if(state == Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}