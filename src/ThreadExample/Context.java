package ThreadExample;


// Arayüz üzerinden Belirli bir strategyi çalıştırmak için 
public class Context {
    
    private Strategy strategy;
    
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    
    public void executeStrategy(int array[]){
        strategy.sort(array);
    }
    
}
