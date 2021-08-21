package ThreadExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Question1 {
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        
        int [][] matris1 = readFile("matris1.txt");
        int [][] matris2 = readFile("matris2.txt");
        // Threadleri baslatiyoruz.
        ExecutorService executorService = Executors.newCachedThreadPool();
        Buffer buffer = new Buffer(matris1.length,matris2[0].length);
        for (int i = 0; i < matris1.length; i++) {
            MultiplyWorker mw = new MultiplyWorker(buffer,matris1,matris2,i);
            executorService.execute(mw);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("-----------------------");
        buffer.print();
    }
    
    private static int [][] readFile(String textFile ) throws FileNotFoundException, IOException{
        // Metinler okunuyor ve kac satir oldugu bulunuyor
        BufferedReader br = new BufferedReader(new FileReader(textFile));
        ArrayList<Integer> matrisIntegers = new ArrayList<>();
        String line;
        int satirSayisi=0;
        while ((line = br.readLine()) != null) {
            satirSayisi++;        
            String[] txtArray = line.split(" ");
            for(int s=0;s<txtArray.length;s++){
                matrisIntegers.add(Integer.parseInt(txtArray[s]));
            }
        }
        // Metindeki bilgiler matrise yerlestiriliyor.
        int sutunSayisi=(matrisIntegers.size()/satirSayisi);
        int[][] matris = new int[satirSayisi][sutunSayisi];
        int counter=0;
        for(int x=0; x < satirSayisi; x++){
            for(int j=0; j < sutunSayisi; j++){
                matris[x][j]=matrisIntegers.get(counter);
                counter++;
            }
        }
        br.close();
        return matris;
    }
}