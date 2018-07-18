package orm.observer;




public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        BaBaObserver baBaObserver = new BaBaObserver();
        MamaObserver mamaObserver = new MamaObserver();
        subject.addObserver(baBaObserver);
        subject.addObserver(mamaObserver);
        subject.doSomething();
    }


}
