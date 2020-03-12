package thisisjava.chapter12.ex05;

public class Ex05 {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		Thread producerThread = new ProducerThread(dataBox);
		Thread consumerThread = new ConsumerThread(dataBox);
		
		producerThread.start();
		consumerThread.start();
	}
}

class DataBox {
	private String data;
	
	public synchronized String getData() {
		if(this.data == null) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		
		String returnValue = data;
		System.out.println("ConsumerThread가 읽은 데이터: " + returnValue);
		data = null;
		notify();
		return returnValue;
	}
	
	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		this.data = data;
		System.out.println("ProducerThread가 생성 데이터: " + this.data);
		notify();
	}
}

class ProducerThread extends Thread {
	private DataBox dataBox;

	public ProducerThread(DataBox dataBox) {
		this.setName("ProducerThread");
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			String data = "Data-" + i;
			dataBox.setData(data);
		}
	}
}

class ConsumerThread extends Thread {
	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		this.setName("ConsumerThread");
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			String data = dataBox.getData();
			System.out.println(data);
		}
	}
}