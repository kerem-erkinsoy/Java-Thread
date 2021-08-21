package ThreadExample;

public class Buffer{
    
    private int rowNums;
    private int columnNums;
    private int [][] resultArray;
    
    public Buffer(int satirSayisi,int sutunSayisi) {
        this.rowNums=satirSayisi;
        this.columnNums=sutunSayisi;
        resultArray=new int [satirSayisi][sutunSayisi];
    }
    
    public synchronized void put(int  value,int row,int column) 
            throws InterruptedException
    {
        System.out.println("MultiplyWorker tries to write.");
        // parametre olarak gelen indekslere deger ataniyor.
        resultArray[row][column]=value;
        System.out.println("MultiplyWorker writes " + value); 
    } 
    
    public void print() {
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                System.out.print(resultArray[i][j] );
                System.out.print('\t');
            }
            System.out.println("\n");
        }
    }
}
