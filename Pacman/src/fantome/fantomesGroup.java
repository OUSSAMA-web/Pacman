package fantome;

import java.util.ArrayList;

import game.Game;
import utils.Coordinate;
public class fantomesGroup {

	private ArrayList<Fantome> fantomes = new ArrayList<Fantome>();
	private Game game;
 	private boolean vulnerable;
    private boolean vulnerableFalse;
    
    // constructeur qui remplie le tableaux des fantomes 
	public fantomesGroup(Coordinate c,Game game)
	{
 		for (int i = 0; i <4; i++) {
			fantomes.add(new FantomeClassique(this.coordinateStart(c).get(i), game,i));
		}
		this.game = game;
	}
	// tableaux  des coordonnees initiale 
	public ArrayList<Coordinate> coordinateStart(Coordinate c)
	{
		ArrayList<Coordinate> coordinateStart=new ArrayList<Coordinate>();
		coordinateStart.add(c);
		coordinateStart.add(new Coordinate(c.getX(),c.getY()+1));
		coordinateStart.add(new Coordinate(c.getX()+1,c.getY()));
		coordinateStart.add(new Coordinate(c.getX()+1,c.getY()+1));
		return coordinateStart;
		
	}
	// cette qui gère les états des fantome 
	public void vulnerable()
	{
		if(this.isVulnerable())
			{
			FantomeEtat("vulnerable");
			this.setVulnerableFalse(true);
			this.setVulnerable(false);
			}else if(game.getPacman().getTimer()==0 && !isVulnerable() && this.isVulnerableFalse()){
				FantomeEtat("normal");
				setVulnerableFalse(false);
			}
	}
	
	// cette methods prends comme paramètre l'etat du fantome et retourne les objets exactes 
	public void FantomeEtat(String etat)
	{
		ArrayList<Fantome> fantomes1= new ArrayList<>();
		for (int i = 0; i < 4; i++) {
		Coordinate fantomeCoordinate= this.fantomes.get(i).getCoordinate();
		if(etat.equals("normal"))
		{
			  fantomes1.add(i,new FantomeClassique(fantomeCoordinate, game,i));
		}else if(etat.equals("vulnerable"))
            fantomes1.add(i,new FantomeVulnérable(fantomeCoordinate, game,0));
		}
		fantomes.clear();
		fantomes= fantomes1;	
	}
	
	public void move()
	{
		vulnerable();
		center();
		for (int i = 0; i < 4; i++) {
			this.fantomes.get(i).move();
			//System.out.println(this.fantomes.get(i).getCoordinate().getX()+"-->"+this.fantomes.get(i).getCoordinate().getY());
		}
	}
	// cette methode rends les fantome au centre si ils sont vulnérable et se touché par le pacman
	public void center()
	{
		for (int i = 0; i < 4; i++) {
		if(this.fantomes.get(i).isCenter())
		{
			this.fantomes.get(i).setCoordinate(new Coordinate(game.getcell().length/2,game.getcell()[0].length/2));
			this.fantomes.get(i).setCenter(false);;
		}
		}
	}
	
	public ArrayList<Fantome> getFantomes() {
		return fantomes;
	}
	public void setFantomes(ArrayList<Fantome> fantomes) {
		this.fantomes = fantomes;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public boolean isVulnerable() {
		return vulnerable;
	}
	public void setVulnerable(boolean vulnerable) {
		this.vulnerable = vulnerable;
	}
	public boolean isVulnerableFalse() {
		return vulnerableFalse;
	}
	public void setVulnerableFalse(boolean vulnerableFalse) {
		this.vulnerableFalse = vulnerableFalse;
	}
	
	
}
