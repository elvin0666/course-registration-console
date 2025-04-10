import service.Database;
import service.EducationService;

public class Application {

    public void main(String[] args) {
        while (true) {
            boolean isSave ="save-tofile".equalsIgnoreCase(args.length>0?args[0]:"");

            Database.initialize(isSave);


            EducationService.chooseService(isSave).chooseAndExecuteSelectedMenu();
        }
    }

}
