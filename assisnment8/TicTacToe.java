package emailapp;
import java.util.*;
public class TicTacToe extends Thread {
	public String user;
	public String winner=null;
	static int start=0;
	 private final static Object lock = new Object();

    char symbol = ' ';
	char[][] gameBoard={
	        {' ', '|', ' ', '|', ' '},
	        {'-', '+', '-', '+', '-'},
	        {' ', '|', ' ', '|', ' '},
	        {'-', '+', '-', '+', '-'},
	        {' ', '|', ' ', '|', ' '},
	};
	static User playerPositions=new User("player");
	static User cpuPositions=new User("user");


	public TicTacToe(String user,char[][] gameBoard){
		this.user=user;
		this.gameBoard=gameBoard;
	}
	public TicTacToe(String user){
		this.user=user;
		
	}
	public TicTacToe(char[][] gameBoard){
		this.gameBoard=gameBoard;
		
	}
	
	 public TicTacToe() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
	        char[][] gameBoard1 = {
	                {' ', '|', ' ', '|', ' '},
	                {'-', '+', '-', '+', '-'},
	                {' ', '|', ' ', '|', ' '},
	                {'-', '+', '-', '+', '-'},
	                {' ', '|', ' ', '|', ' '},
	        };
	        TicTacToe t1=new TicTacToe(gameBoard1);
String w=t1.CheckWinner(gameBoard1);
	        printGameBoard(gameBoard1);
	        
	      
	        while (true) {
	            Scanner scan = new Scanner(System.in);
	            System.out.println("Enter your placement (1-9): ");
	            int playerPos = scan.nextInt();
	            // write your code here
	            

synchronized(lock){
	while(true){
		if (start==0){
			
		
	if(checkfull(gameBoard1)&&w==null){
		playerPositions.placePiece(gameBoard1,playerPos, "player");
		
		gameBoard1=playerPositions.gameBoard;
		 printGameBoard(gameBoard1);
		playerPositions.CheckWinner(playerPositions.gameBoard);
		lock.notify();
		start++;
		scan.close();
		if(playerPositions.winner=="player")
			
		{System.out.println("The player has won");
		break;}
		}
	}
		else {lock.wait();}
	            }
synchronized(lock){
	while(true){
		if(start==1){
	
		int temp=1+(int)(Math.random()*(9));
		cpuPositions.placePiece(gameBoard1,temp, "cpu");
		gameBoard1=cpuPositions.gameBoard;
		cpuPositions.CheckWinner(cpuPositions.gameBoard);
		gameBoard1=cpuPositions.gameBoard;
		 printGameBoard(gameBoard1);
		 lock.notify();
		 start--;
		if(cpuPositions.winner=="cpu")
			
		{System.out.println("The cpu has won");break;}
	


        
	        }        
		else {lock.wait();}}}


	    public static void printGameBoard(char[][] gameBoard) {
	        // write your code here
	    	for(int i=0;i<4;i++){//Ñ­»·Êä³ö
	    		for(int j=0;j<4;j++)
	    		System.out.print(gameBoard[i][j]+"\t");
	    		System.out.println();}
	    	
	    }

	    public   void placePiece(char[][] gameBoard, int pos, String user) {

	        this.user=user;
	        if (user.equals("player")) {
	            this.symbol = 'X';
	            playerPositions.add(pos);
	        } else if (user.equals("cpu")) {
	            this.symbol = 'O';
	            cpuPositions.add(pos);
	        }
	        
	        // write your code here
	 
	    }
	    
	    
	    public void add(int pos){
	    	
	    	if(pos<=3){
	    		
	    		int i=0;
	    		int j=(pos-1)*2;
	    		if(gameBoard[i][j]==' ')
	    		{gameBoard[i][j]=this.symbol;}
	    		else System.out.println("This place isn't valid");
	    	}
		
	    	if( pos>3&&pos<=6)
	    	{
	    		int i=2;
	    		int j=(pos-4)*2;
	    		if(gameBoard[i][j]==' ')
	    		{gameBoard[i][j]=this.symbol;}
	    		else System.out.println("This place isn't valid");
	    		
	    	}	
	    		
	    		
	        if(pos>6&pos<=9)
	        {
	        	int i=4;
	        	int j=(pos-7)*2;
	        	if(gameBoard[i][j]==' ')
	    		{gameBoard[i][j]=this.symbol;}
	    		else System.out.println("This place isn't valid");
	        }
	        
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public static boolean checkfull(char gameBoard[][]){
	    	for(int i=0;i<4;i++){
	    		for(int j=0;j<4;j++)
	    		{
	    			if (gameBoard[i][j]==' '){    	
	    				return true;
	    			}	    			
	    		}
	    		
	    }
			return true;}

	 public  String CheckWinner(char gameBoard[][]){
	        // write your code here
	    String winner = null;
	    	for(int i=0;i<2;i++){
	    		int a=2*i;
	    		if(gameBoard[a][0]==gameBoard[a][2]&&gameBoard[a][2]==gameBoard[a][4]){
	    			if(gameBoard[i][0]=='X')
	    			{
	    			this.winner="player";
	    		}
	    			else if (gameBoard[i][0]=='X'){
	    				
	    				this.winner="cpu";
	    				
	    			}
	    		}
	    	}
	    		for(int j=0;j<2;j++){
	    			int b=2*j;
	    			if(gameBoard[0][b]==gameBoard[2][b]&&gameBoard[2][b]==gameBoard[4][b]){
	    				if(gameBoard[0][b]=='X')
		    			{this.winner="player";}
		    			else if (gameBoard[0][b]=='0'){
		    				this.winner="cpu";
		    			}
	    			}
	    		}
	    	if(gameBoard[0][0]==gameBoard[2][2]&&gameBoard[2][2]==gameBoard[4][4]){
	    		if(gameBoard[0][0]=='X')
    			{this.winner="player";}
    			else if (gameBoard[0][0]=='0'){
    				this.winner="cpu";
    			}
	    	}
	    	
	    	if(gameBoard[4][0]==gameBoard[2][2]&&gameBoard[2][2]==gameBoard[0][4]){
	    		if(gameBoard[0][4]=='X')
    			{this.winner="player";}
    			else if (gameBoard[0][4]=='0'){
    				this.winner="cpu";
    			}
	    	}
	    	winner=this.winner;
			return winner;
	    	
	    	
	    }
	    	
	    }


	

