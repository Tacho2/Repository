package engine.core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import engine.core.gfx.Assets;
import engine.core.input.KeyManager;
import engine.core.input.MouseManager;

public class Game implements Runnable{

	private int width, height;
	String title;
	private boolean running = false;
	
	private Graphics g;
	private Display display;
	private BufferStrategy bs;
	private Thread thread;
	
	@SuppressWarnings("unused")
	private Handler handler;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	public Game(int width, int height, String title) {
		this.width=width;
		this.height=height;
		this.title=title;
		keyManager = new KeyManager();
		mouseManager=new MouseManager();
	}
	public void init() {
		display = new Display(title, height, width);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		handler=new Handler(this);		
	}
	
	public void tick() {
		keyManager.tick();
		mouseManager.tick();
	}
	
	public void render() {
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null) 
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		//draw here
		

		
		//end drawing
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		
		int fps = 60;
		double timePerTick= 1000000000/fps;
		double delta=0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		@SuppressWarnings("unused")
		int ticks=0;
		
		while(running)
		{
			now=System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now-lastTime;
			lastTime=now;
			if(delta >=1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
				
			if(timer >= 1000000000)
			{
				//System.out.println("FPS: " +ticks);
				ticks=0;
				timer=0;
			}
		}
		stop();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public synchronized void start()
	{
		if(running)
			return;
		running=true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Game(600, 600, "!game!").start();
	}
	
	
}
