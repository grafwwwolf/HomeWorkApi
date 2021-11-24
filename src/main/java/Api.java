import java.util.Arrays;
import java.util.Random;

public class Api {

    public static void main(String[] args) {

        Moveable[] team = new Moveable[6];

        team[0] = new Human("Стас");
        team[1] = new Human("Антон");
        team[2] = new Cat("Барсик");
        team[3] = new Cat("Борис");
        team[4] = new Robot("Бендер");
        team[5] = new Robot("Оптимус Прайм");

        Preventsable[] barriers = {new Wall(), new Treadmill(), new Treadmill(), new Wall()};

        // задание 3
        overcomingObstacles(team, barriers);
        //конец задания 3
        //Дальше идут задания 4, 5, 6!!!

        Course course = new Course(barriers);

        Team team2 = new Team("DeamTeam", new Human("Стас"), new Cat("Барсик"), new Cat("Борис"), new Robot("Бендер"));
        team2.printTeamInfo();       //печатаем инфо о команде

        course.doIt(team2);

        team2.showResults();        // печатаем инфо о членах команды, которые прошли полосу, если кто-то смог ее пройти.

    }

    public static void overcomingObstacles(Moveable[] team, Preventsable[] barriers) {
        System.out.println("Эстафета стартовала!!!");
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                if (team[i] instanceof Human) {
                    ((Human) team[i]).setFinished(true);
                    ((Human) team[i]).move(barriers[j]);
                    if (((Human) team[i]).isFinished() == false) {
                        break;
                    }
                } else if (team[i] instanceof Cat) {
                    ((Cat) team[i]).setFinished(true);
                    ((Cat) team[i]).move(barriers[j]);
                    if (((Cat) team[i]).isFinished() == false) {
                        break;
                    }
                } else if (team[i] instanceof Robot) {
                    ((Robot) team[i]).setFinished(true);
                    ((Robot) team[i]).move(barriers[j]);
                    if (((Robot) team[i]).isFinished() == false) {
                        break;
                    }
                }
            }
        }
        System.out.println("Эстафета окончена!!!");
    }
}
