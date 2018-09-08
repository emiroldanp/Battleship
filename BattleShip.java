//Proyecto final 
import java.util.Scanner;
import java.util.Random;
class BattleShip{


	//This are the values of the size of matrix 
	public static final int ROW=10;
	public static final int COL=10;
	//This matrix are the board of the game
	public static String [][] BOARD_PLAYER= new String [ROW][COL];
	public static String [][] BOARD_COMPUTER= new String [ROW][COL];
	//This is the countdown of the ships 
	public static int CONTINUE_PLAYER=17;
	public static int CONTINUE_COMPUTER=17;
	//THIS WILL HELP TO GENERATE THE SHIPS LOCATION 
	public static Random random= new Random();
	public static Scanner in= new Scanner(System.in);

	public static void main(String []args){

		System.out.println("This program is a game of BattleShip");
		System.out.println("You will be playing against a computer");
		System.out.println("If you hit a ship it will be mark with an 'X' and if you miss it will be mark will an '='");
		
		BOARD_COMPUTER=createShipsComputer();
		BOARD_PLAYER=createShipsPlayer();
		
		printBoardTest();
		System.out.println("Start Shooting");
		do{
		shoot();
		shootComputer();
		printBoard();
		}while(CONTINUE_PLAYER>0 && CONTINUE_COMPUTER>0);
		
		if (CONTINUE_PLAYER==0){
			System.out.println("You won");
		}
		else if(CONTINUE_COMPUTER==0){
			System.out.println("Computer won");
		}
	
	}

	public static String [][] createShipsComputer(){
	//THIS METHOD PLACES THE SHIP IN THE BOARD, THIS IS A RANDOM THING THAT THE COMPUTER THOSE FOR IT'S BOARD 
		
		String [][] board= new String [ROW][COL];
		int ship=0;
		while (ship<5){
	        	int size = 0;
	        	switch(ship){
	        	case 0:
	        	size=2;
	        	break;
	        	case 1:
	        	size=3;
	        	break;
	        	case 2:
	        	size=3;
	        	break;
	        	case 3:
	        	size=4;
	        	break;
	        	case 4:
	        	size=5;
	        	break;
	       		}
		        int i= random.nextInt(ROW);
		        int j= random.nextInt(COL);;
		        int orientation= random.nextInt(2);
		        int mediadorDeTamaño=0;
		        int mediadorDeEspacio=size;
		        for(int h=i;h<ROW;h++){
		        	for(int g=j;g<COL;g++){
		        		if (orientation==1 && board[h][g]==null && j<COL-size && size!=0){
		        			
		        			mediadorDeTamaño=2;
		        			size--;
		        		}
		        		else if (orientation==0 && board[g][h]==null && j<COL-size && size!=0){
		        			
		        			mediadorDeTamaño=1;	
		        			size--;
		        		}
		        		else if (size==0){
		        			h=ROW;
		        			g=COL;
		        			
		        		}
		        		else {
		        				
		        			h=ROW;
		        			g=COL;
		        			mediadorDeTamaño=0;
		        			size=mediadorDeEspacio;
		        		}
		        	}
		        }
		        if (mediadorDeTamaño==2){
		        	for(int h=i;h<ROW;h++){
			        	for(int g=j;g<COL;g++){
			        		if (mediadorDeEspacio!=0){
			        			board[h][g]="*";
			        			mediadorDeEspacio--;
			        		}
			        		else{
			        			h=ROW;
			        			g=COL;
			        		}					        		
			        	}
			        }
			        ship++;	
		        }
		        else if (mediadorDeTamaño==1){
		        	for(int h=i;h<ROW;h++){
			        	for(int g=j;g<COL;g++){
			        			if (mediadorDeEspacio!=0){
			        			board[g][h]="*";
			        			mediadorDeEspacio--;
			        		}
			        		else{
			        			h=ROW;
			        			g=COL;
			        		}		
			        	}
			        }
			        ship++;	

		        } 
		        else{

		        }	
	        
			}
		
		
		return board;

	}
	public static String [][] createShipsPlayer(){
		String [][] board= new String [ROW][COL];
		int ship=0;
		int ship2=1;
		int ship3=2;
		int ship4=1;
		int ship5=1;

		while (ship<5){
			System.out.println("---------------------------------");
	        System.out.println("Write the size of the ship (You have 1 ship of 5, 1 ship of 4, 2 ships of 3 and 1 ship of 2)");
	        int size = in.nextInt();
	        if(size>1 &&size<6){
		        System.out.println("Write the coordinates of the ship");
				System.out.print("The Row is: ");
		        int i= in.nextInt()-1;
		        System.out.print("The Col is: ");
		        int j= in.nextInt()-1;;
		        System.out.println("Write the orientation of the ship H=1 or V=0");
		        int orientation=in.nextInt();
		        int mediadorDeTamaño=0;
		        int mediadorDeEspacio=size;
		        for(int h=i;h<ROW;h++){
		        	for(int g=j;g<COL;g++){
		        		if (orientation==1 && board[h][g]==null && j<COL-size && size!=0){
		        			mediadorDeTamaño=2;
		        			size--;
		        		}
		        		else if (orientation==0 && board[g][h]==null && i<COL-size && size!=0){
		        			mediadorDeTamaño=1;	
		        			size--;
		        		}
		        		else if (size==0){
		        			h=ROW;
		        			g=COL;
		        			
		        		}
		        		else {
		        			h=ROW;
		        			g=COL;
		        			mediadorDeTamaño=0;
		        			size=mediadorDeEspacio;
		        		}
		        	}
		        }
		        if (mediadorDeTamaño==2){
		        	for(int h=i;h<ROW;h++){
			        	for(int g=j;g<COL;g++){
			        		if (mediadorDeEspacio>0){
			        			board[h][g]="*";
			        			mediadorDeEspacio--;
			        		}
			        		else{
			        			h=ROW;
			        			g=COL;
			        		}					        		
			        	}
			        }
			        ship++;	
		        }
		        else if (mediadorDeTamaño==1){
		        	for(int h=i;h<ROW;h++){
			        	for(int g=j;g<COL;g++){
			        			if (mediadorDeEspacio>0){
			        			board[g][h]="*";
			        			mediadorDeEspacio--;
			        		}
			        		else{
			        			h=ROW;
			        			g=COL;
			        		}		
			        	}
			        }
			        ship++;	

		        } 
		        else{
		        	System.out.println("ERROR PLEASE TRY AGAIN");
		        	System.out.println("POSSIBLE MISTAKE: COORDINATE ALREADY USED");
		        	System.out.println("SIZE OF THE SHIP NOT WHAT EXPECTED");
		        	

		        }
		     
		     }
		     else{
		     	System.out.println("Size is not acceptable");
		     	System.out.println("PLEASE TRY AGAIN");
		     }  
	    	
	        
		}

		return board;
	}
	
	
	public static void shoot(){
        int i;
        int j;
        //THIS LOOP IS USED TO CHECK IF THE VALUES ADDED BY THE PLAYER ARE IN THE RANGE OF THE MATRIX
        do{
	        System.out.print("The Row is: ");
	        i= in.nextInt()-1;
	        System.out.print("The Col is: ");
	        j= in.nextInt()-1;
	        if (j>=COL|| i>=ROW){
	        	System.out.println("Invalid value, you wrote a value that doesn't exist in the board");
	        }
    	}while(j>=COL || i >=ROW);
    	//THIS VARIABLE IS USED TO CHECK IF THE PLAYER ALREADY HIT THAT COORDINATE 
    	checkCoordinates(i,j);
 
    }
    

    public static  int checkCoordinates(int i, int j){
    	int hit=0;
    	//THIS LOOP IS USED TO MARK AND "X" IF HIT OR "=" IF NOT HIT, ALSO TO SEE IF THAT COORDINATES WAS ALREADY INTRODUCED
	        if(BOARD_COMPUTER[i][j]!=null && BOARD_COMPUTER[i][j]!="x" && BOARD_COMPUTER[i][j]!="="){
	            System.out.println("You Hit a Ship!");
	            BOARD_COMPUTER[i][j]="x";
	            CONTINUE_PLAYER--;
	            hit=0;
	        }else if(BOARD_COMPUTER[i][j]!=null){
	        	System.out.println("You already used this coordinates, choose again");
	        	hit=1;
	        	shoot();
	        }else if(BOARD_COMPUTER[i][j]==null){
	        	System.out.println("You did not hit a ship");
	        	 BOARD_COMPUTER[i][j]="=";
	        	 hit=0;
	        }
	        
    	return hit ;
    }
    public static void shootComputer(){
        int i;
        int j;
	        i= random.nextInt(ROW);  
	        j= random.nextInt(COL);
    	//THIS METHOD IS USED TO CHECK IF THE PLAYER ALREADY HIT THAT COORDINATE 
    	checkCoordinatesComputer(i,j);
 
    }
    public static  int checkCoordinatesComputer(int i, int j){
    	int hit=0;
    	//THIS LOOP IS USED TO MARK AND "X" IF HIT OR "=" IF NOT HIT, ALSO TO SEE IF THAT COORDINATES WAS ALREADY INTRODUCED
	        if(BOARD_PLAYER[i][j]!=null && BOARD_PLAYER[i][j]!="x" && BOARD_PLAYER[i][j]!="="){
	            System.out.println("The computer Hit a Ship!");
	            BOARD_PLAYER[i][j]="x";
	            CONTINUE_COMPUTER--;
	            hit=0;
	        }else if(BOARD_PLAYER[i][j]!=null){
	        	hit=1;
	        	shootComputer();
	        }else if(BOARD_PLAYER[i][j]==null){
	        	System.out.println("The computer did not hit a ship");
	        	 BOARD_PLAYER[i][j]="=";
	        	 hit=0;
	        }
	        
    	return hit;
    }
	public static void printBoardTest(){
		System.out.println("This is your board");
		for(int i=0; i<BOARD_PLAYER.length;i++){
			System.out.println();
			for(int j=0; j<BOARD_PLAYER[0].length;j++){
				if(BOARD_PLAYER[i][j]==null){
					System.out.print("0");
					System.out.print("   ");
				}
				else{
				System.out.print(BOARD_PLAYER[i][j]);
				System.out.print("   ");
				}
			}
		
		}
		System.out.println("");
		System.out.println("");
	
	}
	
	public static void printBoard(){
		System.out.println("");
		System.out.println("PLAYER'S BOARD");
		System.out.println("---------------------------------------------");
		for(int i=0; i<BOARD_PLAYER.length;i++){
			System.out.println();
			for(int j=0; j<BOARD_PLAYER[0].length;j++){
				if(BOARD_PLAYER[i][j]==null|| BOARD_PLAYER[i][j]!="="&&BOARD_PLAYER[i][j]!="x"){
					System.out.print("0");
					System.out.print("   ");
				}
				else if (BOARD_PLAYER[i][j]=="=" || BOARD_PLAYER[i][j]=="x"){
				System.out.print(BOARD_PLAYER[i][j]);
				System.out.print("   ");
				}
			}
		
		}
		System.out.println("");
		System.out.println("");
		System.out.println("COMPUTER'S BOARD");
		System.out.println("---------------------------------------------");
		for(int i=0; i<BOARD_COMPUTER.length;i++){
			System.out.println();
			for(int j=0; j<BOARD_COMPUTER[0].length;j++){
				if(BOARD_COMPUTER[i][j]==null|| BOARD_COMPUTER[i][j]!="="&&BOARD_COMPUTER[i][j]!="x"){
					System.out.print("0");
					System.out.print("   ");
				}
				else if (BOARD_COMPUTER[i][j]=="=" || BOARD_COMPUTER[i][j]=="x"){
				System.out.print(BOARD_COMPUTER[i][j]);
				System.out.print("   ");
				}
			}
		
		}
		System.out.println("");
		System.out.println("");
	
	}
}