package com.example.autoscaler.spinner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpinnerController {
	
	private static final int duration = 100000;
	private double load = 0.80;
	
	@GetMapping("/spin")
	public String spin() {
		
		Thread thread = new Thread(new RunIt());
		thread.start();
		
		return "spun";
	}
	
	public class RunIt implements Runnable {
		public void run() {
			System.out.println("running");
			long startTime = System.currentTimeMillis();
            try {
                // Loop for the given duration
                while (System.currentTimeMillis() - startTime < duration) {
                    // Every 100ms, sleep for the percentage of unladen time
                    if (System.currentTimeMillis() % 100 == 0) {
                        Thread.sleep((long) Math.floor((1 - load) * 100));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			System.out.println("done running");
		}
	}

}
