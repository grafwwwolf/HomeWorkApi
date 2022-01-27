public class Team {

    private String teamName;
    private Moveable[] teamArray;
    private int winPoints;

    public Team(String teamName, Moveable teamMate1, Moveable teamMate2, Moveable teamMate3, Moveable teamMate4) {
        this.teamName = teamName;
        this.teamArray = new Moveable[4];
        teamArray[0] = teamMate1;
        teamArray[1] = teamMate2;
        teamArray[2] = teamMate3;
        teamArray[3] = teamMate4;
    }

    public String getTeamName() {

        return teamName;
    }

    public Moveable[] getTeamArray() {

        return teamArray;
    }

    public int getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(int winPoints) {
        this.winPoints = winPoints;
    }

    public void printTeamInfo() {
        System.out.println("Команда: " + getTeamName() + ".");
        System.out.println("Информация об участниках:");
        for (int i = 0; i < teamArray.length; i++) {
            if (teamArray[i] instanceof Human) {
                System.out.println("Человек " + ((Human) teamArray[i]).getName() + " максимальная дальность бега: " + ((Human) teamArray[i]).getMaxRun() + "," + " максимальная высота прыжка: " + ((Human) teamArray[i]).getMaxJump());
            } else if (teamArray[i] instanceof Cat) {
                System.out.println("Кот " + ((Cat) teamArray[i]).getName() + " максимальная дальность бега: " + ((Cat) teamArray[i]).getMaxRun() + "," + " максимальная высота прыжка: " + ((Cat) teamArray[i]).getMaxJump());
            } else if (teamArray[i] instanceof Robot) {
                System.out.println("Робот " + ((Robot) teamArray[i]).getName() + " максимальная дальность бега: " + ((Robot) teamArray[i]).getMaxRun() + "," + " максимальная высота прыжка: " + ((Robot) teamArray[i]).getMaxJump());
            }
        }
    }

    public void showResults() {
        if (winPoints < 1) {
            System.out.println("Никто из команды " + teamName + " не смог пройти препядствия!");
        } else {
            System.out.println("Наши победители:");
            for (int i = 0; i < teamArray.length; i++) {
                if (teamArray[i] instanceof Human) {
                    if (((Human) teamArray[i]).isFinished()) {
                        System.out.println("Человек " + ((Human) teamArray[i]).getName() + " максимальная дальность бега: " + ((Human) teamArray[i]).getMaxRun() + "," + " максимальная высота прыжка: " + ((Human) teamArray[i]).getMaxJump());
                    }
                } else if (teamArray[i] instanceof Cat) {
                    if (((Cat) teamArray[i]).isFinished()) {
                        System.out.println("Кот " + ((Cat) teamArray[i]).getName() + " максимальная дальность бега: " + ((Cat) teamArray[i]).getMaxRun() + "," + " максимальная высота прыжка: " + ((Cat) teamArray[i]).getMaxJump());
                    }
                } else if (teamArray[i] instanceof Robot) {
                    if (((Robot) teamArray[i]).isFinished()) {
                        System.out.println("Робот " + ((Robot) teamArray[i]).getName() + " максимальная дальность бега: " + ((Robot) teamArray[i]).getMaxRun() + "," + " максимальная высота прыжка: " + ((Robot) teamArray[i]).getMaxJump());
                    }
                }
            }
        }
    }
}
