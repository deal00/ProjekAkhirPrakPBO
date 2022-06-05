package pendataanMotor;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }
    
}
