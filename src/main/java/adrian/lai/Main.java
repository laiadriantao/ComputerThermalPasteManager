package adrian.lai;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ComputerDAO computerDAO = new ComputerDAO();
        Computer computer1 = new Computer(LocalDate.now());
        computerDAO.saveComputer(computer1);

        Computer computer2 = new Computer();
        computerDAO.saveComputer(computer2);

        List<Computer> computers = computerDAO.getAllComputers();
        computers.forEach(computerget -> System.out.println(computerget.toString()));



    }
}
