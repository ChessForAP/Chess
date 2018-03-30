//upload by all of as--Kevin Jiang--Violet Yu---Zoe Du--Yolanda Su--Carol Li--Kevin Jiang--Yolanda Su
public class Board
{
    private static Piece[][] table=new Piece[8][8];
    private static int order=1;
    private static boolean evolve=false;
    private static int x;
    private static int x1=-1;
    private static int y;
    private static int y1=-1;
    private King wk=King.create("W",4,0);
    private King bk=King.create("B",4,7);
    public Board(){
        
        for(int i=0;i<8;i++){
            table[1][i]=Pawn.create("W",i,1);
            table[6][i]=Pawn.create("B",i,6);
            
        }
        table[0][0]=Rook.create("W",0,0);
        table[0][7]=Rook.create("W",7,0);
        table[7][0]=Rook.create("B",0,7);
        table[7][7]=Rook.create("B",7,7);
        table[0][1]=Knight.create("W",1,0);
        table[0][6]=Knight.create("W",6,0);
        table[7][1]=Knight.create("B",1,7);
        table[7][6]=Knight.create("B",6,7);
        table[0][2]=Bishop.create("W",2,0);
        table[0][5]=Bishop.create("W",5,0);
        table[7][2]=Bishop.create("B",2,7);
        table[7][5]=Bishop.create("B",5,7);
        table[0][3]=Queen.create("W",3,0);
        table[7][3]=Queen.create("B",3,7);
        table[0][4]=wk;
        table[7][4]=bk;

    }
    public Piece[][] getBoard(){
        return table;
    }
    public static void move(String str1,String str2) throws Exception{
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        char[] ip=str1.toCharArray();
        char[] fp=str2.toCharArray();
        int x1=((int)ip[0]-97);
        int y1=((int)ip[1]-49);
        int x2=((int)fp[0]-97);
        int y2=((int)fp[1]-49);
        if(order==1) 
        {
            if(table[y1][x1].getColor().equals("B")) //check don't have the same color
            {
                throw new Exception();
            }
        }
        else
        {
            if(table[y1][x1].getColor().equals("W")) //check don't have the same color
            {
                throw new Exception();
            }
        }
        if(check(x1,x2,y1,y2)){
            throw new Exception();
        }
        if(table[y2][x2]!=null) //find if there have a null point
        {
            if((table[y2][x2].getColor()).equals(table[y1][x1].getColor())) //check don't have the same color
            {
                throw new Exception();
            }
            if(table[y1][x1].kill(x2,y2,table[y2][x2].getColor())==1)//check if the piece is pawn, and if it fit the role
            {
                throw new Exception();
            }
        }
        table[y1][x1].setPosition(x2,y2);
        table[y2][x2]=table[y1][x1];
        evolve=table[y2][x2].evolve();
        x=x2;
        y=y2;
        table[y1][x1]=null;
        order=order*-1;
    }
    public static boolean check(int x1,int x2,int y1,int y2) throws Exception{
        if((Math.abs(x1-x2)==2 && Math.abs(y1-y2)==1)||(Math.abs(x1-x2)==1 && Math.abs(y1-y2)==2))//if the piece move follow the knight,keep going
        {
            return false;  
        }
        else{
            if(Math.abs(x1-x2)<=1 || Math.abs(y1-y2)<=1){
                    if(table[y2][x2]==null && Math.abs(x1-x2)==1 && table[y1][x1].checkFrount())//check is the piece is Pawn
                    {//can't toward lean when no piece in that place
                        return true;
                    }
                    if(table[y2][x2]!=null && Math.abs(x1-x2)==0 && table[y1][x1].checkFrount())//check is the piece is Pawn
                    {//can't move straight when have piece in that place
                        return true;
                    }
                    return false;
                }
            while(true){
                
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
                }//check each place between the place the piece move to to make sure no pice in it
                if(table[y1][x1]!=null){
                    return true;
                }
                if((x1==x2 || x1==x2-1 || x1==x2+1) && (y1==y2 || y1==y2-1 || y1==y2+1))
                {
                    return false;
                }
            }
        }
    }
    public void evolve(String type) throws Exception{
        type=type.toLowerCase();
        table[y][x].die();
        String color;
        if(order==1){
            color="B";
        }
        else{
            color="W"; 
        }
        if(type.substring(0,1).equals("r")){
            table[y][x]=Rook.create(color,x,y);
        }
        else if(type.substring(0,1).equals("q")){
            table[y][x]=Queen.create(color,x,y);
        }
        else if(type.substring(0,2).equals("kn")){
            table[y][x]=Knight.create(color,x,y);
        }
        else if(type.substring(0,1).equals("b")){
            table[y][x]=Bishop.create(color,x,y);
        }
        else{
            throw new Exception();
        }
    }
    public boolean getEvolve(){
        return this.evolve;
    }
    private boolean checked(String color)throws Exception{
        boolean hor;
        boolean ver;
        boolean dia;
        boolean sun;
        if(color.equals("W")){
            hor=horizontal(wk.getX(),wk.getY(),"W");
            ver=vertical(wk.getX(),wk.getY(),"W");
            dia=diagonal(wk.getX(),wk.getY(),"W");
            sun=sun(wk.getX(),wk.getY(),"W");
        }
        else{
            hor=horizontal(bk.getX(),bk.getY(),"B");
            ver=vertical(bk.getX(),bk.getY(),"B");
            dia=diagonal(bk.getX(),bk.getY(),"B");
            sun=sun(bk.getX(),bk.getY(),"B");
        }
        return hor||ver||dia||sun;
    }
    public boolean checked(int x,int y,String color)throws Exception{
        return horizontal(x,y,color)||vertical(x,y,color)||diagonal(x,y,color)||sun(x,y,color);
    }
    public boolean vertical(int x,int y,String s)throws Exception{
        boolean up= false;
        boolean down= false;
        for(int i=y+1;i<8;i++){
            if(table[i][x].kill(x,y,s)==1){
                break;
            }
            else if(table[i][x].kill(x,y,s)==2){
                set(x,i);
                return true;
            }
        }
        for(int i=y-1;i>=0;i--){
            if(table[i][x].kill(x,y,s)==1){
                break;
            }
            else if(table[i][x].kill(x,y,s)==2){
                set(x,i);
                return true;
            }
        }
        return up||down;
    }
    public boolean horizontal(int x,int y,String s)throws Exception{
        boolean left= false;
        boolean right= false;
        for(int i=x+1;i<8;i++){
            if(table[y][i].kill(x,y,s)==1){
                break;
            }
            else if(table[y][i].kill(x,y,s)==2){
                set(i,y);
                return true;
            }
        }
        for(int i=x-1;i>=0;i--){
            if(table[y][i].kill(x,y,s)==1){
                break;
            }
            else if(table[y][i].kill(x,y,s)==2){
                set(i,y);
                return true;
            }
        }
        return left||right;
    }
    public boolean diagonal(int x,int y,String s)throws Exception{
        int i=1;
        while(x+i<8 && y+i<8){
            if(table[y+i][x+i].kill(x,y,s)==1){
                break;
            }
            else if(table[y+i][x+i].kill(x,y,s)==2){
                set(x+i,y+i);
                return true;
            }
            i++;
        }
        i=1;
        while(x+i<8 && y-i>=0){
            if(table[y-i][x+i].kill(x,y,s)==1){
                break;
            }
            else if(table[y-i][x+i].kill(x,y,s)==2){
                set(x+i,y-i);
                return true;
            }
            i++;
        }
        i=1;
        while(x-i>=0 && y-i>=0){
            if(table[y-i][x-i].kill(x,y,s)==1){
                break;
            }
            else if(table[y-i][x-i].kill(x,y,s)==2){
                set(x-i,y-i);
                return true;
            }
            i++;
        }
        i=1;
        while(x-i>=0 && y+i<8){
            if(table[y+i][x-i].kill(x,y,s)==1){
                break;
            }
            else if(table[y+i][x-i].kill(x,y,s)==2){
                set(x-i,y+i);
                return true;
            }
            i++;
        }
        return false;
    }
    public boolean sun(int x,int y,String s)throws Exception{
        if(x<=5&&y<=6){
            if(table[y+1][x+2].kill(x,y,s)==2){
                set(x+2,y+1);
                return true;
            }
        }
        if(x<=6&&y<=5){
            if(table[y+2][x+1].kill(x,y,s)==2){
                set(x+1,y+2);
                return true;
            }
        }
        if(x<=6&&y>=2){
            if(table[y-2][x+1].kill(x,y,s)==2){
                set(x+1,y-2);
                return true;
            }
        }
        if(x<=5&&y>=1){
            if(table[y-1][x+2].kill(x,y,s)==2){
                set(x+2,y-1);
                return true;
            }
        }
        if(x>=1&&y<=5){
            if(table[y+2][x-1].kill(x,y,s)==2){
                set(x-1,y+2);
                return true;
            }
        }
        if(x>=2&&y<=6){
            if(table[y+1][x-2].kill(x,y,s)==2){
                set(x-2,y+1);
                return true;
            }
        }
        if(x>=2&&y>=1){
            if(table[y-1][x-2].kill(x,y,s)==2){
                set(x-2,y-1);
                return true;
            }
        }
        if(x>=1&&y>=2){
            if(table[y-2][x-1].kill(x,y,s)==2){
                set(x-1,y-2);
                return true;
            }
        }
        return false;
    }
    public boolean checkCastling(String dir,String color)throws Exception{
        
        if(dir.equals("left")&&color.equals("W")){
            for(int i=1;i<4;i++){
                if(!(table[0][i]==null)){
                    return false;
                }
            }
            return table[0][4].castling()&&table[0][0].castling();
        }
        else if(dir.equals("left")&&color.equals("B")){
            for(int i=1;i<4;i++){
                if(!(table[7][i]==null)){
                    return false;
                }
            }
            return table[7][4].castling()&&table[7][0].castling();
        }
        else if(dir.equals("right")&&color.equals("W")){
            for(int i=5;i<7;i++){
                if(!(table[0][i]==null)){
                    return false;
                }
            }
            return table[0][4].castling()&&table[0][7].castling();
        }
        else{
            for(int i=5;i<7;i++){
                if(!(table[7][i]==null)){
                    return false;
                }
            }
            return table[7][4].castling()&&table[7][7].castling();
        }
    }
    public void castling(String dir,String color)throws Exception{
        if(checkCastling(dir,color)){
            castl(dir,color);
        }
    }
    private void castl(String dir,String color){
        int x=0;
        int x1=-2;
        int y=0;
        if(dir.equals("right")){
            x=7;
            x1=2;
        }
        if(color.equals("B")){
            y=7;
        }
        table[y][4].move(dir);
        table[y][x].move(dir);
        table[y][4+x1]=table[y][4];
        table[y][4]=null;
        table[y][4+(x1/2)]=table[y][x];
        table[y][x]=null;
    }
    private void set(int x,int y){
        if(this.x==-1){
            this.x1=x;
            this.y1=y;
        }
        else{
            this.x1=10;
            this.y1=10;
        }
    }
    private void set(){
        this.x1=-1;
        this.y1=-1;
    }
}
