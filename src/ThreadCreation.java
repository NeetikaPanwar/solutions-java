class ThreadDemo extends Thread{
	public void run() {
		try {
			System.out.println("Thread number" + this.currentThread().getId());
		}
		catch(Exception e){
			System.out.println("exception");
		}
	}
}

class ThreadCreation{
	public static void main(String[] args) {
		
		int n = 8;
		for(int i = 0; i < n; i++) {
			ThreadDemo demo = new ThreadDemo();
			demo.start();
		}
		
		
	}
}