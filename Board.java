public class Board
{
    private Piece[][] table=new Piece[8][8];
    public Board(){
        
        for(int i=0;i<8;i++){
            table[1][i]=Pawn.create("W",i);
            table[6][i]=Pawn.create("B",i);
            for(int j=2;j<6;j++){
                table[j][i]=new Piece();
            }
        }
        table[0][0]=Rook.create("W",0);
        table[0][7]=Rook.create("W",7);
        table[7][0]=Rook.create("B",0);
        table[7][7]=Rook.create("B",7);
        table[0][1]=Knight.create("W",1);
        table[0][6]=Knight.create("W",6);
        table[7][1]=Knight.create("B",1);
        table[7][6]=Knight.create("B",6);
        table[0][2]=Bishop.create("W",2);
        table[0][5]=Bishop.create("W",5);
        table[7][2]=Bishop.create("B",2);
        table[7][5]=Bishop.create("B",5);
        table[0][3]=Queen.create("W");
        table[7][3]=Queen.create("B");
        table[0][4]=Queen.create("W");
        table[7][4]=Queen.create("B");
    }
    public void printOut(){
        for(int i=0;i<8;i++){
            System.out.print((8-i)+"   ");
            for(int j=0;j<8;j++){
                System.out.print(table[7-i][j]);
            }
            System.out.println();
            System.out.println();
        }
        System.out.print("    ");
        for(int i=65;i<73;i++){
            System.out.print((char)i);
            System.out.print("      ");
        }
    }
    public void move(String str1,String str2,String color){
        char[] ip=str1.toCharArray();
        char[] fp=str2.toCharArray();
        int x1=((int)ip[0]-97);
        int y1=((int)ip[1]-49);
        int x2=((int)fp[0]-97);
        int y2=((int)fp[1]-49);
        if(check(x1,x2,y1,y2)){
            throw new Error("illigal moving"); 
        }
        if(table[y2][x2].getColor().equals(color)){
            throw new Error("can't land on your chess");
        }
        table[y1][x1].setPosition(x2,y2);
        table[y2][x2]=table[y1][x1];
        table[y1][x1]=new Piece();
    }
    private boolean check(int x1,int x2,int y1,int y2){
        if((Math.abs(x1-x2)==2 && Math.abs(y1-y2)==1)||(Math.abs(x1-x2)==1 && Math.abs(y1-y2)==2)){
            return false;
        }
        else{
            while(true){
                if(Math.abs(x1-x2)<=1 || Math.abs(y1-y2)<=1){
                    return false;
                }
                if(x1<x2-1){
                    x1++;
                }
                else if(x1>x2+1){
                    x1--;
                }
                if(y1<y2-1){
                    y1++;
                }
                else if(y1>y2+1){
                    y1--;
                }
                if(!(table[y1][x1].getColor().equals("none"))){
                    return true;
                }
            }
        }
    }
}