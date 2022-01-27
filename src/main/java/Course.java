public class Course {

    private Preventsable[] barriers;

    public Course(Preventsable[] barriers) {
        this.barriers = barriers;
    }

    public Preventsable[] getBarriers() {
        return barriers;
    }

    public void doIt(Team team) {
        System.out.println("---------------------------------------");
        System.out.println("!!!!!__С_Т_А_РТ__!!!!");
        System.out.println("---------------------------------------");
        team.setWinPoints(4);
        for (int i = 0; i < team.getTeamArray().length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                if (team.getTeamArray()[i] instanceof Human) {
                    ((Human) team.getTeamArray()[i]).setFinished(true);
                    ((Human) team.getTeamArray()[i]).move(barriers[j]);
                    if (((Human) team.getTeamArray()[i]).isFinished() == false) {
                        team.setWinPoints(team.getWinPoints() -1 );
                        break;
                    }
                } else if (team.getTeamArray()[i] instanceof Cat) {
                    ((Cat) team.getTeamArray()[i]).setFinished(true);
                    ((Cat) team.getTeamArray()[i]).move(barriers[j]);
                    if (((Cat) team.getTeamArray()[i]).isFinished() == false) {
                        team.setWinPoints(team.getWinPoints() -1 );
                        break;
                    }
                } else if (team.getTeamArray()[i] instanceof Robot) {
                    ((Robot) team.getTeamArray()[i]).setFinished(true);
                    ((Robot) team.getTeamArray()[i]).move(barriers[j]);
                    if (((Robot) team.getTeamArray()[i]).isFinished() == false) {
                        team.setWinPoints(team.getWinPoints() -1 );
                        break;
                    }
                }
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("!!!!!__Ф_И_Н_И_Ш__!!!!");
        System.out.println("---------------------------------------");
    }
}
