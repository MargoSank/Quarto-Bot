public class Pole {	
	public int pole [][]=new int[4][4];
	
	public Pole() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				pole[i][j]=-1;
			}
		}
		System.out.println("pole gotovo");
			
	}
	
	public void putPiece(int x,int y,int N) {
		this.pole[x][y]=N;
	}

	public  boolean strocka() {	
		boolean strocka=false;
		for (int i=0;i<4;i++) {
			if (this.hasCombination(pole[i][0], pole[i][1], pole[i][2], pole[i][3])) {
				strocka=true;
				System.out.println("Pobeda na strocke "+i);
				continue;
				}
			}
		return strocka;
	}
	
	public boolean kolonka() {
		boolean kolonka=false;
		for (int j=0;j<4;j++) {
			if (this.hasCombination(pole[0][j],pole[1][j],pole[2][j],pole[3][j])) {
				kolonka=true;
				System.out.println("Pobeda v kolonke "+j);
				continue;
				}
		}
		return kolonka;
	}
	
	public boolean diagonal() {
		boolean diagonal=false;
		if (this.hasCombination(pole[0][0], pole[1][1], pole[2][2], pole[3][3])) {
			diagonal=true;
			System.out.println("Pobeda po diagonali");
			}	
		if (this.hasCombination(pole[0][3],pole[1][2],pole[2][1],pole[3][0])) {
			diagonal=true;
			System.out.println("Pobeda po diagonali");
			}
		return diagonal;
	}
	
	public boolean test() {
		boolean strocka=false, kolonka=false, diagonal=false;
		strocka=strocka();
		kolonka=kolonka();
		diagonal=diagonal();
		
		if (strocka ==false && kolonka==false && diagonal==false) {
			return false;
		}
		return true;
	}
	
	public boolean hasCombination(int a,int b,int c,int d) {
		if(a==-1 || b==-1|| c==-1 || d==-1) {
			return false;
		}
		if (((a ^ b) | (a^c) | (a^d)) < 15) {
			return true;
		}
		return false;
	}
	
	public boolean checkPiece(int N) {
		for(int i=0; i<4;i++) {
			for(int j=0;j<4;j++) {
				if (pole[i][j]==N) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isEmpty(int x,int y) {
		return pole[x][y]==-1;			
	}
	
	public void printPole() {
		for (int i=0;i<4;i++) {
			for (int j=0; j<4;j++) {
				System.out.print(pole[i][j]+" "+this.printPiece(pole[i][j])+"\t");
			}
			System.out.println();
		}
	}

	public String printPiece(int p) {
		switch(p) {
			case 0:  return "○-a◯";
			case 1:  return "○-A◯";
			case 2:  return "○◡a◯";
			case 3:  return "○◡A◯";
			case 4:  return "□-a⬜";
			case 5:  return "□-A⬜";
			case 6:  return "□◡a⬜";
			case 7:  return "□◡A⬜";
			case 8:  return "●-a◯";
			case 9:  return "●-A◯";
			case 10:  return "●◡a◯";
			case 11:  return "●◡A◯";
			case 12:  return "■-a⬜";
			case 13:  return "■-A⬜";		
			case 14:  return "■◡a⬜";
			case 15:  return "■◡A⬜";
		}
		return "";
	}
	
	public void copy( Pole pole2 ) {
		for (int i=0;i<4;i++) {
			for (int j=0; j<4;j++) {
				this.pole[i][j]=pole2.pole[i][j];
			}
		}
	}
	
	
}
