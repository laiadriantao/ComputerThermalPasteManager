package adrian.lai;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ComputerDAO computerDAO = new ComputerDAO();
//        Computer computer1 = new Computer(LocalDate.now());
//        computerDAO.saveComputer(computer1);
//
//        Computer computer2 = new Computer();
//        computerDAO.saveComputer(computer2);
//
//        Computer computer3 = new Computer(LocalDate.of(1990, 9,22));
//        computerDAO.saveComputer(computer3);


        List<Computer> computers = computerDAO.getAllComputers();
        computers.forEach(computerget -> System.out.println(computerget.toString()));

        List<Computer> defectivecomputers = computerDAO.getAllDefectiveComputers();
        defectivecomputers.forEach(dcomputerget -> System.out.println(dcomputerget.toString()));




    }
}
