package ttt;
import java.util.*;

class Tic{
	static char[][]board;
	
	public Tic(){
		board=new char[3][3];
		initBoard();
	}
	
	void initBoard() {
		
	for(int i=0;i<board.length;i++) {
		
		for(int j=0;j<board[i].length;j++) {
			board[i][j]=' ';
			
		}
	}
	}
	
	static void disBoard() {

		System.out.println("-------------");
	for(int i=0;i<board.length;i++) {
		System.out.print("| ");
		for(int j=0;j<board[i].length;j++) {
			System.out.print(board[i][j]+" | ");
			
		}
		System.out.println();
		System.out.println("-------------");
	}
	
	}
    
	static void printMark(int row,int col,char mark) {
		
		if(row>=0&&row<=2&&row>=0&&row<=2) {
			board[row][col]=mark;
		}
		else {
			System.out.println("Invalid Position");
		}
	}
	
	static boolean colWin() {
		
		for(int j=0;j<=2;j++) {
		if(board[0][j]!=' '&&board[0][j]==board[1][j]&&board[1][j]==board[2][j]) {
			return true;
		}
		
		}
		return false;
	}

	static boolean rowWin() {
		for(int i=0;i<=2;i++) {
			if(board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
	}

   static  boolean diaWin() {

    	if(board[0][0]!=' '&&board[0][0]==board[1][1]&&board[1][1]==board[2][2]||
    			board[0][2]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0]) {
    		return true;
    	}
    	return false; 	
    }
   
   static boolean draw() {
	   for(int i=0;i<=2;i++) {
		   for(int j=0;j<=2;j++) {
			   if(board[i][j]==' ') {
				   return false;
			   }
		   }
	   }
	   return true;
   }
}

abstract class Player{
	String name;
	char mark;
	
	abstract void makeMove();
	
     boolean isValid(int row,int col) {
		
		if(row>=0&&row<=2&&col>=0&&col<=2) {
			if(Tic.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
	
}

class Human extends Player{
	
//	String name;
//	char mark;
	
	Human(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	
     void makeMove() {
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
		do {
			System.out.println("Enter row and col");
			row=sc.nextInt();
			col=sc.nextInt();
			
		}while(!isValid(row,col));
		
		Tic.printMark(row,col,mark);
	}
	
//	boolean isValid(int row,int col) {
//		
//		if(row>=0&&row<=2&&col>=0&&col<=2) {
//			if(Tic.board[row][col]==' ') {
//				return true;
//			}
//		}
//		return false;
//	}
}


class AI extends Player{
	
//	String name;
//	char mark;
	
	AI(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	
     void makeMove() {
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
		do {
			Random r=new Random();
			row=r.nextInt(3);
			col=r.nextInt(3 );
			
		}while(!isValid(row,col));
		
		Tic.printMark(row,col,mark);
	}
	
//	boolean isValid(int row,int col) {
//		
//		if(row>=0&&row<=2&&col>=0&&col<=2) {
//			if(Tic.board[row][col]==' ') {
//				return true;
//			}
//		}
//		return false;
//	}
}


public class TicTacToe {

	public static void main(String[] args) {
		Tic t =new Tic();
		
		Human p1=new Human("Preethi",'X');
		AI p2=new AI("Star",'O');
		
		Player cp=p1;
		
	while(true) {
		System.out.println(cp.name+"'s turn ");
		cp.makeMove();
		Tic.disBoard();
		
		if(Tic.colWin()||Tic.diaWin()||Tic.rowWin()) {
			System.out.println(cp.name+"won!!!!");
			break;		
			}
		else if(Tic.draw()) {
			System.out.println("Game over and the match is draw");
		}
		else {
			if(cp==p1) {
				cp=p2;
			}
			else {
				cp=p1;
			}
		
	}
		

	}

}
}
