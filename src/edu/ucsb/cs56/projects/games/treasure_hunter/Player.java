package edu.ucsb.cs56.projects.games.treasure_hunter;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
 Created by Alex Wood (UCSB CS56, W12, 2/16/2012)
 Edited by Yusuf Alnawakhtha and Sang Min Oh
 */

/**
 A class that contains all of the <tt>Player</tt> object's information such as its location and its current sprite.
 
 @author Alex Wood
 @author Danielle Dodd and George Lieu
 @author Yusuf Alnawakhtha and Sang Min Oh
 @version for UCSB CS56, F17, 11/07/2017
 */

public class Player implements GameObject {
    // private instance variables
    private boolean movable = true;
    private int xTile;
    private int yTile;
    private int xPos;
    private int yPos;
    private ArrayList<BufferedImage> sprites;
    private int currentSprite = 0;
    
    private int startingSprite = 0;
    private int x = 0;
    private int y = 0;
    private boolean inMotion = false;
    private int frameCount = 0;    
    
    /**
     Constructs a <tt>Player</tt> object.
     
     @param xTile The current tile that the <tt>Player</tt> is on along the x-direction
     @param yTile The current tile that the <tt>Player</tt> is on along the y-direction
     @param numSprites The number of different sprites that exist for the <tt>Player</tt>
     @param currentSprite The number of the <tt>Player</tt> object's current sprite
     @param name The name of the <tt>Player</tt>
     */
    public Player(int xTile, int yTile, int numSprites, int currentSprite, int setSprite, String name) {
        try {  
            sprites = new ArrayList<BufferedImage>();
	    if(setSprite == 0) {
		for(int i = 0; i < numSprites; i++)
                sprites.add(ImageIO.read(getClass().getResource(GameGui.resourcesDir + name + "/" + name + i + ".png")));
            
		this.xTile = xTile;
		this.yTile = yTile;
		this.currentSprite = currentSprite;
		this.moveTo(xTile * 50, yTile * 50);
	    }

	    else if(setSprite == 1) {
		for(int i = 0; i < numSprites; i++)
                sprites.add(ImageIO.read(getClass().getResource(GameGui.resourcesDir + "player2" + "/" + "pokemon" + i + ".png")));
            
		this.xTile = xTile;
		this.yTile = yTile;
		this.currentSprite = currentSprite;
		this.moveTo(xTile * 50, yTile * 50);
	    }

	    else if(setSprite == 2) {
		for(int i = 0; i < numSprites; i++)
                sprites.add(ImageIO.read(getClass().getResource(GameGui.resourcesDir + "player3" + "/" + "orc" + i + ".png")));
            
		this.xTile = xTile;
		this.yTile = yTile;
		this.currentSprite = currentSprite;
		this.moveTo(xTile * 50, yTile * 50);
	    }
	    
        } catch (Exception e) {}
    }


    
    public int getStartingSprite() {
        return startingSprite;
    }
    
    public void setStartingSprite(int newStartingSprite) {
        startingSprite = newStartingSprite;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int newX) {
        x = newX;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int newY) {
        y = newY;
    }
    
    public boolean isInMotion() {
        return inMotion;
    }
    
    public void setInMotion(boolean newInMotion) {
        inMotion = newInMotion;
    }
    
    public int getFrameCount() {
        return frameCount;
    }
    
    public void setFrameCount(int newFrameCount) {
        frameCount = newFrameCount;
    }
    
    public void animate() {
        xPos += x;
        yPos += y;
        if(moving()) setSprite(startingSprite + frameCount / 10);
        if(currentSprite >= startingSprite + 4 && moving()) setSprite(startingSprite);
        frameCount++;
        if(frameCount == 50) {
            frameCount = 0;
            inMotion = false;
        }
    }
    
    public boolean moving() {
        return !(x == 0 && y == 0);
    }
    
    /**
     Sets the sprite of the <tt>Player</tt> object.
     
     @param sprite The number of the sprite that the <tt>Player</tt> should currently be
     */
    public void setSprite(int sprite) {
        currentSprite = sprite;
    }
    
    /**
     Returns the x-coordinate of the <tt>Player</tt>.
     
     @return The x-coordinate
     */
    public int getXPos() {
        return xPos;
    }
    
    /**
     Returns the x-tile number of the <tt>Player</tt>.
     
     @return The x-tile number
     */
    public int getXTile() {
        return xTile;
    }
    
    /**
     Returns the y-coordinate of the <tt>Player</tt>.
     
     @return The y-coordinate
     */
    public int getYPos() {
        return yPos;
    }
    
    /**
     Returns the y-tile number of the <tt>Player</tt>.
     
     @return The y-tile number
     */
    public int getYTile() {
        return yTile;
    }
    
    /**
     Sets the tiles that the <tt>Player</tt> should be on.
     
     @param xTile The destination x-tile number
     @param yTile The destination y-tile number
     */
    public void setTiles(int xTile,int yTile) {
        this.xTile = xTile;
        this.yTile = yTile;
    }
    
    /**
     Moves the <tt>Player</tt> to the specified coordinate location.
     
     @param xPos The destination x-coordinate
     @param yPos The destination y-coordinate
     */
    public void moveTo(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    /**
     Returns whether the <tt>Player</tt> is currently able to move.
     
     @return The <tt>Player</tt> object's ability to move
     */
    public boolean isMovable() {
        return movable;
    }
    
    /**
     Sets the <tt>Player</tt> object's current ability to move.
     
     @param movable The <tt>Player</tt> object's ability to move
     */
    public void setMovable(boolean movable) {
        this.movable = movable;
    }
    
    /**
     Returns the number of the <tt>Player</tt> object's current sprite.
     
     @return The current sprite number
     */
    public int getCurrentSprite() {
        return currentSprite;
    }
    
    /**
     Returns a <tt>BufferedImage</tt> that stores an image of the <tt>Player</tt> object's current sprite.
     
     @return The current sprite image
     */
    public BufferedImage getCurrentImage() {
        return sprites.get(currentSprite);
    }
}
