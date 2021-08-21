package ThreadExample;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiplyWorker extends Thread{
    
    private int[][] matrix1;
    private int[][] matrix2;
    private final int row;
    private Buffer buffer;

    public MultiplyWorker(Buffer buffer, int[][] matrix1, int[][] matrix2, int row) {
        this.buffer=buffer;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }
    
    public void run() {
        // 2 saniye sonra basliyor
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            hesaplama();
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(MultiplyWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hesaplama() throws InterruptedException{
        
        // Matrisin belirli bir yeri icin carpma islemi yapiliyor. 
        for (int i = 0; i < matrix2[0].length; i++) {
            int temp=0;
            for (int j = 0; j < matrix1[row].length; j++) {
                temp += matrix1[row][j] * matrix2[j][i];
            }
            buffer.put(temp,row,i);
            System.out.println("Value: " + temp);
        }
    }
}
