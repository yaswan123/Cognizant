interface Playable {
    void play();
}
class Guiter implements Playable 
{
    public void play() {
        System.out.println("Playing the guiter");
    }
}
class Piano implements Playable 
{
    public void play() {
        System.out.println("Playing the piano");
    }
}

public class Interface {
    public static void main(String[] args) {
        Playable guiter = new Guiter();
        Playable piano = new Piano();
        guiter.play();
        piano.play();
    }
}