package GameFiles;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {
	
	Image stone = new Image("Stone.png");
	Image dirt = new Image("Dirt.png");
	Image grass = new Image("Grass.png");
	Image playerLeft = new Image("PlayerLeft.png");
	Image playerRight = new Image("PlayerRight.png");
	Image Empty = new Image("Empty.png");
	Image Table = new Image("table.png");
	Image Sand = new Image("Sand.png");
	Image currentBlock = new Image("table.png");
	public Image[] Player = {playerRight};
	public ImageView[] Blocks = new ImageView[200];
	public HBox[] Block = new HBox[200];
	public Bounds[] bound = new Bounds[200];
	public final int Stonelevels = 5;
	public final int DirtLevels = 2;
	public final int GrassLevels = 1;
	public int levels = Stonelevels + DirtLevels + GrassLevels;
	public int airLevels = 13 - levels;
	public Group root = new Group();
	public Scene mainMenu = new Scene(root);
	public Canvas mainCanvas = new Canvas(768,768);
	public GraphicsContext gc = mainCanvas.getGraphicsContext2D();
	public ImageView player = new ImageView();
	public HBox box = new HBox();
	public int blocksWide = (int) (mainCanvas.getWidth() / 64);
	public int X = 0;
	public int Y = 192;
	public int t = 1;
	
	
	public void start(Stage Stage) {
		Stage.setTitle("Minecraft");
		Stage.setScene(mainMenu);
		root.getChildren().add(mainCanvas);
		box.getChildren().add(player);
		root.getChildren().add(box);
		spawnStone();
		spawnDirt();
		spawnGrass();
		spawnAir();
		movement();
		destroy();
		pickBlock();
		Stage.show();
		
		
		
	}
	public void pickBlock(){
		mainMenu.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->{
			if(key.getCode() == KeyCode.DIGIT1){
				currentBlock = Table;
				Blocks[157].setImage(Table);
			}
			if(key.getCode() == KeyCode.DIGIT2){
				currentBlock = grass;
				Blocks[157].setImage(grass);
			}
			if(key.getCode() == KeyCode.DIGIT3){
				currentBlock = stone;
				Blocks[157].setImage(stone);
			}
			if(key.getCode() == KeyCode.DIGIT4){
				currentBlock = dirt;
				Blocks[157].setImage(dirt);
			}
			if(key.getCode() == KeyCode.DIGIT5){
				currentBlock = Sand;
				Blocks[157].setImage(Sand);
			}
		});
	}
	public void destroy(){
		mainMenu.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->{
			if(key.getCode() == KeyCode.R){
				int l = 7;
				int p = 0;
				int t;
				if((X >= -64) && (X <= 0)){
					p = 1;
				}
				else if((X >= 1) && (X <= 64)){
					p = 2;
				}
				else if((X >= 65) && (X <= 128)){
					p = 3;
				}
				else if((X >= 129) && (X <= 192)){
					p = 4;
				}
				else if((X >= 193) && (X <= 256)){
					p = 5;
				}
				else if((X >= 257) && (X <= 320)){
					p = 6;
				}
				else if((X >= 321) && (X <= 384)){
					p = 7;
				}
				else if((X >= 385) && (X <= 448)){
					p = 8;
				}
				else if((X >= 449) && (X <= 512)){
					p = 9;
				}
				else if((X >= 513) && (X <= 576)){
					p = 10;
				}
				else if((X >= 577) && (X <= 640)){
					p = 11;
				}
				else if((X >= 641) && (X <= 704)){
					p = 12;
				}
				
				if((Y >= 128) && (Y <= 192)){
					l = 7;
				}
				else if((Y >= 64) && (Y <= 127)){
					l = 8;
				}
				else if((Y >= 0) && (Y <= 63)){
					l = 9;
				}
				else if((Y >= 193) && (Y <= 256)){
					l = 6;
				}
				else if((Y >= 257) && (Y <= 320)){
					l = 5;
				}
				else if((Y >= 321) && (Y <= 384)){
					l = 4;
				}
				else if((Y >= 385) && (Y <= 448)){
					l = 3;
				}
				else if((Y >= 449) && (Y <= 512)){
					l = 2;
				}
				else if((Y >= 513) && (Y <= 576)){
					l = 1;
				}
				else if((Y >= 577) && (Y <= 640)){
					l = 0;
				}
				t = (l * 12) + (p + 1);
				Blocks[t].setImage(Empty);
			}
			if(key.getCode() == KeyCode.C){
				int l = 7;
				int p = 0;
				int t;
				if((X >= -64) && (X <= 0)){
					p = 1;
				}
				else if((X >= 1) && (X <= 64)){
					p = 2;
				}
				else if((X >= 65) && (X <= 128)){
					p = 3;
				}
				else if((X >= 129) && (X <= 192)){
					p = 4;
				}
				else if((X >= 193) && (X <= 256)){
					p = 5;
				}
				else if((X >= 257) && (X <= 320)){
					p = 6;
				}
				else if((X >= 321) && (X <= 384)){
					p = 7;
				}
				else if((X >= 385) && (X <= 448)){
					p = 8;
				}
				else if((X >= 449) && (X <= 512)){
					p = 9;
				}
				else if((X >= 513) && (X <= 576)){
					p = 10;
				}
				else if((X >= 577) && (X <= 640)){
					p = 11;
				}
				else if((X >= 641) && (X <= 704)){
					p = 12;
				}
				
				if((Y >= 128) && (Y <= 192)){
					l = 7;
				}
				else if((Y >= 64) && (Y <= 127)){
					l = 8;
				}
				else if((Y >= 0) && (Y <= 63)){
					l = 9;
				}
				else if((Y >= 193) && (Y <= 256)){
					l = 6;
				}
				else if((Y >= 257) && (Y <= 320)){
					l = 5;
				}
				else if((Y >= 321) && (Y <= 384)){
					l = 4;
				}
				else if((Y >= 385) && (Y <= 448)){
					l = 3;
				}
				else if((Y >= 449) && (Y <= 512)){
					l = 2;
				}
				else if((Y >= 513) && (Y <= 576)){
					l = 1;
				}
				else if((Y >= 577) && (Y <= 640)){
					l = 0;
				}
				t = (l * 12) + (p + 1);
				Blocks[t].setImage(currentBlock);
			}
		});
	}
	
	public void movement(){
		mainMenu.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.D){
				if(X <= 720){
				X = X + 30;
				player.setImage(playerRight);
				player.setTranslateY(Y);
				player.setTranslateX(X);
				player.translateXProperty();
				player.translateXProperty();
				}
			}
			if(key.getCode() == KeyCode.A){
				if(X >= -10){
				X = X - 30;
				player.setImage(playerLeft);
				player.setTranslateY(Y);
				player.setTranslateX(X);
				player.translateXProperty();
				player.translateYProperty();
				}
			}
			if(key.getCode() == KeyCode.W){
				if(Y >= 12){
					//System.out.println(Y);
					player.setImage(playerRight);
					Y = Y - 30;
					player.setTranslateY(Y);
					player.setTranslateX(X);
					player.translateXProperty();
					player.translateYProperty();
				}
			}
			if(key.getCode() == KeyCode.S){
				if(Y <= 632){
					//System.out.println(Y);
					player.setImage(playerRight);
					Y = Y + 30;
					player.setTranslateY(Y);
					player.setTranslateX(X);
					player.translateXProperty();
					player.translateYProperty();
				}
			}
			
		});
		
	}
	
	public void spawnAir(){
		for(int l = levels + 1; l <= levels + airLevels; l++){
			for(int i = 1; i <= blocksWide; i++){
				double x = (i * 64) - 64;
				double y = (mainCanvas.getHeight() + 64) - (l * 64);
				t++;
				//System.out.println(t);
				Blocks[t] = new ImageView(Empty);
				Blocks[t].setTranslateY(y);
				Blocks[t].setTranslateX(x);
				Blocks[t].translateXProperty();
				Blocks[t].translateYProperty();
				
				Block[t] = new HBox();
				root.getChildren().add(Block[t]);
				Block[t].getChildren().add(Blocks[t]);
			}
		}
	}
	
	public void spawnGrass(){
		for(int l = Stonelevels + DirtLevels + 1; l <= GrassLevels + DirtLevels + Stonelevels; l++){
			for(int i = 1; i <= blocksWide; i++){
				//System.out.println(l);
				//System.out.println(i);
				double x = (i * 64) - 64;
				double y = (mainCanvas.getHeight() + 64) - (l * 64);
				t++;
				System.out.println(t);
				Blocks[t] = new ImageView(grass);
				Blocks[t].setTranslateY(y);
				Blocks[t].setTranslateX(x);
				Blocks[t].translateXProperty();
				Blocks[t].translateYProperty();
				//bound[t] = new Bounds(1.0,1.0,0.0,64.0,64.0,0.0);
				Block[t] = new HBox();
				root.getChildren().add(Block[t]);
				Block[t].getChildren().add(Blocks[t]);
			}
		}
	}
	
	public void spawnDirt(){
		for(int l = Stonelevels + 1; l <= DirtLevels + Stonelevels; l++){
			for(int i = 1; i <= blocksWide; i++){
				int x = (i * 64) - 64;
				double y = (mainCanvas.getHeight() + 64) - (l* 64);
				t++;
				//System.out.println(t);
				Blocks[t] = new ImageView(dirt);
				Blocks[t].setTranslateY(y);
				Blocks[t].setTranslateX(x);
				Blocks[t].translateXProperty();
				Blocks[t].translateYProperty();
				Block[t] = new HBox();
				root.getChildren().add(Block[t]);
				Block[t].getChildren().add(Blocks[t]);
				
			}
		}
		
	}
	public void spawnStone(){
		for(int l = 1; l <= Stonelevels; l++){
			for(int i = 1; i <= blocksWide; i++){
				int x = (i * 64) - 64;
				double y = (mainCanvas.getHeight() + 64) - (l * 64);
				t++;
				Blocks[t] = new ImageView(stone);
				Blocks[t].setTranslateY(y);
				Blocks[t].setTranslateX(x);
				Blocks[t].translateXProperty();
				Blocks[t].translateYProperty();
				Block[t] = new HBox();
				root.getChildren().add(Block[t]);
				Block[t].getChildren().add(Blocks[t]);
			}
		}
	}

}
