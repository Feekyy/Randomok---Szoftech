package Menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.util.Imaging;

public class MenuScreen extends GameScreen implements IUpdateable
{
	private static final BufferedImage BG = Imaging.scale(Resources.images().get("menubg.png"), Game.window().getWidth(), Game.window().getHeight());
	
	public Menu mainMenu;
	
	public MenuScreen() 
	{
		super("MENU");
	}
	
	@Override
	public void prepare()
	{
		super.prepare();
		
	    /*this.mainMenu.getCellComponents().forEach(comp -> {
	      comp.setTextAntialiasing(true);
	      comp.getAppearance().setForeColor(Color.GRAY);
	      comp.getAppearanceHovered().setForeColor(Color.BLACK);
	      comp.getAppearanceDisabled().setForeColor(Color.BLACK);
	      comp.setForwardMouseEvents(false);
	    });*/
	}
	
	@Override
	public void render(Graphics2D g)
	{
		ImageRenderer.render(g, BG, 0, 0);
		
		super.render(g);
	}
	
	@Override
	protected void initializeComponents()
	{
		super.initializeComponents();
		Input.mouse();
		
	    final double centerX = Game.window().getResolution().getWidth() / 2.0;
	    final double centerY = Game.window().getResolution().getHeight() * 1 / 2;
	    final double buttonWidth = 450;
		
	    this.mainMenu = new Menu(centerX - buttonWidth / 2, centerY * 1.3, buttonWidth, centerY / 2, "Singleplayer", "Multiplayer", "Options", "Exit");
	    
	    this.getComponents().add(this.mainMenu);
	}
	
	@Override
	public void update() {}
}
