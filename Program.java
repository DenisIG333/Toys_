import java.util.List;

public class Program {
    public static void main(String[] args) {
        //инициализация списка игрушек разными методами
        ListToy toys1 = new ListToy();
        toys1.addToy(new Toy(25,"Игрушка мишка",3));
        toys1.addToyList(List.of(
                new Toy(5,"Велосипед",1),
                new Toy(10,"Паззл",2),
                new Toy(10,"Конструктор",2)
        ));
        System.out.println(toys1);
        //инициализация очереди участников
        ParticipantQueue pq = new ParticipantQueue(List.of(
                new Participant("Юлия"),
                new Participant("Иван"),
                new Participant("Света"),
                new Participant("Катерина"),
                new Participant("Женя"),
                new Participant("Пётр"),
                new Participant("Давид"),
                new Participant("Сергей"),
                new Participant("Марина"),
                new Participant("Мария")
        ));

        Raffle raf = new Raffle(pq,toys1);
        System.out.println(raf.currentToys.toString());
        raf.runRaffle();

        System.out.println("\nРозыгрыш с вероятностью проиграть\n");
        ParticipantQueue pqloss = new ParticipantQueue();
        for (int i = 1; i <= 10 ; i++){
            pqloss.addParticipant(new Participant());
        }
        Raffle raf2 = new Raffle(pqloss,toys1);
        raf2.setLossWeight(30);
        System.out.println(raf2.currentToys.toString());
        raf2.runRaffle();

        toys1.saveToFile();
    }

}
