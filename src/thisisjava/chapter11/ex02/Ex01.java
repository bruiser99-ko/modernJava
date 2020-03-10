package thisisjava.chapter11.ex02;

public class Ex01 {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				try {
					Thread.sleep(status * 1001);	//마지막 초가 실행되기 전에 멈춰서 시간을 1나노초 추가함
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t1 = new Thread(()->{
			int time = 0;
			while(true) {
				System.out.println(time++ + " 초");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		System.exit(10);
	}
}
