import java.util.ArrayList;
import java.util.List;
public class start {
	
	public static boolean stop=false;
	public static void main(String[] args) {
		Pole g = new Pole();
		g.putPiece(0, 0, 4);
		g.putPiece(0, 1, 5);
		g.putPiece(0, 3, 14);
		g.putPiece(1,1, 3);
		g.putPiece(2, 1, 2);
		g.putPiece(2, 2, 0);
//		g.putPiece(3, 0, 10);
//		g.putPiece(3, 1, 13);
//		g.putPiece(3, 3, 12);
		
		raund(g,6);
		/*for(int i=0;i<=15;i++) {
			Pole g = new Pole();
			
			g.putPiece(0, 0, 0);
			g.putPiece(0, 1, 1);
			g.putPiece(0, 2, 2);
			
			if(!g.checkPiece(i)) {
				g.putPiece(0, 3, i);
				if(!g.test()) {
					for(int j=0;j<=15;j++) {						
						if(!g.checkPiece(j)) {
							g.putPiece(1, 0, j);
							g.test();
						}
						g.printPole();
						System.out.println("===============");
					}
					
				}
			}
			g.printPole();
			System.out.println("===============");
		} */
	}
	public static int raund (Pole pole2,int n) {
		List<Integer> scoreList = new ArrayList<Integer>();
		System.out.printf("=====raund=%d========\n",n);
		for (int x=0;x<4;x++) {
			for (int y=0; y<4;y++) {
				if(pole2.pole[x][y]==-1){
					for(int det=0;det<=15;det++) {
						
						if(!pole2.checkPiece(det)) {
							System.out.printf("det=%d, x=%d, y=%d\n",det,x,y);
							Pole p2 = new Pole();
							p2.copy(pole2);
							p2.putPiece(x, y, det);
							p2.printPole();
							
							if(p2.test()==false){
								int r=raund(p2,n+1);
								scoreList.add(r);
								System.out.println("=======raund out========");
							} else {								
								return (n%2==0) ? 1 : -1;
							}
						}
					}
				}
			}
		}
		int score = -1;
		for(int i=0; i< scoreList.size(); i++) {
			score = Math.max(score, scoreList.get(i));
		}
		System.out.printf("score=%d, N=%d\n\n\n\n",score,scoreList.size());
		return score;
	}
}


