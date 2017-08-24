package com.ag.brain;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;


public class Main extends ApplicationAdapter {

	public class MyActor extends Actor{
		Texture texture = new Texture(Constants.TEST_SPRITE);
		public boolean started = false;

		//creates the item that is being created and adds events to it
		public MyActor(){
			setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
		}

		//physically draws the actor
		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,this.getX()+midX(),getY()+midY());
		}


	}

	public class defActor extends Actor{
		Texture t = new Texture(Constants.BOX_CORNERS);
		Sprite sprite = new Sprite(t);
		float x = 0, y = 0;
		public defActor(float posX, float posY, float width, float height){
			this.x = posX;
			this.y = posY;
			sprite.setSize(width,height);
		}

		@Override
		public void draw(Batch batch,float alpha){
			sprite.draw(batch);
		}
	}

	private Stage stage;
	private Stage topStage;
	private Stage botStage;
	
	@Override
	public void create () {
//		stage = new Stage();
		Gdx.input.setInputProcessor(topStage);

		MyActor myActor = new MyActor();

		MoveToAction moveAction = new MoveToAction();
		moveAction.setPosition(Constants.WIDTH-33, Constants.HEIGHT-65);
		moveAction.setDuration(20f);
		myActor.addAction(moveAction);

		topStage = new Stage();
		topStage.getActors().addAll(
				//left Stats box
				new defActor(0,(Constants.HEIGHT/2)+1,Constants.WIDTH/4, Constants.HEIGHT/2),
				//where the character and world are
				myActor);

		botStage = new Stage();
		botStage.getActors().addAll(
				//left choice box
				new defActor(0,0,Constants.WIDTH/2, Constants.HEIGHT/2),
				//Middle info box
				new defActor((Constants.WIDTH/2)+1,0,Constants.WIDTH/4, Constants.HEIGHT/2),
				//right options box
				new defActor(((Constants.WIDTH/2)+(Constants.WIDTH/4))+1,0,Constants.WIDTH/4, Constants.HEIGHT/2));

//		Group top = new Group();
//		top.getChildren().addAll(
//				//left Stats box
//				new defActor(0,(Constants.HEIGHT/2)+1,Constants.WIDTH/4, Constants.HEIGHT/2),
//				//where the character and world are
//				myActor);

//		Group bot = new Group();
//		bot.getChildren().addAll(
//				//left choice box
//				new defActor(0,0,Constants.WIDTH/2, Constants.HEIGHT/2),
//				//Middle info box
//				new defActor((Constants.WIDTH/2)+1,0,Constants.WIDTH/4, Constants.HEIGHT/2),
//				//right options box
//				new defActor(((Constants.WIDTH/2)+(Constants.WIDTH/4))+1,0,Constants.WIDTH/4, Constants.HEIGHT/2));


//		SplitPane first = new SplitPane(top,bot,false, SplitPane.SplitPaneStyle.Drawable);

//		stage.addActor();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		stage.act(Gdx.graphics.getDeltaTime());
//		stage.draw();
		topStage.act(Gdx.graphics.getDeltaTime());
		topStage.draw();
		botStage.draw();

	}
	
	@Override
	public void dispose () {
	}

	public static float midX(){
		return (Constants.WIDTH / 2);
	}

	public static float midY(){
		return (Constants.HEIGHT / 2);
	}


}
