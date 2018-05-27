
class ThreadDemo2 implements Runnable{
	
	public void run() {
		try {
			System.out.println("Thread number" + Thread.currentThread().getId());
		}
		catch(Exception e){
			System.out.println("exception");
		}
	}
}
class ThreadCreationWithRunnable{
public static void main(String[] args) {
		
		int n = 8;
		for(int i = 0; i < n; i++) {
			Thread object = new Thread(new ThreadDemo2());
			object.start();
		}
		
		
	}
}