package Threads;

import java.util.Random;

public class ThreadWaitNotify {

	public static void main(String[] args) {

		Message message = new Message();
		new Thread(new MessageWriter(message)).start();
		new Thread(new MessageReader(message)).start();

	}

}

class Message {
	private String message;
	private boolean empty = true;

	public synchronized String getMessage() {
		while (empty) {
			System.out.println("reader1");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = true;
		notifyAll();
		System.out.println("reader2");
		return message;
	}

	public synchronized void setMessage(String message) {
		while (!empty) {
			System.out.println("writer1");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = false;

		notifyAll();
		System.out.println("writer2");
		this.message = message;
	}

}

class MessageWriter implements Runnable {

	private Message message;

	MessageWriter(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String messages[] = { "message-1", "message-2", "message-3", "message-4" };

		Random random = new Random();

		for (int i = 0; i < messages.length; i++) {
			message.setMessage(messages[i]);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {

			}
		}
		message.setMessage("Finished");

	}

}

class MessageReader implements Runnable {

	private Message message;

	MessageReader(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		for (String newMessage = message.getMessage(); !newMessage.equals("Finished"); newMessage = message
				.getMessage()) {
			System.out.println("Received message:" + newMessage);
		}
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(2000));
		} catch (InterruptedException e) {

		}

	}

}
